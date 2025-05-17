package org.hau21cn4nhom9.chompchompfooddeliveryserver.repository

import org.hau21cn4nhom9.chompchompfooddeliveryserver.entity.Transaction
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface TransactionRepository: JpaRepository<Transaction, Int> {
    // @gen-start

    override fun findAll(pageable: Pageable): Page<Transaction>

    fun findTransactionsByOrder_Id(pageable: Pageable, id: Int): Page<Transaction>

    fun findTransactionsByPaymentMethod_Id(pageable: Pageable, id: Byte): Page<Transaction>

    fun findTransactionsByBuyerPayment_Id(pageable: Pageable, id: Int): Page<Transaction>

    fun findTransactionsByTransactionStatus_Id(pageable: Pageable, id: Byte): Page<Transaction>

    // code block here

    // @gen-end
}