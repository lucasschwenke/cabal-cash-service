package io.github.lucasschwenke.cabal.cashservice.application.web.handlers

import com.fasterxml.jackson.databind.ObjectMapper
import io.github.lucasschwenke.cabal.cashservice.application.web.constants.APPLICATION_JSON_CHARSET_UTF_8
import io.github.lucasschwenke.cabal.cashservice.application.web.constants.CONTENT_TYPE
import io.github.lucasschwenke.cabal.cashservice.domain.exceptions.ApiError
import io.github.lucasschwenke.cabal.cashservice.domain.exceptions.ApiException
import io.github.lucasschwenke.cabal.cashservice.domain.exceptions.ErrorResponse
import io.github.lucasschwenke.cabal.cashservice.domain.logs.LogTags
import io.github.lucasschwenke.logging.LoggableClass
import io.netty.handler.codec.http.HttpResponseStatus
import io.vertx.ext.web.Router
import io.vertx.ext.web.RoutingContext
import org.koin.core.KoinComponent
import org.koin.core.inject

object FailureHandler : KoinComponent, LoggableClass() {

    private val objectMapper: ObjectMapper by inject()

    fun handle(router: Router) {
        router.route().failureHandler {
            if (it.failed()) {
                when (val throwable = it.failure()) {
                    is ApiException -> buildApiExceptionResponse(it, throwable)
                    else -> buildDefaultErrorResponse(it, throwable)
                }
            }
        }
    }

    private fun buildApiExceptionResponse(routingContext: RoutingContext, apiException: ApiException) {
        errorLog(apiException)

        routingContext.response()
            .setStatusCode(apiException.httpStatus())
            .putHeader(CONTENT_TYPE, APPLICATION_JSON_CHARSET_UTF_8)
            .end(objectMapper.writeValueAsString(apiException.createErrorResponse()))
    }

    private fun buildDefaultErrorResponse(routingContext: RoutingContext, throwable: Throwable) {
        errorLog(throwable)

        val response = ErrorResponse(
            apiError = ApiError.INTERNAL_SERVER_ERROR,
            message = "An error occurred, please contact the server administrator.",
            details = mapOf("error" to listOf(throwable.localizedMessage))
        )

        routingContext.response()
            .setStatusCode(HttpResponseStatus.INTERNAL_SERVER_ERROR.code())
            .putHeader(CONTENT_TYPE, APPLICATION_JSON_CHARSET_UTF_8)
            .end(objectMapper.writeValueAsString(response))
    }

    private fun errorLog(throwable: Throwable) {
        logger.error(throwable, LogTags.EXCEPTION) {
            "The follow exception has occurred:"
        }
    }
}
