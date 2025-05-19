package org.hau21cn4nhom9.chompchompfooddeliveryserver.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/health")
class HealthCheck {
    @GetMapping
    fun getHealthCheck(): ResponseEntity<Any> {
        return ResponseEntity("OK", HttpStatus.OK)
    }
}