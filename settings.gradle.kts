rootProject.name = "gradle-multi-module-template"

include(
    "subprojects:domain",
    "subprojects:domain-jpa",
    "subprojects:server"
)

// https://github.com/gradle/gradle/issues/9830
pluginManagement {
    val kotlinVersion: String by settings
    val springVersion: String by settings

    plugins {
        id("org.springframework.boot") version springVersion
        kotlin("jvm") version kotlinVersion
        kotlin("plugin.spring") version kotlinVersion
        kotlin("kapt") version kotlinVersion
        kotlin("plugin.jpa") version kotlinVersion
    }
}
