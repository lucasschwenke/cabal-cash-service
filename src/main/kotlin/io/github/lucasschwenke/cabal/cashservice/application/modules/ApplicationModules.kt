package io.github.lucasschwenke.cabal.cashservice.application.modules

import io.github.lucasschwenke.cabal.cashservice.application.configs.EnvironmentVariablesConfig
import io.github.lucasschwenke.cabal.cashservice.application.web.handlers.FailureHandler
import io.github.lucasschwenke.cabal.cashservice.application.web.routes.Routes
import io.github.lucasschwenke.cabal.cashservice.application.configs.configJsonMapper
import org.koin.dsl.module

val applicationModules = module {
    single { EnvironmentVariablesConfig() }
    single { configJsonMapper() }
    single { Routes }
    single { FailureHandler }
}
