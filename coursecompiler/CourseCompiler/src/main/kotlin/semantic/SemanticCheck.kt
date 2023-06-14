package semantic

import common.*
import context.*
import semantic.exceptions.*
import syntaxtree.expressions.*
import syntaxtree.statementexpression.Assign
import syntaxtree.statementexpression.CrementStmtExpr
import syntaxtree.statementexpression.MethodCall
import syntaxtree.statementexpression.NewDecl
import syntaxtree.statements.*
import syntaxtree.structure.*
import visitor.SemanticVisitor

class SemanticCheck : SemanticVisitor {
    private var context: Context? = null
    private var currentClass: ClassDecl? = null
    private val currentFields = ArrayList<String?>()
    private var currentMethodReturnType: Type? = null
    private var currentNullType: Type? = null
    private var fileName: String? = null
    private var currentLocalScope: ScopeContext? = null
    var errors = ArrayList<Exception>()
    override fun typeCheck(toCheck: Program): TypeCheckResult {
        context = Context(toCheck)
        toCheck.context = context
        currentLocalScope = ScopeContext()
        var valid = true
        for (classDecl in toCheck.classes) {
            valid = classDecl!!.accept(this)!!.isValid && valid
        }
        return TypeCheckResult(valid, null)
    }
    override fun typeCheck(toCheck: ClassDecl): TypeCheckResult {
        var valid = true
        currentClass = toCheck // For the Class-Context
        if (fileName == null) {
            fileName = toCheck.identifier + ".java"
        }
        val identifiers = PrintableVector<String?>()
        currentFields.clear()
        for (field in toCheck.fieldDelcarations) {
            val result = field!!.accept(this)
            valid = valid && result!!.isValid
            if (valid) identifiers.add(field.identifier)
        }
        if (toCheck.constructorDeclarations.isEmpty()) {
            ConstructorDecl().accept(this)
        } else {
            for (constructorDecl in toCheck.constructorDeclarations) {
                valid = constructorDecl!!.accept(this)!!.isValid && valid
            }
        }
        for (methodDecl in toCheck.methodDeclarations) {
            valid = methodDecl!!.accept(this)!!.isValid && valid
        }
        return TypeCheckResult(valid, ReferenceType(toCheck.identifier))
    }
    override fun typeCheck(toCheck: FieldDecl): TypeCheckResult {
        var valid = true
        if (currentFields.contains(toCheck.identifier)) {
            errors.add(AlreadyDefinedException(
                    "Field " + toCheck.identifier + " is already defined in class " + currentClass!!.identifier
                            + TypeHelper.generateLocationString(toCheck.line, toCheck.column, fileName!!)))
            valid = false
        } else {
            currentFields.add(toCheck.identifier)
        }
        valid = valid && TypeHelper.typeExists(toCheck.type!!, context!!)
        return TypeCheckResult(valid, toCheck.type)
    }
    override fun typeCheck(toCheck: CrementStmtExpr): TypeCheckResult {
        var valid = true
        toCheck.expression.accept(this)
        val type = toCheck.expression.type
        if (type is BaseType && (type.identifier == Primitives.INT
                        || type.identifier == Primitives.CHAR)) {
            toCheck.type = toCheck.expression.type
        } else {
            valid = false
            errors.add(TypeMismatchException("The Operator: " + toCheck.operator
                    + " is undefined for the argument type: " + toCheck.expression.type
                    + TypeHelper.generateLocationString(toCheck.line, toCheck.column, fileName!!)))
        }
        return TypeCheckResult(valid, null)
    }
    override fun typeCheck(toCheck: ConstructorDecl): TypeCheckResult {
        var valid = true
        currentLocalScope!!.pushScope()
        for (parameter in toCheck.parameterDeclarations) {
            val result = parameter!!.accept(this)
            valid = valid && result!!.isValid
            currentLocalScope!!.addLocalVar(parameter)
        }
        currentMethodReturnType = BaseType(Primitives.VOID)
        val result = toCheck.block.accept(this)
        currentLocalScope!!.popScope()
        if (result!!.type != null && result.type !== BaseType(Primitives.VOID)) {
            errors.add(TypeMismatchException(
                    "The return-Type of a Constructor must always be void " +
                            TypeHelper.generateLocationString(toCheck.line, toCheck.column, fileName!!)))
            valid = false
        }
        valid = result!!.isValid && valid
        return TypeCheckResult(valid, toCheck.type)
    }
    override fun typeCheck(methodDecl: MethodDecl): TypeCheckResult {
        var valid = true
        for (otherMethod in currentClass!!.methodDeclarations) {
            if (otherMethod == methodDecl) break
            if (otherMethod!!.isSameDeclaration(methodDecl)) {
                errors.add(AlreadyDefinedException(
                        "Method " + methodDecl.identifier + " is already defined in class "
                                + currentClass!!.identifier
                                + TypeHelper.generateLocationString(methodDecl.line, methodDecl.column, fileName!!)))
                valid = false
            }
        }
        currentLocalScope!!.pushScope()
        for (parameter in methodDecl.parameters) {
            val result = parameter!!.accept(this)
            valid = valid && result!!.isValid
            currentLocalScope!!.addLocalVar(parameter)
        }
        // Check if this method is already declared
        currentMethodReturnType = methodDecl.type
        currentNullType = currentMethodReturnType // Solange nicht in einem Assign oder Methoden-Aufruf dieser Typ
        // gesetzt ist, ist dieser der Rückgabewert der Methode
        val result = methodDecl.block.accept(this)
        valid = valid && result!!.isValid
        currentLocalScope!!.popScope()
        var resultType = result!!.type
        if (resultType == null) {
            resultType = BaseType(Primitives.VOID)
        }
        if (resultType != methodDecl.type) {
            errors.add(TypeMismatchException("Method-Declaration " + methodDecl.identifier + " with type "
                    + methodDecl.type + " has at least one Mismatching return Type:"
                    + TypeHelper.generateLocationString(methodDecl.line, methodDecl.column, fileName!!)))
            valid = false
        }
        return TypeCheckResult(valid, resultType)
    }
    override fun typeCheck(toCheck: Assign): TypeCheckResult {
        val lExpression = toCheck.getlExpression()
        val oldNullType = currentNullType
        currentNullType = toCheck.getlExpression().type
        val rExpression = toCheck.getrExpression()
        currentNullType = oldNullType
        var valid = true

        // This check currently handles things like :
        if (lExpression == rExpression) {
            errors.add(TypeMismatchException("Cannot assign to self"
                    + TypeHelper.generateLocationString(toCheck.line, toCheck.column, fileName!!)))
            valid = false
        }
        val lResult = lExpression!!.accept(this)
        currentNullType = lResult!!.type
        val rResult = rExpression!!.accept(this)
        if (lExpression.type != rExpression.type) {
            errors.add(TypeMismatchException(
                    "Mismatch types in Assign-Statement: cannot convert from \"" + lResult.type + "\" to \""
                            + rResult!!.type + "\""
                            + TypeHelper.generateLocationString(toCheck.line, toCheck.column, fileName!!)))
            valid = false
        } else {
            toCheck.type = lExpression.type
        }
        valid = valid && lResult!!.isValid && rResult!!.isValid
        currentNullType = null
        return TypeCheckResult(valid, null) // return type is null to get the return type sufficently
    }
    override fun typeCheck(toCheck: MethodParameter): TypeCheckResult {
        return if (TypeHelper.typeExists(toCheck.type!!, context!!)) {
            TypeCheckResult(true, toCheck.type)
        } else {
            errors.add(TypeUnkown("Type: " + toCheck.type + " is unknown"
                    + TypeHelper.generateLocationString(toCheck.line, toCheck.column, fileName!!)))
            TypeCheckResult(false, toCheck.type)
        }
    }
    override fun typeCheck(whileStmt: WhileStmt): TypeCheckResult {

        // check type in the while expression/condition
        var valid = true
        val conditionBool = whileStmt.expression.accept(this)
        valid = valid && conditionBool!!.isValid
        if (!TypeHelper.isBool(conditionBool!!.type)) {
            errors.add(
                    TypeMismatchException(
                            "While Condition expected " + Primitives.BOOL + " but got " + conditionBool.type
                                    + TypeHelper.generateLocationString(whileStmt.line, whileStmt.column, fileName!!)))
            valid = false
        }
        // check block
        val blockResult = whileStmt.block.accept(this)
        whileStmt.type = blockResult!!.type
        valid = valid && conditionBool!!.isValid && blockResult!!.isValid && TypeHelper.isBool(conditionBool.type)
        return TypeCheckResult(valid, blockResult.type)
    }
    override fun typeCheck(returnStmt: ReturnStmt): TypeCheckResult {
        val returnExpression: TypeCheckResult?

        // Following check is needed for a void return (void foo(){return;})
        if (returnStmt.expression == null) {
            returnExpression = TypeCheckResult(true, BaseType(Primitives.VOID))
            returnStmt.type = BaseType(Primitives.VOID)
        } else {
            returnExpression = returnStmt.expression!!.accept(this)
            returnStmt.type = returnStmt.expression!!.type
        }
        if (currentMethodReturnType != null && currentMethodReturnType != returnStmt.type) {
            errors.add(
                    TypeMismatchException("Return-Type mismatch:  cannot convert from " + returnExpression!!.type
                            + " to " + currentMethodReturnType
                            + TypeHelper.generateLocationString(returnStmt.line, returnStmt.column, fileName!!)))
            return TypeCheckResult(false, returnExpression.type)
        }
        return TypeCheckResult(true, returnStmt.type)
    }
    override fun typeCheck(localVarDecl: LocalVarDecl): TypeCheckResult {
        var valid = true
        if (localVarDecl.expression != null) {
            val result = localVarDecl.expression!!.accept(this)
            val resultType = localVarDecl.expression!!.type
            valid = result!!.isValid && valid
            if (resultType != localVarDecl.type) {
                errors.add(TypeMismatchException(
                        "Type mismatch: cannot convert from " + resultType + " to " + localVarDecl.type
                                + TypeHelper.generateLocationString(localVarDecl.line, localVarDecl.column, fileName!!)))
                valid = false
            }
        }
        try {
            currentLocalScope!!.addLocalVar(localVarDecl)
        } catch (e: AlreadyDefinedException) {
            errors.add(AlreadyDefinedException(e.message + TypeHelper.generateLocationString(localVarDecl.line,
                    localVarDecl.column, fileName!!)))
            valid = false
        }
        return TypeCheckResult(valid, null)
    }
    override fun typeCheck(ifStmt: IfStmt): TypeCheckResult {
        var valid = true
        // check the Condition
        val conditionResult = ifStmt.condition.accept(this)
        valid = valid && conditionResult!!.isValid
        if (!TypeHelper.isBool(ifStmt.condition.type)) {
            errors.add(
                    TypeMismatchException(
                            "If Condition expected " + Primitives.BOOL + " but got " + conditionResult!!.type
                                    + TypeHelper.generateLocationString(ifStmt.line, ifStmt.column, fileName!!)))
            valid = false
        }

        // check the if block
        val ifBlockResult = ifStmt.blockIf.accept(this)
        valid = valid && ifBlockResult!!.isValid

        // check the else block
        if (ifStmt.blockElse != null) {
            val elseBlockResult = ifStmt.blockElse!!.accept(this)
            valid = valid && elseBlockResult!!.isValid
            val elseType = elseBlockResult!!.type

            // Folgendes if else ist für die Bestimmung des Rückgabetyps
            if (ifBlockResult!!.type == null && elseType != null) { // Falls einer der Blöcke keinen return type hat,
                // dann wird der Rückgabetyp des anderen gewählt
                ifStmt.type = elseType
            } else if (ifBlockResult.type != null && elseType == null) {
                ifStmt.type = ifBlockResult.type
            } else if (ifBlockResult.type != null && elseType != null) { // Wenn beide ungleich null sind, dann
                // müssen beide Typen übereinstimmen
                // (Hätten wir vererbung müssten wir jetzt
                // prüfen ob die Typen Unterklassen eines
                // Obertyps sind...)
                if (elseType != ifBlockResult.type) {
                    errors.add(TypeMismatchException(
                            "Type mismatch: cannot convert from " + elseType + " to " + ifBlockResult.type
                                    + TypeHelper.generateLocationString(ifStmt.line, ifStmt.column, fileName!!)))
                    valid = false
                } else {
                    ifStmt.type = ifBlockResult.type // Falls der Typ gleich ist, wähle einen der beiden Typen
                    // als Rückgabetyp aus
                }
            }
        } else {
            ifStmt.type = ifBlockResult!!.type
        }
        return TypeCheckResult(valid, ifStmt.type)
    }
    override fun typeCheck(block: Block): TypeCheckResult {
        val statements = block.statements
        var valid = true
        var blockReturnType: Type? = null
        currentLocalScope!!.pushScope()
        for (statement in statements!!) {
            val result = statement!!.accept(this)
            val statementReturnType = result!!.type
            if (statementReturnType != null) { // Wenn StatmentReturnType null ist, dann ändert sich der Block return
                // type nicht
                if (blockReturnType == null) { // Initiale setzen des Return type
                    blockReturnType = result.type
                } else {
                    if (blockReturnType != result.type) { // wenn es 2 verschiedene return types gibt, dann
                        // ist es
                        // fehlerhaft
                        errors.add(TypeMismatchException(
                                "Return types are mismatching in a single Block, got:" + blockReturnType
                                        + " and " + result.type
                                        + TypeHelper.generateLocationString(block.line, block.column, fileName!!)))
                        valid = false
                    }
                }
            }
            valid = valid && result!!.isValid
        }
        currentLocalScope!!.popScope()
        block.type = blockReturnType
        return TypeCheckResult(valid, blockReturnType)
    }
    override fun typeCheck(newDecl: NewDecl): TypeCheckResult {
        var valid = true
        val newClass = newDecl.type
        if (!TypeHelper.typeExists(newClass, context!!)) {
            errors.add(TypeUnkown("Type: " + newClass + " is unknown"
                    + TypeHelper.generateLocationString(newDecl.line, newDecl.column, fileName!!)))
            valid = false
        }
        for (arguments in newDecl.arguments) {
            val result = arguments!!.accept(this)
            valid = valid && result!!.isValid
        }
        try {
            TypeHelper.getConstructor(newDecl, context!!)
        } catch (e: TypeMismatchException) {
            errors.add(SemanticError(e.message + TypeHelper.generateLocationString(newDecl.line,
                    newDecl.column, fileName!!)))
            valid = false
        }
        return TypeCheckResult(valid, null)
    }
    override fun typeCheck(methodCall: MethodCall): TypeCheckResult {
        var valid = true
        val receiver = methodCall.receiver!!.accept(this)
        valid = valid && receiver!!.isValid
        for (parameter in methodCall.arguments) {
            val parameterResult = parameter!!.accept(this)
            valid = valid && parameterResult!!.isValid
        }
        return try {
            val method = TypeHelper.getMethodInType(methodCall, methodCall!!.receiver!!.type!!, context!!,
                    currentClass!!)
            val returnType = method!!.type
            methodCall.type = (returnType)
            TypeCheckResult(valid, null)
        } catch (e: TypeMismatchException) {
            errors.add(SemanticError(e.message + TypeHelper.generateLocationString(methodCall.line,
                    methodCall.column, fileName!!)))
            TypeCheckResult(false, null)
        }
        // null
    }
    override fun typeCheck(unary: Unary): TypeCheckResult {
        var valid = true
        val result = unary.expression.accept(this)
        valid = valid && result!!.isValid
        val thrownError = SemanticError("The Operator: " + unary.operator
                + " is undefined for the argument type: " + unary.expression.type
                + TypeHelper.generateLocationString(unary.line, unary.column, fileName!!))
        val isBoolOperator = unary.operator == Operator.NOT
        val isIntOperator = false
        // Check if the unary is valid
        if (unary.expression.type is ReferenceType) {
            errors.add(thrownError)
            valid = false
        } else {
            val expressionType = (unary.expression.type as BaseType).identifier
            when (expressionType) {
                Primitives.BOOL -> {
                    if (!isBoolOperator) {
                        errors.add(thrownError)
                        valid = false
                    }
                }

                Primitives.INT -> {
                    if (!isIntOperator) {
                        errors.add(thrownError)
                        valid = false
                    }
                }

                else -> {
                    errors.add(thrownError)
                    valid = false
                }
            }
        }
        unary.type = unary.expression.type
        return TypeCheckResult(valid, unary.type)
    }
    override fun typeCheck(aThis: This): TypeCheckResult {
        aThis.setType(currentClass!!.identifier!!)
        return TypeCheckResult(true, aThis.type)
    }
    override fun typeCheck(aNull: Null): TypeCheckResult {
        if (currentNullType != null) {
            val assignType = currentNullType
            if (assignType != null) {
                aNull.type = assignType
            }
        } else {
            aNull.type = null
        }
        return TypeCheckResult(true, aNull.type)
    }
    override fun typeCheck(localOrFieldVar: LocalOrFieldVar): TypeCheckResult {

        // check if the variable is declared in the current scope
        val localVar = currentLocalScope!!.getLocalVar(localOrFieldVar.identifier)
        if (localVar != null) {
            localOrFieldVar.type = localVar
            return TypeCheckResult(true, localVar)
        }

        // check if the variable is declared in the current class
        try {
            val fieldVar = TypeHelper.getFieldInType(localOrFieldVar.identifier,
                    ReferenceType(currentClass!!.identifier!!), context!!, currentClass!!)
            if (fieldVar != null) {
                localOrFieldVar.type = fieldVar.type
                return TypeCheckResult(true, fieldVar.type)
            }
        } catch (e: TypeMismatchException) {
            errors.add(SemanticError(e.message + TypeHelper.generateLocationString(localOrFieldVar.line,
                    localOrFieldVar.column, fileName!!)))
            return TypeCheckResult(false, null)
        }
        val importStaticField = context!!.imports[localOrFieldVar.identifier]
        if (importStaticField != null) {
            val importedType = ReferenceType(importStaticField)
            localOrFieldVar.type = importedType
            return TypeCheckResult(true, importedType)
        }
        errors.add(VariableNotDeclaredException(
                "Variable: " + localOrFieldVar.identifier + " is not declared in this scope"
                        + TypeHelper.generateLocationString(localOrFieldVar.line, localOrFieldVar.column, fileName!!)))
        return TypeCheckResult(false, null)
    }
    override fun typeCheck(integerExpr: IntegerExpr): TypeCheckResult {
        return TypeCheckResult(true, integerExpr.type)
    }
    override fun typeCheck(instVar: InstVar): TypeCheckResult {
        var valid = true
        val result = instVar.expression.accept(this) // Hier steht der typ drinne von dem der identifier ist...
        val type = result!!.type
        if (type is BaseType) {
            errors.add(TypeMismatchException(
                    "Type: " + type + ", is a BaseType and does not offer any Instance Variables or Methods"
                            + TypeHelper.generateLocationString(instVar.line, instVar.column, fileName!!)))
            valid = false
        }
        return try {
            val nextInstVar = TypeHelper.getFieldInType(instVar.identifier, type!!, context!!, currentClass!!)

            // Check if the identifier exists in current Type
            if (nextInstVar == null) {
                errors.add(
                        FieldNotFoundException("Field: " + instVar.identifier + " not found in Class: " + type
                                + TypeHelper.generateLocationString(instVar.line, instVar.column, fileName!!)))
                valid = false
            }
            valid = valid && result!!.isValid
            val newType = nextInstVar?.type
            instVar.type = newType
            instVar.setAccessModifier(nextInstVar?.accessModifier)
            TypeCheckResult(valid, newType)
        } catch (e: TypeMismatchException) {
            errors.add(TypeMismatchException(e.message + TypeHelper.generateLocationString(instVar.line,
                    instVar.column, fileName!!)))
            valid = false
            TypeCheckResult(valid, null)
        }
    }
    override fun typeCheck(charExpr: CharExpr): TypeCheckResult {
        return TypeCheckResult(true, charExpr.type)
    }
    override fun typeCheck(boolExpr: BoolExpr): TypeCheckResult {
        return TypeCheckResult(true, boolExpr.type)
    }
    override fun typeCheck(binary: Binary): TypeCheckResult {
        var valid = true
        val lResult = binary.getlExpression().accept(this)
        val oldNullType = currentNullType
        currentNullType = binary.getlExpression().type
        val rResult = binary.getrExpression().accept(this)
        currentNullType = oldNullType
        val lType = binary.getlExpression().type
        val rType = binary.getrExpression().type
        val errorToThrow = TypeMismatchException(
                "The Operator: " + binary.operator + " is undefined for the argument types: "
                        + lType + ", " + rType
                        + TypeHelper.generateLocationString(binary.line, binary.column, fileName!!))

        // Following vars are there to determine the type of the binary expression
        val operator = binary.operator
        val isCompareOperator = binary.operator == Operator.EQUAL || operator == Operator.NOTEQUAL || operator == Operator.LESS || operator == Operator.LESSEQUAL || operator == Operator.GREATER || operator == Operator.GREATEREQUAL
        val isLogicalOperator = operator == Operator.AND || operator == Operator.OR
        val isArithmeticOperator = operator == Operator.PLUS || operator == Operator.MINUS || operator == Operator.MULT || operator == Operator.DIV || operator == Operator.MOD
        val isSame = lType == rType
        val lIsReference = lType is ReferenceType
        val oneIsNull = (lResult!!.type == null) xor (rResult!!.type == null)
        // Unser Compiler kann ja nur BaseType-Operatoren verarbeiten und auch nur 2
        // gleiche Typen
        if (isSame && !lIsReference) { // Wenn 2 gleiche BaseTypes miteinander verglichen werden
            val lBaseType = lType as BaseType
            when (lBaseType.identifier) {
                Primitives.BOOL -> {
                    if (!isLogicalOperator && !isCompareOperator) {
                        errors.add(errorToThrow)
                        valid = false
                    } else {
                        binary.type = BaseType(Primitives.BOOL)
                    }
                }

                Primitives.INT -> {
                    if (!isArithmeticOperator && !isCompareOperator) {
                        errors.add(errorToThrow)
                        valid = false
                    } else {
                        binary.type = BaseType(if (isArithmeticOperator) Primitives.INT else Primitives.BOOL)
                    }
                }

                else -> {
                    errors.add(errorToThrow)
                    binary.type = BaseType(Primitives.VOID)
                    valid = false
                }
            }
        } else if ((isSame || oneIsNull) && lIsReference) { // Wenn 2 Objekte miteinander verglichen werden
            if (operator == Operator.EQUAL || operator == Operator.NOTEQUAL) {
                binary.type = BaseType(Primitives.BOOL)
            } else {
                errors.add(errorToThrow)
                valid = false
            }
        } else if (isCompareOperator && (lType == BaseType(Primitives.CHAR) && rType == BaseType(Primitives.INT)
                        || rType == BaseType(Primitives.CHAR) && lType == BaseType(Primitives.INT))) { // Wenn
            // z.B.
            // 1=='a'...
            binary.type = BaseType(Primitives.BOOL)
        } else {
            errors.add(errorToThrow)
            binary.type = BaseType(Primitives.VOID)
            valid = false
        }
        valid = valid && lResult!!.isValid && rResult!!.isValid
        return TypeCheckResult(valid, binary.type)
    }

    override fun typeCheck(stringExpr: StringExpr): TypeCheckResult {
        return TypeCheckResult(true, stringExpr.type)
    }

    override fun typeCheck(forStmt: ForStmt): TypeCheckResult {
        var valid = true
        currentLocalScope!!.pushScope()
        val initResult = forStmt.init.accept(this)
        val condResult = forStmt.condition.accept(this)
        val updateResult = forStmt.update.accept(this)
        valid = valid && initResult!!.isValid && condResult!!.isValid && updateResult!!.isValid
        val bodyResult = forStmt.statement.accept(this)
        currentLocalScope!!.popScope()
        valid = valid && bodyResult!!.isValid
        forStmt.type = bodyResult!!.type
        return TypeCheckResult(valid, bodyResult.type)
    }

    companion object {
        @Throws(SemanticError::class)
        fun generateTast(program: Program): Program {
            val semanticCheck = SemanticCheck()
            val result = program.accept(semanticCheck)
            return if (result!!.isValid) {
                program
            } else {
                val ANSI_RESET = "\u001B[0m"
                val ANSI_RED = "\u001B[31m"
                var errorString = """
                    
                    $ANSI_RED
                    """.trimIndent()
                for (i in semanticCheck.errors.indices.reversed()) {
                    errorString += semanticCheck.errors[i].message + "\n"
                }
                throw SemanticError(errorString + ANSI_RESET)
            }
        }
    }
}
