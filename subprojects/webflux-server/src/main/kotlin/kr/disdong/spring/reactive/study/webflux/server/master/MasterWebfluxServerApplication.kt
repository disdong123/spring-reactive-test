package kr.disdong.spring.reactive.study.webflux.server.master

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MasterWebfluxServerApplication

fun main(args: Array<String>) {
    System.setProperty("server.port", "8080")
    runApplication<MasterWebfluxServerApplication>(*args)
}
