package de.stundenplan

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class StundenplanApplication

fun main(args: Array<String>) {
    runApplication<StundenplanApplication>(*args)
}
