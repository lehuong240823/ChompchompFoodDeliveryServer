package org.hau21cn4nhom9.chompchompfooddeliveryserver.controller

import org.hau21cn4nhom9.chompchompfooddeliveryserver.entity.BuyerPayment
import org.hau21cn4nhom9.chompchompfooddeliveryserver.service.BuyerPaymentService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/buyer-payments")
class BuyerPaymentController(private val buyerPaymentService: BuyerPaymentService) {
    // @gen-start

    @GetMapping
    fun getAllBuyerPayments(@PageableDefault(size = 10) pageable: Pageable): Page<BuyerPayment> = buyerPaymentService.getAllBuyerPayments(pageable)

    @GetMapping("/{id}")
    fun getBuyerPaymentById(@PathVariable id: Int): ResponseEntity<BuyerPayment> {
        val buyerPayment = buyerPaymentService.getBuyerPaymentById(id)
        return if (buyerPayment != null) ResponseEntity.ok(buyerPayment) else ResponseEntity.notFound().build()
    }

    @PostMapping
    fun createBuyerPayment(@RequestBody buyerPayment: BuyerPayment): BuyerPayment = buyerPaymentService.saveBuyerPayment(buyerPayment)

    @PutMapping("/{id}")
    fun updateBuyerPayment(@PathVariable id: Int, @RequestBody updatedBuyerPayment: BuyerPayment): ResponseEntity<BuyerPayment> {
        val buyerPayment = buyerPaymentService.updateBuyerPayment(id, updatedBuyerPayment)
        return if (buyerPayment != null) ResponseEntity.ok(buyerPayment) else ResponseEntity.notFound().build()
    }

    @DeleteMapping("/{id}")
    fun deleteBuyerPayment(@PathVariable id: Int): ResponseEntity<Void> {
        buyerPaymentService.deleteBuyerPayment(id)
        return ResponseEntity.noContent().build()
    }

    @GetMapping("/buyers/{id}")
    fun findBuyerPaymentsByBuyer(@PageableDefault(size = 10) pageable: Pageable, @PathVariable id: Int): Page<BuyerPayment> = buyerPaymentService.findBuyerPaymentsByBuyer(pageable, id)
    
    @GetMapping("/payment-methods/{id}")
    fun findBuyerPaymentsByPaymentMethodId(@PageableDefault(size = 10) pageable: Pageable, @PathVariable id: Byte): Page<BuyerPayment> = buyerPaymentService.findBuyerPaymentsByPaymentMethodId(pageable, id)
    
    // code block here

    // @gen-end
}