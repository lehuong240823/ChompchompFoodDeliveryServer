package org.hau21cn4nhom9.chompchompfooddeliveryserver.repository

import org.hau21cn4nhom9.chompchompfooddeliveryserver.entity.BuyerPayment
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface BuyerPaymentRepository: JpaRepository<BuyerPayment, Int> {
    // @gen-start

    override fun findAll(pageable: Pageable): Page<BuyerPayment>

    fun findBuyerPaymentsByBuyer(pageable: Pageable, id: Int): Page<BuyerPayment>

    fun findBuyerPaymentsByPaymentMethod_Id(pageable: Pageable, id: Byte): Page<BuyerPayment>

    // code block here

    // @gen-end
}