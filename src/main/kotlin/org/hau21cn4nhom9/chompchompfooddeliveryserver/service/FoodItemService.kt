package org.hau21cn4nhom9.chompchompfooddeliveryserver.service

import org.hau21cn4nhom9.chompchompfooddeliveryserver.entity.FoodItem
import org.hau21cn4nhom9.chompchompfooddeliveryserver.repository.FoodItemRepository
import org.hau21cn4nhom9.chompchompfooddeliveryserver.updateEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class FoodItemService(private val foodItemRepository: FoodItemRepository) {
    // @gen-start

    fun getAllFoodItems(pageable: Pageable): Page<FoodItem> = foodItemRepository.findAll(pageable)

    fun getFoodItemById(id: Int): FoodItem? = foodItemRepository.findById(id).orElse(null)

    fun saveFoodItem(foodItem: FoodItem): FoodItem = foodItemRepository.save(foodItem)

    @Transactional
    fun updateFoodItem(id: Int, updatedFoodItem: FoodItem): FoodItem? {
        return if (foodItemRepository.existsById(id)) {
            val existingFoodItem: FoodItem = foodItemRepository.findById(id).get()
            updateEntity(existingFoodItem, updatedFoodItem)
            foodItemRepository.save(existingFoodItem)
        } else {
            null
        }
    }

    @Transactional
    fun deleteFoodItem(id: Int) = foodItemRepository.deleteById(id)

    fun findFoodItemsByCategoryId(pageable: Pageable, id: Int): Page<FoodItem> = foodItemRepository.findFoodItemsByCategory_Id(pageable, id)

    fun findFoodItemsByFoodItemStatusId(pageable: Pageable, id: Byte): Page<FoodItem> = foodItemRepository.findFoodItemsByFoodItemStatus_Id(pageable, id)

    // code block here

    // @gen-end
}