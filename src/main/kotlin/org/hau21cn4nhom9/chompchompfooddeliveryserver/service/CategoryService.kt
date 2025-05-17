package org.hau21cn4nhom9.chompchompfooddeliveryserver.service

import org.hau21cn4nhom9.chompchompfooddeliveryserver.entity.Category
import org.hau21cn4nhom9.chompchompfooddeliveryserver.repository.CategoryRepository
import org.hau21cn4nhom9.chompchompfooddeliveryserver.updateEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CategoryService(private val categoryRepository: CategoryRepository) {
    // @gen-start

    fun getAllCategories(pageable: Pageable): Page<Category> = categoryRepository.findAll(pageable)

    fun getCategoryById(id: Int): Category? = categoryRepository.findById(id).orElse(null)

    fun saveCategory(category: Category): Category = categoryRepository.save(category)

    @Transactional
    fun updateCategory(id: Int, updatedCategory: Category): Category? {
        return if (categoryRepository.existsById(id)) {
            val existingCategory: Category = categoryRepository.findById(id).get()
            updateEntity(existingCategory, updatedCategory)
            categoryRepository.save(existingCategory)
        } else {
            null
        }
    }

    @Transactional
    fun deleteCategory(id: Int) = categoryRepository.deleteById(id)

    // code block here

    // @gen-end
}