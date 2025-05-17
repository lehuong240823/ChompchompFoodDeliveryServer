package org.hau21cn4nhom9.chompchompfooddeliveryserver.service

import org.hau21cn4nhom9.chompchompfooddeliveryserver.entity.Order
import org.hau21cn4nhom9.chompchompfooddeliveryserver.repository.OrderRepository
import org.hau21cn4nhom9.chompchompfooddeliveryserver.updateEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class OrderService(private val orderRepository: OrderRepository) {
    // @gen-start

    fun getAllOrders(pageable: Pageable): Page<Order> = orderRepository.findAll(pageable)

    fun getOrderById(id: Int): Order? = orderRepository.findById(id).orElse(null)

    fun saveOrder(order: Order): Order = orderRepository.save(order)

    @Transactional
    fun updateOrder(id: Int, updatedOrder: Order): Order? {
        return if (orderRepository.existsById(id)) {
            val existingOrder: Order = orderRepository.findById(id).get()
            updateEntity(existingOrder, updatedOrder)
            orderRepository.save(existingOrder)
        } else {
            null
        }
    }

    @Transactional
    fun deleteOrder(id: Int) = orderRepository.deleteById(id)

    fun findOrdersByBuyer(pageable: Pageable, id: Int): Page<Order> = orderRepository.findOrdersByBuyer(pageable, id)

    fun findOrdersByOrderStatusId(pageable: Pageable, id: Byte): Page<Order> = orderRepository.findOrdersByOrderStatus_Id(pageable, id)

    fun findOrdersByBuyerAddressId(pageable: Pageable, id: Int): Page<Order> = orderRepository.findOrdersByBuyerAddress_Id(pageable, id)

    fun findOrdersByVoucherId(pageable: Pageable, id: Int): Page<Order> = orderRepository.findOrdersByVoucher_Id(pageable, id)

    // code block here

    // @gen-end
}