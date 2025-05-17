package org.hau21cn4nhom9.chompchompfooddeliveryserver.service

import org.hau21cn4nhom9.chompchompfooddeliveryserver.entity.Review
import org.hau21cn4nhom9.chompchompfooddeliveryserver.repository.ReviewRepository
import org.hau21cn4nhom9.chompchompfooddeliveryserver.updateEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ReviewService(private val reviewRepository: ReviewRepository) {
    // @gen-start

    fun getAllReviews(pageable: Pageable): Page<Review> = reviewRepository.findAll(pageable)

    fun getReviewById(id: Int): Review? = reviewRepository.findById(id).orElse(null)

    fun saveReview(review: Review): Review = reviewRepository.save(review)

    @Transactional
    fun updateReview(id: Int, updatedReview: Review): Review? {
        return if (reviewRepository.existsById(id)) {
            val existingReview: Review = reviewRepository.findById(id).get()
            updateEntity(existingReview, updatedReview)
            reviewRepository.save(existingReview)
        } else {
            null
        }
    }

    @Transactional
    fun deleteReview(id: Int) = reviewRepository.deleteById(id)

    fun findReviewsByOrderItemId(pageable: Pageable, id: Int): Page<Review> = reviewRepository.findReviewsByOrderItem_Id(pageable, id)

    // code block here

    // @gen-end
}