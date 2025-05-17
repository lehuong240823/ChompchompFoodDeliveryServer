package org.hau21cn4nhom9.chompchompfooddeliveryserver.repository

import org.hau21cn4nhom9.chompchompfooddeliveryserver.entity.TransactionStatus
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface TransactionStatusRepository: JpaRepository<TransactionStatus, Byte> {
    // @gen-start

    override fun findAll(pageable: Pageable): Page<TransactionStatus>

    // code block here

    // @gen-end
}