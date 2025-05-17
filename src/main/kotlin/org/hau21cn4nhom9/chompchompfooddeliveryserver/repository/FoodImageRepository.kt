package org.hau21cn4nhom9.chompchompfooddeliveryserver.repository

import org.hau21cn4nhom9.chompchompfooddeliveryserver.entity.FoodImage
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface FoodImageRepository: JpaRepository<FoodImage, Int> {
    // @gen-start

    override fun findAll(pageable: Pageable): Page<FoodImage>

    // code block here

    // @gen-end
}