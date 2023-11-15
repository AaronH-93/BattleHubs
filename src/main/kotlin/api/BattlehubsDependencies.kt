package api

import com.natpryce.konfig.Configuration
import org.flywaydb.core.Flyway
import org.jooq.DSLContext
import java.time.Clock

class BattlehubsDependencies(val context: DSLContext, val clock: Clock, val config: Configuration) {

//    private val battlehubsRepositories: Nothing = TODO() // BattlehubsRepositories(context, clock)
//    private val services: Nothing = TODO() // BattlehubsServices(BattlehubsRepositories, clock, config)
//    private val routes: Nothing = TODO() // BattlehubsRoutes(services, events)
//    private val api: Nothing = TODO() // routingHttpHandler(routes)
//    val httpApi: Nothing = TODO() // BattlehubsHttpApi(api, routes)

    fun onStart() {
        val flyway = Flyway.configure()
            .driver("org.postgresql.Driver")
            .dataSource("jdbc:postgresql://localhost:5432/battlehubs", "postgres", "password")
            .load()

        flyway.migrate()
    }

    companion object {
        fun createBattlehubsDependencies(
            clock: Clock = Clock.systemUTC(),
            context: DSLContext? = null,
            config: Configuration,
        ): BattlehubsDependencies {
            val dbContext: DSLContext = context ?: DatabaseContext(config, clock)
            return BattlehubsDependencies(dbContext, clock, config)
        }
    }
}

