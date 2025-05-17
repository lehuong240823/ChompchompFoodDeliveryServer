package org.hau21cn4nhom9.chompchompfooddeliveryserver.repository

import org.hau21cn4nhom9.chompchompfooddeliveryserver.entity.Buyer
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface BuyerRepository: JpaRepository<Buyer, Int> {
    // @gen-start

    override fun findAll(pageable: Pageable): Page<Buyer>

    fun findBuyersByAccount_Id(pageable: Pageable, id: Int): Page<Buyer>

    // code block here

    // @gen-end
}