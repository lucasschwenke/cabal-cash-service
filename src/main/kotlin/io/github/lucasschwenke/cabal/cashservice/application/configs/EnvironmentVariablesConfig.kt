package io.github.lucasschwenke.cabal.cashservice.application.configs

import com.natpryce.konfig.*

class EnvironmentVariablesConfig(
    configuration: Configuration = EnvironmentVariables()
) {

    val serverPort = configuration[SERVER_PORT]

    val databaseJdbcUrl = configuration[DATABASE_JDBC_URL]
    val databaseUsername = configuration[DATABASE_USERNAME]
    val databasePassword = configuration[DATABASE_PASSWORD]
    val databaseDriver = configuration[DATABASE_DRIVER]
    val databaseTimeout = configuration[DATABASE_TIMEOUT]
    val databaseValidationTimeout = configuration[DATABASE_VALIDATION_TIMEOUT]
    val databaseMaximumPoolSize = configuration[DATABASE_MAXIMUM_POOL_SIZE]

    companion object {
        private val SERVER_PORT by intType

        private val DATABASE_JDBC_URL by stringType
        private val DATABASE_USERNAME by stringType
        private val DATABASE_PASSWORD by stringType
        private val DATABASE_DRIVER by stringType
        private val DATABASE_TIMEOUT by longType
        private val DATABASE_VALIDATION_TIMEOUT by longType
        private val DATABASE_MAXIMUM_POOL_SIZE by intType
    }
}
