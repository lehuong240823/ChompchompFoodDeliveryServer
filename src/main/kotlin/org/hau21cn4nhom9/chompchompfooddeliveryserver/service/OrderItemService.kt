package org.hau21cn4nhom9.chompchompfooddeliveryserver.service

import org.hau21cn4nhom9.chompchompfooddeliveryserver.entity.OrderItem
import org.hau21cn4nhom9.chompchompfooddeliveryserver.repository.OrderItemRepository
import org.hau21cn4nhom9.chompchompfooddeliveryserver.updateEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class OrderItemService(private val orderItemRepository: OrderItemRepository) {
    // @gen-start

    fun getAllOrderItems(pageable: Pageable): Page<OrderItem> = orderItemRepository.findAll(pageable)

    fun getOrderItemById(id: Int): OrderItem? = orderItemRepository.findById(id).orElse(null)

    fun saveOrderItem(orderItem: OrderItem): OrderItem = orderItemRepository.save(orderItem)

    @Transactional
    fun updateOrderItem(id: Int, updatedOrderItem: OrderItem): OrderItem? {
        return if (orderItemRepository.existsById(id)) {
            val existingOrderItem: OrderItem = orderItemRepository.findById(id).get()
            updateEntity(existingOrderItem, updatedOrderItem)
            orderItemRepository.save(existingOrderItem)
        } else {
            null
        }
    }

    @Transactional
    fun deleteOrderItem(id: Int) = orderItemRepository.deleteById(id)

    fun findOrderItemsByOrderId(pageable: Pageable, id: Int): Page<OrderItem> = orderItemRepository.findOrderItemsByOrder(pageable, id)

    fun findOrderItemsByFoodItemId(pageable: Pageable, id: Int): Page<OrderItem> = orderItemRepository.findOrderItemsByFoodItem_Id(pageable, id)

    // code block here

    // @gen-end
}