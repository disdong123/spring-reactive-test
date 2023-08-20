plugins {
    id("application")
}
dependencies {
    implementation(libs.spring.boot.starter.webflux)
    implementation(libs.kotlinx.coroutines.core)
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")
    implementation(libs.kotlin.stdlib.jdk8)
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-jdk8:1.5.1")

    // m1
    implementation("io.netty:netty-resolver-dns-native-macos:4.1.68.Final:osx-aarch_64")

    implementation(project(":srt-core"))
}

tasks.getByName("bootJar") {
    enabled = true
}

tasks.getByName("jar") {
    enabled = false
}

application {
    mainClass.set("kr.disdong.spring.reactive.study.webflux.server.master.MasterWebfluxServerApplicationKt")
}
