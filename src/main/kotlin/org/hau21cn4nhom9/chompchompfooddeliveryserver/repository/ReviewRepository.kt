package org.hau21cn4nhom9.chompchompfooddeliveryserver.repository

import org.hau21cn4nhom9.chompchompfooddeliveryserver.entity.Review
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface ReviewRepository: JpaRepository<Review, Int> {
    // @gen-start

    override fun findAll(pageable: Pageable): Page<Review>

    fun findReviewsByOrderItem_Id(pageable: Pageable, id: Int): Page<Review>

    // code block here

    // @gen-end
}