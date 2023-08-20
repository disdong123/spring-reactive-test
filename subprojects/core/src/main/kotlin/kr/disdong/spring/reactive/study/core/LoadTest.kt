package kr.disdong.spring.reactive.study.core

import org.slf4j.LoggerFactory
import org.springframework.util.StopWatch
import org.springframework.web.client.RestTemplate
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicInteger

var counter = AtomicInteger(0)

enum class TestType(val url: String) {
    THREAD_SLEEP_WEB_CLIENT_REACTIVE("/thread-sleep/web-client-reactive"),
    THREAD_SLEEP_WEB_CLIENT_COROUTINE("/thread-sleep/web-client-coroutine"),
    THREAD_SLEEP_REST_TEMPLATE("/thread-sleep/rest-template"),
    MONO_DELAY_WEB_CLIENT_REACTIVE("/mono-delay/web-client-reactive"),
    MONO_DELAY_WEB_CLIENT_COROUTINE("/mono-delay/web-client-coroutine"),
    MONO_DELAY_REST_TEMPLATE("/mono-delay/rest-template"),
    SUSPEND_DELAY_WEB_CLIENT_REACTIVE("/suspend-delay/web-client-reactive"),
    SUSPEND_DELAY_WEB_CLIENT_COROUTINE("/suspend-delay/web-client-coroutine"),
    SUSPEND_DELAY_REST_TEMPLATE("/suspend-delay/rest-template");
}

fun test(threadPoolSize: Int, loopCount: Int, testType: TestType) {
    val logger = LoggerFactory.getLogger(testType.name)
    val client = RestTemplate()
    val executorService = Executors.newFixedThreadPool(threadPoolSize)
    val functionTimer = StopWatch()

    functionTimer.start()

    for (i in 1..loopCount) {
        executorService.execute {
            val loopTimer = StopWatch()
            val idx = counter.addAndGet(1)
            logger.info("[Thread number: $idx] Start")

            loopTimer.start()
            val res = client.getForObject("http://localhost:8080/${testType.url}?idx={idx}", String::class.java, idx)
            loopTimer.stop()

            logger.info("[Thread number: $idx] end. Running time: ${loopTimer.totalTimeSeconds} / $res")
        }
    }

    executorService.shutdown()
    executorService.awaitTermination(100, TimeUnit.SECONDS)
    functionTimer.stop()

    logger.info("Total: ${functionTimer.totalTimeSeconds}")
}

fun main() {
    // test(1, 1, TestType.THREAD_SLEEP_REST_TEMPLATE)
    // test(3000, 11, TestType.THREAD_SLEEP_WEB_CLIENT_COROUTINE)
    // test(3000, 11, TestType.THREAD_SLEEP_WEB_CLIENT_REACTIVE)
    test(1000, 1000, TestType.MONO_DELAY_WEB_CLIENT_COROUTINE)
}
