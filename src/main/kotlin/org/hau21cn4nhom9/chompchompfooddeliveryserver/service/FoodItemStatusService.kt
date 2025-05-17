package org.hau21cn4nhom9.chompchompfooddeliveryserver.service

import org.hau21cn4nhom9.chompchompfooddeliveryserver.entity.FoodItemStatus
import org.hau21cn4nhom9.chompchompfooddeliveryserver.repository.FoodItemStatusRepository
import org.hau21cn4nhom9.chompchompfooddeliveryserver.updateEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class FoodItemStatusService(private val foodItemStatusRepository: FoodItemStatusRepository) {
    // @gen-start

    fun getAllFoodItemStatuses(pageable: Pageable): Page<FoodItemStatus> = foodItemStatusRepository.findAll(pageable)

    fun getFoodItemStatusById(id: Byte): FoodItemStatus? = foodItemStatusRepository.findById(id).orElse(null)

    fun saveFoodItemStatus(foodItemStatus: FoodItemStatus): FoodItemStatus = foodItemStatusRepository.save(foodItemStatus)

    @Transactional
    fun updateFoodItemStatus(id: Byte, updatedFoodItemStatus: FoodItemStatus): FoodItemStatus? {
        return if (foodItemStatusRepository.existsById(id)) {
            val existingFoodItemStatus: FoodItemStatus = foodItemStatusRepository.findById(id).get()
            updateEntity(existingFoodItemStatus, updatedFoodItemStatus)
            foodItemStatusRepository.save(existingFoodItemStatus)
        } else {
            null
        }
    }

    @Transactional
    fun deleteFoodItemStatus(id: Byte) = foodItemStatusRepository.deleteById(id)

    // code block here

    // @gen-end
}