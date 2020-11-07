package io.github.lucasschwenke.cabal.cashservice.application.modules

import io.github.lucasschwenke.cabal.cashservice.application.web.controllers.CashAccountController
import org.koin.dsl.module

val controllerModules = module {
    single {
        CashAccountController(
            cashAccountService = get()
        )
    }
}
