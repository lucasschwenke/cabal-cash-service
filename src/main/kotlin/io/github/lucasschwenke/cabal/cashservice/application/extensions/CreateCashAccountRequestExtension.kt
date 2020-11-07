package io.github.lucasschwenke.cabal.cashservice.application.extensions

import io.github.lucasschwenke.cabal.cashservice.application.web.requests.CreateCashAccountRequest
import io.github.lucasschwenke.cabal.cashservice.domain.cashaccount.CreateCashAccount

fun CreateCashAccountRequest.toCreateCashAccount() =
    CreateCashAccount(
        username = this.username,
        userNum = this.userNum
    )
