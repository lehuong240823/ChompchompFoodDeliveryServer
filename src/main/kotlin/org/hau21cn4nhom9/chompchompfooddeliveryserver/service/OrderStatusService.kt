package org.hau21cn4nhom9.chompchompfooddeliveryserver.service

import org.hau21cn4nhom9.chompchompfooddeliveryserver.entity.OrderStatus
import org.hau21cn4nhom9.chompchompfooddeliveryserver.repository.OrderStatusRepository
import org.hau21cn4nhom9.chompchompfooddeliveryserver.updateEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class OrderStatusService(private val orderStatusRepository: OrderStatusRepository) {
    // @gen-start

    fun getAllOrderStatuses(pageable: Pageable): Page<OrderStatus> = orderStatusRepository.findAll(pageable)

    fun getOrderStatusById(id: Byte): OrderStatus? = orderStatusRepository.findById(id).orElse(null)

    fun saveOrderStatus(orderStatus: OrderStatus): OrderStatus = orderStatusRepository.save(orderStatus)

    @Transactional
    fun updateOrderStatus(id: Byte, updatedOrderStatus: OrderStatus): OrderStatus? {
        return if (orderStatusRepository.existsById(id)) {
            val existingOrderStatus: OrderStatus = orderStatusRepository.findById(id).get()
            updateEntity(existingOrderStatus, updatedOrderStatus)
            orderStatusRepository.save(existingOrderStatus)
        } else {
            null
        }
    }

    @Transactional
    fun deleteOrderStatus(id: Byte) = orderStatusRepository.deleteById(id)

    // code block here

    // @gen-end
}