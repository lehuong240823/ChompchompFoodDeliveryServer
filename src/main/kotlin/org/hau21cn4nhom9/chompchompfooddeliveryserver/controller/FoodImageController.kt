package org.hau21cn4nhom9.chompchompfooddeliveryserver.controller

import org.hau21cn4nhom9.chompchompfooddeliveryserver.entity.FoodImage
import org.hau21cn4nhom9.chompchompfooddeliveryserver.service.FoodImageService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/food-images")
class FoodImageController(private val foodImageService: FoodImageService) {
    // @gen-start

    @GetMapping
    fun getAllFoodImages(@PageableDefault(size = 10) pageable: Pageable): Page<FoodImage> = foodImageService.getAllFoodImages(pageable)

    @GetMapping("/{id}")
    fun getFoodImageById(@PathVariable id: Int): ResponseEntity<FoodImage> {
        val foodImage = foodImageService.getFoodImageById(id)
        return if (foodImage != null) ResponseEntity.ok(foodImage) else ResponseEntity.notFound().build()
    }

    @PostMapping
    fun createFoodImage(@RequestBody foodImage: FoodImage): FoodImage = foodImageService.saveFoodImage(foodImage)

    @PutMapping("/{id}")
    fun updateFoodImage(@PathVariable id: Int, @RequestBody updatedFoodImage: FoodImage): ResponseEntity<FoodImage> {
        val foodImage = foodImageService.updateFoodImage(id, updatedFoodImage)
        return if (foodImage != null) ResponseEntity.ok(foodImage) else ResponseEntity.notFound().build()
    }

    @DeleteMapping("/{id}")
    fun deleteFoodImage(@PathVariable id: Int): ResponseEntity<Void> {
        foodImageService.deleteFoodImage(id)
        return ResponseEntity.noContent().build()
    }

    // code block here

    // @gen-end
}