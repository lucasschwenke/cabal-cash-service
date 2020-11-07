package io.github.lucasschwenke.cabal.cashservice.resources.repositories.cash

import io.github.lucasschwenke.cabal.cashservice.domain.cashaccount.CashAccount
import io.github.lucasschwenke.cabal.cashservice.domain.logs.LogTags
import io.github.lucasschwenke.cabal.cashservice.domain.repositories.CashAccountRepository
import io.github.lucasschwenke.cabal.cashservice.resources.repositories.cash.entity.CashAccountEntity
import io.github.lucasschwenke.logging.LoggableClass
import org.jdbi.v3.core.Jdbi
import org.jdbi.v3.core.kotlin.withHandleUnchecked
import org.jdbi.v3.core.locator.ClasspathSqlLocator

class SqlCashAccountRepository(private val jdbi: Jdbi) : CashAccountRepository {

    override fun insertCashAccount(cashAccount: CashAccount): CashAccount {
        logger.debug(LogTags.REPOSITORY) {
            "creating new cash account for the username ${cashAccount.username}"
        }

        val cashAccountEntity = CashAccountEntity(
            id = cashAccount.username,
            userNum = cashAccount.userNum,
            cash = cashAccount.cash,
            cashBonus = cashAccount.cashBonus,
            updateDateTime = cashAccount.updatedAt
        )

        jdbi.withHandleUnchecked {
            val query = ClasspathSqlLocator.create().locate("sql.cash_account.insert_cash_account")
            it.createUpdate(query)
                .bind("id", cashAccountEntity.id)
                .bind("userNum", cashAccountEntity.userNum)
                .bind("cash", cashAccountEntity.cash)
                .bind("cashBonus", cashAccountEntity.cashBonus)
                .bind("updateDateTime", cashAccountEntity.updateDateTime)
                .execute()
        }

        return cashAccount
    }

    companion object : LoggableClass()
}
