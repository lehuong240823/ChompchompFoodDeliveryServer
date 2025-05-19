package org.hau21cn4nhom9.chompchompfooddeliveryserver.repository

import org.hau21cn4nhom9.chompchompfooddeliveryserver.entity.OrderItem
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface OrderItemRepository: JpaRepository<OrderItem, Int> {
    // @gen-start

    override fun findAll(pageable: Pageable): Page<OrderItem>

    fun findOrderItemsByOrder(pageable: Pageable, id: Int): Page<OrderItem>

    fun findOrderItemsByFoodItem_Id(pageable: Pageable, id: Int): Page<OrderItem>

    // code block here

    // @gen-end
}