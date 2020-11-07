package io.github.lucasschwenke.cabal.cashservice.application.modules

import io.github.lucasschwenke.cabal.cashservice.application.configs.DatabaseConfig
import io.github.lucasschwenke.cabal.cashservice.application.configs.EnvironmentVariablesConfig
import io.github.lucasschwenke.cabal.cashservice.domain.repositories.CashAccountRepository
import io.github.lucasschwenke.cabal.cashservice.resources.repositories.cash.SqlCashAccountRepository
import org.koin.dsl.module

val databaseModules = module {
    single {
        DatabaseConfig.connect(
            databaseJdbcUrl = get<EnvironmentVariablesConfig>().databaseJdbcUrl,
            databaseUsername = get<EnvironmentVariablesConfig>().databaseUsername,
            databasePassword = get<EnvironmentVariablesConfig>().databasePassword,
            databaseDriverClassName = get<EnvironmentVariablesConfig>().databaseDriver,
            databaseConnectionTimeout = get<EnvironmentVariablesConfig>().databaseTimeout,
            databaseValidationTimeout = get<EnvironmentVariablesConfig>().databaseValidationTimeout,
            databaseMaximumPoolSize = get<EnvironmentVariablesConfig>().databaseMaximumPoolSize
        )
    }

    single<CashAccountRepository> {
        SqlCashAccountRepository(
            jdbi = get()
        )
    }
}
