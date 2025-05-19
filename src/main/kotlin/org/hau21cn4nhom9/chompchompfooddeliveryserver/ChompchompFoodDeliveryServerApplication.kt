package org.hau21cn4nhom9.chompchompfooddeliveryserver

import jakarta.annotation.PostConstruct
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.stereotype.Component

@SpringBootApplication
class ChompchompFoodDeliveryServerApplication

fun main(args: Array<String>) {
    runApplication<ChompchompFoodDeliveryServerApplication>(*args)
}

@Component
class ServerInfoLogger {
    @Value("\${server.port}")
    private lateinit var port: String

    @Value("\${server.address}")
    private lateinit var address: String

    @PostConstruct
    fun logServerInfo() {
        println("Application is running on address: $address and port: $port")
    }
}
