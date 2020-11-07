package io.github.lucasschwenke.cabal.cashservice.domain.exceptions

abstract class ApiException(
    message: String
) : Exception(message) {

    abstract fun httpStatus(): Int
    abstract fun apiError(): ApiError
    abstract fun userResponseMessage(): String
    abstract fun details(): Map<String, List<Any>>

    fun createErrorResponse() =
        ErrorResponse(
            apiError = apiError(),
            message = userResponseMessage(),
            details = details()
        )
}
