package org.hau21cn4nhom9.chompchompfooddeliveryserver.repository

import org.hau21cn4nhom9.chompchompfooddeliveryserver.entity.Cart
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface CartRepository: JpaRepository<Cart, Int> {
    // @gen-start

    override fun findAll(pageable: Pageable): Page<Cart>

    fun findCartsByBuyer(pageable: Pageable, id: Int): Page<Cart>

    fun findCartsByFoodItem_Id(pageable: Pageable, id: Int): Page<Cart>

    // code block here

    // @gen-end
}