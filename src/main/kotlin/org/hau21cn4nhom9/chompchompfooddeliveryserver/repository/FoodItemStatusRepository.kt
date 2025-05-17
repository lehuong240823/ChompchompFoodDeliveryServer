package org.hau21cn4nhom9.chompchompfooddeliveryserver.repository

import org.hau21cn4nhom9.chompchompfooddeliveryserver.entity.FoodItemStatus
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface FoodItemStatusRepository: JpaRepository<FoodItemStatus, Byte> {
    // @gen-start

    override fun findAll(pageable: Pageable): Page<FoodItemStatus>

    // code block here

    // @gen-end
}