package org.hau21cn4nhom9.chompchompfooddeliveryserver.service

import org.hau21cn4nhom9.chompchompfooddeliveryserver.entity.Transaction
import org.hau21cn4nhom9.chompchompfooddeliveryserver.repository.TransactionRepository
import org.hau21cn4nhom9.chompchompfooddeliveryserver.updateEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class TransactionService(private val transactionRepository: TransactionRepository) {
    // @gen-start

    fun getAllTransactions(pageable: Pageable): Page<Transaction> = transactionRepository.findAll(pageable)

    fun getTransactionById(id: Int): Transaction? = transactionRepository.findById(id).orElse(null)

    fun saveTransaction(transaction: Transaction): Transaction = transactionRepository.save(transaction)

    @Transactional
    fun updateTransaction(id: Int, updatedTransaction: Transaction): Transaction? {
        return if (transactionRepository.existsById(id)) {
            val existingTransaction: Transaction = transactionRepository.findById(id).get()
            updateEntity(existingTransaction, updatedTransaction)
            transactionRepository.save(existingTransaction)
        } else {
            null
        }
    }

    @Transactional
    fun deleteTransaction(id: Int) = transactionRepository.deleteById(id)

    fun findTransactionsByOrderId(pageable: Pageable, id: Int): Page<Transaction> = transactionRepository.findTransactionsByOrder_Id(pageable, id)

    fun findTransactionsByPaymentMethodId(pageable: Pageable, id: Byte): Page<Transaction> = transactionRepository.findTransactionsByPaymentMethod_Id(pageable, id)

    fun findTransactionsByBuyerPaymentId(pageable: Pageable, id: Int): Page<Transaction> = transactionRepository.findTransactionsByBuyerPayment_Id(pageable, id)

    fun findTransactionsByTransactionStatusId(pageable: Pageable, id: Byte): Page<Transaction> = transactionRepository.findTransactionsByTransactionStatus_Id(pageable, id)

    // code block here

    // @gen-end
}