package org.hau21cn4nhom9.chompchompfooddeliveryserver.repository

import org.hau21cn4nhom9.chompchompfooddeliveryserver.entity.Order
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface OrderRepository: JpaRepository<Order, Int> {
    // @gen-start

    override fun findAll(pageable: Pageable): Page<Order>

    fun findOrdersByBuyer(pageable: Pageable, id: Int): Page<Order>

    fun findOrdersByOrderStatus_Id(pageable: Pageable, id: Byte): Page<Order>

    fun findOrdersByBuyerAddress_Id(pageable: Pageable, id: Int): Page<Order>

    fun findOrdersByVoucher_Id(pageable: Pageable, id: Int): Page<Order>

    // code block here

    // @gen-end
}