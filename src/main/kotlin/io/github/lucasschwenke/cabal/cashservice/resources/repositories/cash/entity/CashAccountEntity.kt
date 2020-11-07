package io.github.lucasschwenke.cabal.cashservice.resources.repositories.cash.entity

import java.time.LocalDateTime

data class CashAccountEntity(
    val id: String,
    val userNum: Int,
    val cash: Int,
    val cashBonus: Int,
    val updateDateTime: LocalDateTime
)
