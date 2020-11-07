package io.github.lucasschwenke.cabal.cashservice.domain.repositories

import io.github.lucasschwenke.cabal.cashservice.domain.cashaccount.CashAccount

interface CashAccountRepository {

    fun insertCashAccount(cashAccount: CashAccount): CashAccount
}
