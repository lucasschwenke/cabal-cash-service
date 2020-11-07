package io.github.lucasschwenke.cabal.cashservice.domain.cashaccount

import java.time.LocalDateTime

data class CashAccount(
    val username: String,
    val userNum: Int,
    val cash: Int,
    val cashBonus: Int,
    val updatedAt: LocalDateTime = LocalDateTime.now()
)
