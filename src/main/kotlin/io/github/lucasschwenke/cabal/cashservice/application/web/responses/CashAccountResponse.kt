package io.github.lucasschwenke.cabal.cashservice.application.web.responses

import java.time.LocalDateTime

data class CashAccountResponse(
    val username: String,
    val cash: Int,
    val cashBonus: Int,
    val updatedAt: LocalDateTime = LocalDateTime.now()
)
