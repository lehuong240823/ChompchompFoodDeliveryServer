package org.hau21cn4nhom9.chompchompfooddeliveryserver.repository

import org.hau21cn4nhom9.chompchompfooddeliveryserver.entity.OrderStatus
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface OrderStatusRepository: JpaRepository<OrderStatus, Byte> {
    // @gen-start

    override fun findAll(pageable: Pageable): Page<OrderStatus>

    // code block here

    // @gen-end
}