package io.github.lucasschwenke.cabal.cashservice.domain.services

import io.github.lucasschwenke.cabal.cashservice.domain.cashaccount.CashAccount
import io.github.lucasschwenke.cabal.cashservice.domain.cashaccount.CreateCashAccount
import io.github.lucasschwenke.cabal.cashservice.domain.repositories.CashAccountRepository

class CashAccountService(
    private val cashAccountRepository: CashAccountRepository
) {

    fun create(createCashAccount: CreateCashAccount): CashAccount {
        val newCashAccount = CashAccount(
            username = createCashAccount.username,
            userNum = createCashAccount.userNum,
            cash = INITIAL_CASH,
            cashBonus = INITIAL_CASH
        )

        return cashAccountRepository.insertCashAccount(newCashAccount)
    }

    companion object {
        private const val INITIAL_CASH = 0
    }
}
