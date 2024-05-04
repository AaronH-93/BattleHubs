package api

import com.natpryce.konfig.Configuration
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.jooq.DSLContext
import org.jooq.SQLDialect
import org.jooq.impl.DSL
import org.jooq.impl.DefaultConfiguration
import java.time.Clock
import java.util.*

object DatabaseContext {
    operator fun invoke(config: Configuration, clock: Clock): DSLContext {
        val hikariConfig = HikariConfig().apply {
            val properties = Properties()
            properties.setProperty("ApplicationName", "transactions")
            //TODO: Set these properly
            jdbcUrl = "jdbc:postgresql://0.0.0.0:5432/postgres"
            username = "postgres"
            password = "password"
            dataSourceProperties = properties
        }
        val hikariDataSource = HikariDataSource(hikariConfig).also { it.maximumPoolSize = 15 }
        val jooqConfig = DefaultConfiguration()
        jooqConfig.set(hikariDataSource)
        jooqConfig.set(SQLDialect.POSTGRES)
        return DSL.using(jooqConfig)
    }
}