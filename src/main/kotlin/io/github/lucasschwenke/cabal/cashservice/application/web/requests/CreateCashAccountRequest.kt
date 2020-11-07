package io.github.lucasschwenke.cabal.cashservice.application.web.requests

data class CreateCashAccountRequest(
    val username: String,
    val userNum: Int
)
