package org.hau21cn4nhom9.chompchompfooddeliveryserver.service

import org.hau21cn4nhom9.chompchompfooddeliveryserver.entity.BuyerPayment
import org.hau21cn4nhom9.chompchompfooddeliveryserver.repository.BuyerPaymentRepository
import org.hau21cn4nhom9.chompchompfooddeliveryserver.updateEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class BuyerPaymentService(private val buyerPaymentRepository: BuyerPaymentRepository) {
    // @gen-start

    fun getAllBuyerPayments(pageable: Pageable): Page<BuyerPayment> = buyerPaymentRepository.findAll(pageable)

    fun getBuyerPaymentById(id: Int): BuyerPayment? = buyerPaymentRepository.findById(id).orElse(null)

    fun saveBuyerPayment(buyerPayment: BuyerPayment): BuyerPayment = buyerPaymentRepository.save(buyerPayment)

    @Transactional
    fun updateBuyerPayment(id: Int, updatedBuyerPayment: BuyerPayment): BuyerPayment? {
        return if (buyerPaymentRepository.existsById(id)) {
            val existingBuyerPayment: BuyerPayment = buyerPaymentRepository.findById(id).get()
            updateEntity(existingBuyerPayment, updatedBuyerPayment)
            buyerPaymentRepository.save(existingBuyerPayment)
        } else {
            null
        }
    }

    @Transactional
    fun deleteBuyerPayment(id: Int) = buyerPaymentRepository.deleteById(id)

    fun findBuyerPaymentsByBuyer(pageable: Pageable, id: Int): Page<BuyerPayment> = buyerPaymentRepository.findBuyerPaymentsByBuyer(pageable, id)

    fun findBuyerPaymentsByPaymentMethodId(pageable: Pageable, id: Byte): Page<BuyerPayment> = buyerPaymentRepository.findBuyerPaymentsByPaymentMethod_Id(pageable, id)

    // code block here

    // @gen-end
}