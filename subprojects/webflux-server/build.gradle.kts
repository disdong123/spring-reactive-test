dependencies {
    implementation(libs.spring.boot.starter.webflux)
}

tasks.getByName("bootJar") {
    enabled = true
}

tasks.getByName("jar") {
    enabled = false
}