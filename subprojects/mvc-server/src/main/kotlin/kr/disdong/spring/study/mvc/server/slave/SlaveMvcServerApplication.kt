package kr.disdong.spring.study.mvc.server.slave

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SlaveMvcServerApplication

fun main(args: Array<String>) {
    runApplication<SlaveMvcServerApplication>(*args)
}
