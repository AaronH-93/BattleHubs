package server

import com.natpryce.konfig.ConfigurationProperties
import com.natpryce.konfig.EnvironmentVariables
import com.natpryce.konfig.overriding

enum class Environment {
    LOCAL,
    DEVELOPMENT,
    PROD
}

fun getEnvironment(args: Array<String>) = if(args.isNotEmpty()) Environment.valueOf(args[0]) else Environment.LOCAL

fun getConfiguration(environment: Environment) =
    EnvironmentVariables() overriding
            ConfigurationProperties.fromResource("${environment.name.lowercase()}.properties") overriding
            ConfigurationProperties.fromResource("default.properties")
