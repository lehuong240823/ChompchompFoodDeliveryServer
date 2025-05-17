package org.hau21cn4nhom9.chompchompfooddeliveryserver.service

import org.hau21cn4nhom9.chompchompfooddeliveryserver.entity.FoodImage
import org.hau21cn4nhom9.chompchompfooddeliveryserver.repository.FoodImageRepository
import org.hau21cn4nhom9.chompchompfooddeliveryserver.updateEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class FoodImageService(private val foodImageRepository: FoodImageRepository) {
    // @gen-start

    fun getAllFoodImages(pageable: Pageable): Page<FoodImage> = foodImageRepository.findAll(pageable)

    fun getFoodImageById(id: Int): FoodImage? = foodImageRepository.findById(id).orElse(null)

    fun saveFoodImage(foodImage: FoodImage): FoodImage = foodImageRepository.save(foodImage)

    @Transactional
    fun updateFoodImage(id: Int, updatedFoodImage: FoodImage): FoodImage? {
        return if (foodImageRepository.existsById(id)) {
            val existingFoodImage: FoodImage = foodImageRepository.findById(id).get()
            updateEntity(existingFoodImage, updatedFoodImage)
            foodImageRepository.save(existingFoodImage)
        } else {
            null
        }
    }

    @Transactional
    fun deleteFoodImage(id: Int) = foodImageRepository.deleteById(id)

    // code block here

    // @gen-end
}