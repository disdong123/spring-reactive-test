package kr.disdong.spring.study.mvc.server.master

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MasterMvcServerApplication

fun main(args: Array<String>) {
    runApplication<MasterMvcServerApplication>(*args)
}
