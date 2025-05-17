package org.hau21cn4nhom9.chompchompfooddeliveryserver.repository

import org.hau21cn4nhom9.chompchompfooddeliveryserver.entity.Voucher
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface VoucherRepository: JpaRepository<Voucher, Int> {
    // @gen-start

    override fun findAll(pageable: Pageable): Page<Voucher>

    fun findVouchersByVoucherType_Id(pageable: Pageable, id: Byte): Page<Voucher>

    // code block here

    // @gen-end
}