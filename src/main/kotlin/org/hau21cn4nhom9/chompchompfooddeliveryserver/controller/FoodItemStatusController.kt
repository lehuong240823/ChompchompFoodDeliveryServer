package org.hau21cn4nhom9.chompchompfooddeliveryserver.controller

import org.hau21cn4nhom9.chompchompfooddeliveryserver.entity.FoodItemStatus
import org.hau21cn4nhom9.chompchompfooddeliveryserver.service.FoodItemStatusService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/food-item-statuses")
class FoodItemStatusController(private val foodItemStatusService: FoodItemStatusService) {
    // @gen-start

    @GetMapping
    fun getAllFoodItemStatuses(@PageableDefault(size = 10) pageable: Pageable): Page<FoodItemStatus> = foodItemStatusService.getAllFoodItemStatuses(pageable)

    @GetMapping("/{id}")
    fun getFoodItemStatusById(@PathVariable id: Byte): ResponseEntity<FoodItemStatus> {
        val foodItemStatus = foodItemStatusService.getFoodItemStatusById(id)
        return if (foodItemStatus != null) ResponseEntity.ok(foodItemStatus) else ResponseEntity.notFound().build()
    }

//    @PostMapping
//    fun createFoodItemStatus(@RequestBody foodItemStatus: FoodItemStatus): FoodItemStatus = foodItemStatusService.saveFoodItemStatus(foodItemStatus)
//
//    @PutMapping("/{id}")
//    fun updateFoodItemStatus(@PathVariable id: Byte, @RequestBody updatedFoodItemStatus: FoodItemStatus): ResponseEntity<FoodItemStatus> {
//        val foodItemStatus = foodItemStatusService.updateFoodItemStatus(id, updatedFoodItemStatus)
//        return if (foodItemStatus != null) ResponseEntity.ok(foodItemStatus) else ResponseEntity.notFound().build()
//    }
//
//    @DeleteMapping("/{id}")
//    fun deleteFoodItemStatus(@PathVariable id: Byte): ResponseEntity<Void> {
//        foodItemStatusService.deleteFoodItemStatus(id)
//        return ResponseEntity.noContent().build()
//    }

    // code block here

    // @gen-end
}