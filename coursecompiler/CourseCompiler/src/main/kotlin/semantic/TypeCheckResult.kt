package semantic

import common.Type

class TypeCheckResult(val isValid: Boolean, val type: Type?) {
    var line = 0
    var column = 0
}