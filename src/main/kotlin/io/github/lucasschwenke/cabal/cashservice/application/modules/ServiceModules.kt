package io.github.lucasschwenke.cabal.cashservice.application.modules

import io.github.lucasschwenke.cabal.cashservice.domain.services.CashAccountService
import org.koin.dsl.module

val serviceModules = module {

    single {
        CashAccountService(
            cashAccountRepository = get()
        )
    }
}
