package org.hau21cn4nhom9.chompchompfooddeliveryserver.controller

import org.hau21cn4nhom9.chompchompfooddeliveryserver.entity.OrderItem
import org.hau21cn4nhom9.chompchompfooddeliveryserver.service.OrderItemService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/order-items")
class OrderItemController(private val orderItemService: OrderItemService) {
    // @gen-start

    @GetMapping
    fun getAllOrderItems(@PageableDefault(size = 10) pageable: Pageable): Page<OrderItem> = orderItemService.getAllOrderItems(pageable)

    @GetMapping("/{id}")
    fun getOrderItemById(@PathVariable id: Int): ResponseEntity<OrderItem> {
        val orderItem = orderItemService.getOrderItemById(id)
        return if (orderItem != null) ResponseEntity.ok(orderItem) else ResponseEntity.notFound().build()
    }

    @PostMapping
    fun createOrderItem(@RequestBody orderItem: OrderItem): OrderItem = orderItemService.saveOrderItem(orderItem)

    @PutMapping("/{id}")
    fun updateOrderItem(@PathVariable id: Int, @RequestBody updatedOrderItem: OrderItem): ResponseEntity<OrderItem> {
        val orderItem = orderItemService.updateOrderItem(id, updatedOrderItem)
        return if (orderItem != null) ResponseEntity.ok(orderItem) else ResponseEntity.notFound().build()
    }

    @DeleteMapping("/{id}")
    fun deleteOrderItem(@PathVariable id: Int): ResponseEntity<Void> {
        orderItemService.deleteOrderItem(id)
        return ResponseEntity.noContent().build()
    }

    @GetMapping("/orders/{id}")
    fun findOrderItemsByOrderId(@PageableDefault(size = 10) pageable: Pageable, @PathVariable id: Int): Page<OrderItem> = orderItemService.findOrderItemsByOrderId(pageable, id)
    
    @GetMapping("/food-items/{id}")
    fun findOrderItemsByFoodItemId(@PageableDefault(size = 10) pageable: Pageable, @PathVariable id: Int): Page<OrderItem> = orderItemService.findOrderItemsByFoodItemId(pageable, id)
    
    // code block here

    // @gen-end
}