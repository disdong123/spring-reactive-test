package kr.disdong.spring.study.webflux.server.slave

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SlaveWebfluxServerApplication

fun main(args: Array<String>) {
    System.setProperty("server.port", "8081")
    runApplication<SlaveWebfluxServerApplication>(*args)
}
