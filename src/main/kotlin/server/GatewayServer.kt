package server

import com.natpryce.konfig.Configuration
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.flywaydb.core.Flyway
import java.time.Clock
import java.util.Properties
import org.http4k.events.Events

class GatewayServer(private val environment: Environment) {
    fun start() {
        val flyway = Flyway.configure()
            .driver("org.postgresql.Driver")
            .dataSource("jdbc:postgresql://localhost:5432/battlehubs", "postgres", "password")
            .load()

        flyway.migrate()
    }
}

fun main(args: Array<String>) {
    val environment = if(args.isNotEmpty()) Environment.valueOf(args[0].uppercase()) else Environment.LOCAL
    GatewayServer(environment).start()
}