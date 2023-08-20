package kr.disdong.spring.reactive.study.webflux.server.slave

import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono
import reactor.core.publisher.Mono.delay
import java.time.Duration

@SpringBootApplication
@RestController("/")
class SlaveWebfluxServerApplication {
    private val logger = LoggerFactory.getLogger(this::class.java)

    @GetMapping("/thread-sleep")
    fun threadSleep(idx: String): String {
        logger.info("threadSleep()")
        Thread.sleep(1000)
        return "/threadSleep idx: $idx"
    }

    @GetMapping("/mono-delay")
    fun monoDelay(idx: String): Mono<String> {
        logger.info("monoDelay()")
        return Mono.just("/monoDelay idx: $idx")
            .delayElement(Duration.ofSeconds(1))
    }

    @GetMapping("/suspend-delay")
    suspend fun suspendDelay(idx: String): String {
        logger.info("suspendDelay()")
        delay(Duration.ofSeconds(1))
        return "/suspendDelay idx: $idx"
    }
}

fun main(args: Array<String>) {
    System.setProperty("server.port", "8081")
    runApplication<SlaveWebfluxServerApplication>(*args)
}
