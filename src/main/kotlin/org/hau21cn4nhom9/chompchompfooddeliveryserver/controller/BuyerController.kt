package org.hau21cn4nhom9.chompchompfooddeliveryserver.controller

import org.hau21cn4nhom9.chompchompfooddeliveryserver.entity.Buyer
import org.hau21cn4nhom9.chompchompfooddeliveryserver.service.BuyerService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/buyers")
class BuyerController(private val buyerService: BuyerService) {
    // @gen-start

    @GetMapping
    fun getAllBuyers(@PageableDefault(size = 10) pageable: Pageable): Page<Buyer> = buyerService.getAllBuyers(pageable)

    @GetMapping("/{id}")
    fun getBuyerById(@PathVariable id: Int): ResponseEntity<Buyer> {
        val buyer = buyerService.getBuyerById(id)
        return if (buyer != null) ResponseEntity.ok(buyer) else ResponseEntity.notFound().build()
    }

    @PostMapping
    fun createBuyer(@RequestBody buyer: Buyer): Buyer = buyerService.saveBuyer(buyer)

    @PutMapping("/{id}")
    fun updateBuyer(@PathVariable id: Int, @RequestBody updatedBuyer: Buyer): ResponseEntity<Buyer> {
        val buyer = buyerService.updateBuyer(id, updatedBuyer)
        return if (buyer != null) ResponseEntity.ok(buyer) else ResponseEntity.notFound().build()
    }

    @DeleteMapping("/{id}")
    fun deleteBuyer(@PathVariable id: Int): ResponseEntity<Void> {
        buyerService.deleteBuyer(id)
        return ResponseEntity.noContent().build()
    }

    @GetMapping("/accounts/{id}")
    fun findBuyersByAccountId(@PageableDefault(size = 10) pageable: Pageable, @PathVariable id: Int): Page<Buyer> = buyerService.findBuyersByAccountId(pageable, id)
    
    // code block here

    // @gen-end
}