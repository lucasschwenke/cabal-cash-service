package io.github.lucasschwenke.cabal.cashservice.application.web.controllers

import io.github.lucasschwenke.cabal.cashservice.application.extensions.toCreateCashAccount
import io.github.lucasschwenke.cabal.cashservice.application.web.requests.CreateCashAccountRequest
import io.github.lucasschwenke.cabal.cashservice.application.web.responses.CashAccountResponse
import io.github.lucasschwenke.cabal.cashservice.domain.services.CashAccountService

class CashAccountController(private val cashAccountService: CashAccountService) {

    fun createNewCashAccount(createCashAccountRequest: CreateCashAccountRequest): CashAccountResponse {
        val createdCashAccount = cashAccountService.create(createCashAccountRequest.toCreateCashAccount())

        return CashAccountResponse(
            username = createdCashAccount.username,
            cash = createdCashAccount.cash,
            cashBonus = createdCashAccount.cashBonus,
            updatedAt = createdCashAccount.updatedAt
        )
    }
}
