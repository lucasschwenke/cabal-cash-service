package io.github.lucasschwenke.cabal.cashservice.domain.exceptions

import com.fasterxml.jackson.annotation.JsonProperty

data class ErrorResponse(
    @JsonProperty("api_error") val apiError: ApiError,
    val message: String,
    val details: Map<String, List<Any>>
)
