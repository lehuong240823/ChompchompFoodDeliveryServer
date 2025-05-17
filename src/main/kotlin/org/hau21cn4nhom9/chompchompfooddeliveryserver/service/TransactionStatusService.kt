package org.hau21cn4nhom9.chompchompfooddeliveryserver.service

import org.hau21cn4nhom9.chompchompfooddeliveryserver.entity.TransactionStatus
import org.hau21cn4nhom9.chompchompfooddeliveryserver.repository.TransactionStatusRepository
import org.hau21cn4nhom9.chompchompfooddeliveryserver.updateEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class TransactionStatusService(private val transactionStatusRepository: TransactionStatusRepository) {
    // @gen-start

    fun getAllTransactionStatuses(pageable: Pageable): Page<TransactionStatus> = transactionStatusRepository.findAll(pageable)

    fun getTransactionStatusById(id: Byte): TransactionStatus? = transactionStatusRepository.findById(id).orElse(null)

    fun saveTransactionStatus(transactionStatus: TransactionStatus): TransactionStatus = transactionStatusRepository.save(transactionStatus)

    @Transactional
    fun updateTransactionStatus(id: Byte, updatedTransactionStatus: TransactionStatus): TransactionStatus? {
        return if (transactionStatusRepository.existsById(id)) {
            val existingTransactionStatus: TransactionStatus = transactionStatusRepository.findById(id).get()
            updateEntity(existingTransactionStatus, updatedTransactionStatus)
            transactionStatusRepository.save(existingTransactionStatus)
        } else {
            null
        }
    }

    @Transactional
    fun deleteTransactionStatus(id: Byte) = transactionStatusRepository.deleteById(id)

    // code block here

    // @gen-end
}