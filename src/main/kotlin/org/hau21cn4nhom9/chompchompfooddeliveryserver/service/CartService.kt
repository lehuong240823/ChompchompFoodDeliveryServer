package org.hau21cn4nhom9.chompchompfooddeliveryserver.service

import org.hau21cn4nhom9.chompchompfooddeliveryserver.entity.Cart
import org.hau21cn4nhom9.chompchompfooddeliveryserver.repository.CartRepository
import org.hau21cn4nhom9.chompchompfooddeliveryserver.updateEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CartService(private val cartRepository: CartRepository) {
    // @gen-start

    fun getAllCarts(pageable: Pageable): Page<Cart> = cartRepository.findAll(pageable)

    fun getCartById(id: Int): Cart? = cartRepository.findById(id).orElse(null)

    fun saveCart(cart: Cart): Cart = cartRepository.save(cart)

    @Transactional
    fun updateCart(id: Int, updatedCart: Cart): Cart? {
        return if (cartRepository.existsById(id)) {
            val existingCart: Cart = cartRepository.findById(id).get()
            updateEntity(existingCart, updatedCart)
            cartRepository.save(existingCart)
        } else {
            null
        }
    }

    @Transactional
    fun deleteCart(id: Int) = cartRepository.deleteById(id)

    fun findCartsByBuyer(pageable: Pageable, id: Int): Page<Cart> = cartRepository.findCartsByBuyer(pageable, id)

    fun findCartsByFoodItemId(pageable: Pageable, id: Int): Page<Cart> = cartRepository.findCartsByFoodItem_Id(pageable, id)

    // code block here

    // @gen-end
}