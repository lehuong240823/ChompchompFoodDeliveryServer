package org.hau21cn4nhom9.chompchompfooddeliveryserver.controller

import org.hau21cn4nhom9.chompchompfooddeliveryserver.entity.FoodItem
import org.hau21cn4nhom9.chompchompfooddeliveryserver.service.FoodItemService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/food-items")
class FoodItemController(private val foodItemService: FoodItemService) {
    // @gen-start

    @GetMapping
    fun getAllFoodItems(@PageableDefault(size = 10) pageable: Pageable): Page<FoodItem> = foodItemService.getAllFoodItems(pageable)

    @GetMapping("/{id}")
    fun getFoodItemById(@PathVariable id: Int): ResponseEntity<FoodItem> {
        val foodItem = foodItemService.getFoodItemById(id)
        return if (foodItem != null) ResponseEntity.ok(foodItem) else ResponseEntity.notFound().build()
    }

    @PostMapping
    fun createFoodItem(@RequestBody foodItem: FoodItem): FoodItem = foodItemService.saveFoodItem(foodItem)

    @PutMapping("/{id}")
    fun updateFoodItem(@PathVariable id: Int, @RequestBody updatedFoodItem: FoodItem): ResponseEntity<FoodItem> {
        val foodItem = foodItemService.updateFoodItem(id, updatedFoodItem)
        return if (foodItem != null) ResponseEntity.ok(foodItem) else ResponseEntity.notFound().build()
    }

    @DeleteMapping("/{id}")
    fun deleteFoodItem(@PathVariable id: Int): ResponseEntity<Void> {
        foodItemService.deleteFoodItem(id)
        return ResponseEntity.noContent().build()
    }

    @GetMapping("/categories/{id}")
    fun findFoodItemsByCategoryId(@PageableDefault(size = 10) pageable: Pageable, @PathVariable id: Int): Page<FoodItem> = foodItemService.findFoodItemsByCategoryId(pageable, id)
    
    @GetMapping("/food-item-statuses/{id}")
    fun findFoodItemsByFoodItemStatusId(@PageableDefault(size = 10) pageable: Pageable, @PathVariable id: Byte): Page<FoodItem> = foodItemService.findFoodItemsByFoodItemStatusId(pageable, id)
    
    // code block here

    // @gen-end
}