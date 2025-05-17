package org.hau21cn4nhom9.chompchompfooddeliveryserver.repository

import org.hau21cn4nhom9.chompchompfooddeliveryserver.entity.VoucherType
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface VoucherTypeRepository: JpaRepository<VoucherType, Byte> {
    // @gen-start

    override fun findAll(pageable: Pageable): Page<VoucherType>

    // code block here

    // @gen-end
}