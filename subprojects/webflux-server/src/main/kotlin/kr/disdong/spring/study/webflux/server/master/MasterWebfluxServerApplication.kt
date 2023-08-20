package kr.disdong.spring.study.webflux.server.master

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MasterWebfluxServerApplication

fun main(args: Array<String>) {
    runApplication<MasterWebfluxServerApplication>(*args)
}
