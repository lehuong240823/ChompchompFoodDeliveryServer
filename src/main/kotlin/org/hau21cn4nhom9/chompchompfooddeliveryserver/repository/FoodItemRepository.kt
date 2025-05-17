package org.hau21cn4nhom9.chompchompfooddeliveryserver.repository

import org.hau21cn4nhom9.chompchompfooddeliveryserver.entity.FoodItem
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface FoodItemRepository: JpaRepository<FoodItem, Int> {
    // @gen-start

    override fun findAll(pageable: Pageable): Page<FoodItem>

    fun findFoodItemsByCategory_Id(pageable: Pageable, id: Int): Page<FoodItem>

    fun findFoodItemsByFoodItemStatus_Id(pageable: Pageable, id: Byte): Page<FoodItem>

    // code block here

    // @gen-end
}