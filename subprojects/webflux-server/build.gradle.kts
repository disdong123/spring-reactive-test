plugins {
    id("application")
}
dependencies {
    implementation(libs.spring.boot.starter.webflux)
}

tasks.getByName("bootJar") {
    enabled = true
}

tasks.getByName("jar") {
    enabled = false
}

application {
    mainClass.set("kr.disdong.spring.study.webflux.server.master.MasterWebfluxServerApplicationKt")
}
