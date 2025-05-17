package org.hau21cn4nhom9.chompchompfooddeliveryserver.repository

import org.hau21cn4nhom9.chompchompfooddeliveryserver.entity.BuyerAddress
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface BuyerAddressRepository: JpaRepository<BuyerAddress, Int> {
    // @gen-start

    override fun findAll(pageable: Pageable): Page<BuyerAddress>

    fun findBuyerAddressesByBuyer(pageable: Pageable, id: Int): Page<BuyerAddress>

    // code block here

    // @gen-end
}