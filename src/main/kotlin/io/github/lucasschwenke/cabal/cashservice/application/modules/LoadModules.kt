package io.github.lucasschwenke.cabal.cashservice.application.modules

import org.koin.core.context.startKoin

fun loadModules() {
    startKoin {
        modules(
            applicationModules,
            databaseModules,
            serviceModules,
            controllerModules,
            validatorModules
        )
    }
}
