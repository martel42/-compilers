package context

import common.Type
import semantic.exceptions.AlreadyDefinedException
import syntaxtree.statements.LocalVarDecl
import syntaxtree.structure.MethodParameter
import java.util.*
import kotlin.collections.HashMap


class ScopeContext {
    private val localVars: Stack<HashMap<String?, Type?>>

    init {
        localVars = Stack()
    }

    fun addLocalVar(name: String?, type: Type?) {
        if (this.contains(name)) {
            throw AlreadyDefinedException("Variable $name already exists in this scope")
        }
        localVars.peek()[name] = type
    }

    fun clear() {
        localVars.clear()
    }

    fun pushScope() {
        localVars.push(HashMap())
    }

    fun popScope() {
        localVars.pop()
    }

    fun getLocalVar(name: String?): Type? {
        for (map in localVars) {
            if (map.containsKey(name)) {
                return map[name]
            }
        }
        return null
    }

    operator fun contains(name: String?): Boolean {
        for (map in localVars) {
            if (map.containsKey(name)) {
                return true
            }
        }
        return false
    }

    fun addLocalVar(localVarDecl: LocalVarDecl) {
        addLocalVar(localVarDecl.identifier, localVarDecl.type)
    }
    fun addLocalVar(parameter: MethodParameter) {
        addLocalVar(parameter.identifier, parameter.type)
    }
}
