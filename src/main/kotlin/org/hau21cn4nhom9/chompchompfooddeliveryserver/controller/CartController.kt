package org.hau21cn4nhom9.chompchompfooddeliveryserver.controller

import org.hau21cn4nhom9.chompchompfooddeliveryserver.entity.Cart
import org.hau21cn4nhom9.chompchompfooddeliveryserver.service.CartService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/carts")
class CartController(private val cartService: CartService) {
    // @gen-start

    @GetMapping
    fun getAllCarts(@PageableDefault(size = 10) pageable: Pageable): Page<Cart> = cartService.getAllCarts(pageable)

    @GetMapping("/{id}")
    fun getCartById(@PathVariable id: Int): ResponseEntity<Cart> {
        val cart = cartService.getCartById(id)
        return if (cart != null) ResponseEntity.ok(cart) else ResponseEntity.notFound().build()
    }

    @PostMapping
    fun createCart(@RequestBody cart: Cart): Cart = cartService.saveCart(cart)

    @PutMapping("/{id}")
    fun updateCart(@PathVariable id: Int, @RequestBody updatedCart: Cart): ResponseEntity<Cart> {
        val cart = cartService.updateCart(id, updatedCart)
        return if (cart != null) ResponseEntity.ok(cart) else ResponseEntity.notFound().build()
    }

    @DeleteMapping("/{id}")
    fun deleteCart(@PathVariable id: Int): ResponseEntity<Void> {
        cartService.deleteCart(id)
        return ResponseEntity.noContent().build()
    }

    @GetMapping("/buyers/{id}")
    fun findCartsByBuyer(@PageableDefault(size = 10) pageable: Pageable, @PathVariable id: Int): Page<Cart> = cartService.findCartsByBuyer(pageable, id)
    
    @GetMapping("/food-items/{id}")
    fun findCartsByFoodItemId(@PageableDefault(size = 10) pageable: Pageable, @PathVariable id: Int): Page<Cart> = cartService.findCartsByFoodItemId(pageable, id)
    
    // code block here

    // @gen-end
}