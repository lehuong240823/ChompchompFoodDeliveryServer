package org.hau21cn4nhom9.chompchompfooddeliveryserver.controller

import org.hau21cn4nhom9.chompchompfooddeliveryserver.entity.OrderStatus
import org.hau21cn4nhom9.chompchompfooddeliveryserver.service.OrderStatusService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/order-statuses")
class OrderStatusController(private val orderStatusService: OrderStatusService) {
    // @gen-start

    @GetMapping
    fun getAllOrderStatuses(@PageableDefault(size = 10) pageable: Pageable): Page<OrderStatus> = orderStatusService.getAllOrderStatuses(pageable)

    @GetMapping("/{id}")
    fun getOrderStatusById(@PathVariable id: Byte): ResponseEntity<OrderStatus> {
        val orderStatus = orderStatusService.getOrderStatusById(id)
        return if (orderStatus != null) ResponseEntity.ok(orderStatus) else ResponseEntity.notFound().build()
    }

//    @PostMapping
//    fun createOrderStatus(@RequestBody orderStatus: OrderStatus): OrderStatus = orderStatusService.saveOrderStatus(orderStatus)
//
//    @PutMapping("/{id}")
//    fun updateOrderStatus(@PathVariable id: Byte, @RequestBody updatedOrderStatus: OrderStatus): ResponseEntity<OrderStatus> {
//        val orderStatus = orderStatusService.updateOrderStatus(id, updatedOrderStatus)
//        return if (orderStatus != null) ResponseEntity.ok(orderStatus) else ResponseEntity.notFound().build()
//    }
//
//    @DeleteMapping("/{id}")
//    fun deleteOrderStatus(@PathVariable id: Byte): ResponseEntity<Void> {
//        orderStatusService.deleteOrderStatus(id)
//        return ResponseEntity.noContent().build()
//    }

    // code block here

    // @gen-end
}