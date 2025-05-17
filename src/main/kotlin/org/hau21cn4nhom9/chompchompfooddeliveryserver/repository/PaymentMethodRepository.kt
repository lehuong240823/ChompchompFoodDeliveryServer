package org.hau21cn4nhom9.chompchompfooddeliveryserver.repository

import org.hau21cn4nhom9.chompchompfooddeliveryserver.entity.PaymentMethod
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface PaymentMethodRepository: JpaRepository<PaymentMethod, Byte> {
    // @gen-start

    override fun findAll(pageable: Pageable): Page<PaymentMethod>

    // code block here

    // @gen-end
}