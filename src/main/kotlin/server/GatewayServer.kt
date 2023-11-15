package server

import api.BattlehubsDependencies.Companion.createBattlehubsDependencies
import java.time.Clock
class GatewayServer(private val environment: Environment) {
    fun start() {
        val clock = Clock.systemUTC()
        val configuration = getConfiguration(environment)

        /** Create dependencies for all services within battlehubs */
        val battlehubsDependencies = createBattlehubsDependencies(clock = clock, config = configuration)

        /** Start jobs for all services within battlehubs */
        battlehubsDependencies.onStart()
    }
}

fun main(args: Array<String>) {
    val environment = if(args.isNotEmpty()) Environment.valueOf(args[0].uppercase()) else Environment.LOCAL
    GatewayServer(environment).start()
}