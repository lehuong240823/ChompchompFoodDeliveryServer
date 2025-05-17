package org.hau21cn4nhom9.chompchompfooddeliveryserver.controller

import org.hau21cn4nhom9.chompchompfooddeliveryserver.entity.Order
import org.hau21cn4nhom9.chompchompfooddeliveryserver.service.OrderService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/orders")
class OrderController(private val orderService: OrderService) {
    // @gen-start

    @GetMapping
    fun getAllOrders(@PageableDefault(size = 10) pageable: Pageable): Page<Order> = orderService.getAllOrders(pageable)

    @GetMapping("/{id}")
    fun getOrderById(@PathVariable id: Int): ResponseEntity<Order> {
        val order = orderService.getOrderById(id)
        return if (order != null) ResponseEntity.ok(order) else ResponseEntity.notFound().build()
    }

    @PostMapping
    fun createOrder(@RequestBody order: Order): Order = orderService.saveOrder(order)

    @PutMapping("/{id}")
    fun updateOrder(@PathVariable id: Int, @RequestBody updatedOrder: Order): ResponseEntity<Order> {
        val order = orderService.updateOrder(id, updatedOrder)
        return if (order != null) ResponseEntity.ok(order) else ResponseEntity.notFound().build()
    }

    @DeleteMapping("/{id}")
    fun deleteOrder(@PathVariable id: Int): ResponseEntity<Void> {
        orderService.deleteOrder(id)
        return ResponseEntity.noContent().build()
    }

    @GetMapping("/buyers/{id}")
    fun findOrdersByBuyer(@PageableDefault(size = 10) pageable: Pageable, @PathVariable id: Int): Page<Order> = orderService.findOrdersByBuyer(pageable, id)
    
    @GetMapping("/order-statuses/{id}")
    fun findOrdersByOrderStatusId(@PageableDefault(size = 10) pageable: Pageable, @PathVariable id: Byte): Page<Order> = orderService.findOrdersByOrderStatusId(pageable, id)
    
    @GetMapping("/buyer-addresses/{id}")
    fun findOrdersByBuyerAddressId(@PageableDefault(size = 10) pageable: Pageable, @PathVariable id: Int): Page<Order> = orderService.findOrdersByBuyerAddressId(pageable, id)
    
    @GetMapping("/vouchers/{id}")
    fun findOrdersByVoucherId(@PageableDefault(size = 10) pageable: Pageable, @PathVariable id: Int): Page<Order> = orderService.findOrdersByVoucherId(pageable, id)
    
    // code block here

    // @gen-end
}