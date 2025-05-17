package org.hau21cn4nhom9.chompchompfooddeliveryserver.service

import org.hau21cn4nhom9.chompchompfooddeliveryserver.entity.PaymentMethod
import org.hau21cn4nhom9.chompchompfooddeliveryserver.repository.PaymentMethodRepository
import org.hau21cn4nhom9.chompchompfooddeliveryserver.updateEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class PaymentMethodService(private val paymentMethodRepository: PaymentMethodRepository) {
    // @gen-start

    fun getAllPaymentMethods(pageable: Pageable): Page<PaymentMethod> = paymentMethodRepository.findAll(pageable)

    fun getPaymentMethodById(id: Byte): PaymentMethod? = paymentMethodRepository.findById(id).orElse(null)

    fun savePaymentMethod(paymentMethod: PaymentMethod): PaymentMethod = paymentMethodRepository.save(paymentMethod)

    @Transactional
    fun updatePaymentMethod(id: Byte, updatedPaymentMethod: PaymentMethod): PaymentMethod? {
        return if (paymentMethodRepository.existsById(id)) {
            val existingPaymentMethod: PaymentMethod = paymentMethodRepository.findById(id).get()
            updateEntity(existingPaymentMethod, updatedPaymentMethod)
            paymentMethodRepository.save(existingPaymentMethod)
        } else {
            null
        }
    }

    @Transactional
    fun deletePaymentMethod(id: Byte) = paymentMethodRepository.deleteById(id)

    // code block here

    // @gen-end
}