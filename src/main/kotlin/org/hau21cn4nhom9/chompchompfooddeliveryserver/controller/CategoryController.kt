package org.hau21cn4nhom9.chompchompfooddeliveryserver.controller

import org.hau21cn4nhom9.chompchompfooddeliveryserver.entity.Category
import org.hau21cn4nhom9.chompchompfooddeliveryserver.service.CategoryService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/categories")
class CategoryController(private val categoryService: CategoryService) {
    // @gen-start

    @GetMapping
    fun getAllCategories(@PageableDefault(size = 10) pageable: Pageable): Page<Category> = categoryService.getAllCategories(pageable)

    @GetMapping("/{id}")
    fun getCategoryById(@PathVariable id: Int): ResponseEntity<Category> {
        val category = categoryService.getCategoryById(id)
        return if (category != null) ResponseEntity.ok(category) else ResponseEntity.notFound().build()
    }

    @PostMapping
    fun createCategory(@RequestBody category: Category): Category = categoryService.saveCategory(category)

    @PutMapping("/{id}")
    fun updateCategory(@PathVariable id: Int, @RequestBody updatedCategory: Category): ResponseEntity<Category> {
        val category = categoryService.updateCategory(id, updatedCategory)
        return if (category != null) ResponseEntity.ok(category) else ResponseEntity.notFound().build()
    }

    @DeleteMapping("/{id}")
    fun deleteCategory(@PathVariable id: Int): ResponseEntity<Void> {
        categoryService.deleteCategory(id)
        return ResponseEntity.noContent().build()
    }

    // code block here

    // @gen-end
}