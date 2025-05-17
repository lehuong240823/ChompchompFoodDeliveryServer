package org.hau21cn4nhom9.chompchompfooddeliveryserver.controller

import org.hau21cn4nhom9.chompchompfooddeliveryserver.entity.BuyerAddress
import org.hau21cn4nhom9.chompchompfooddeliveryserver.service.BuyerAddressService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/buyer-addresses")
class BuyerAddressController(private val buyerAddressService: BuyerAddressService) {
    // @gen-start

    @GetMapping
    fun getAllBuyerAddresses(@PageableDefault(size = 10) pageable: Pageable): Page<BuyerAddress> = buyerAddressService.getAllBuyerAddresses(pageable)

    @GetMapping("/{id}")
    fun getBuyerAddressById(@PathVariable id: Int): ResponseEntity<BuyerAddress> {
        val buyerAddress = buyerAddressService.getBuyerAddressById(id)
        return if (buyerAddress != null) ResponseEntity.ok(buyerAddress) else ResponseEntity.notFound().build()
    }

    @PostMapping
    fun createBuyerAddress(@RequestBody buyerAddress: BuyerAddress): BuyerAddress = buyerAddressService.saveBuyerAddress(buyerAddress)

    @PutMapping("/{id}")
    fun updateBuyerAddress(@PathVariable id: Int, @RequestBody updatedBuyerAddress: BuyerAddress): ResponseEntity<BuyerAddress> {
        val buyerAddress = buyerAddressService.updateBuyerAddress(id, updatedBuyerAddress)
        return if (buyerAddress != null) ResponseEntity.ok(buyerAddress) else ResponseEntity.notFound().build()
    }

    @DeleteMapping("/{id}")
    fun deleteBuyerAddress(@PathVariable id: Int): ResponseEntity<Void> {
        buyerAddressService.deleteBuyerAddress(id)
        return ResponseEntity.noContent().build()
    }

    @GetMapping("/buyers/{id}")
    fun findBuyerAddressesByBuyer(@PageableDefault(size = 10) pageable: Pageable, @PathVariable id: Int): Page<BuyerAddress> = buyerAddressService.findBuyerAddressesByBuyer(pageable, id)
    
    // code block here

    // @gen-end
}