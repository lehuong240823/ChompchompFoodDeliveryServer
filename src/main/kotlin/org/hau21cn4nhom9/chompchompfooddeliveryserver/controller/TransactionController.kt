package org.hau21cn4nhom9.chompchompfooddeliveryserver.controller

import org.hau21cn4nhom9.chompchompfooddeliveryserver.entity.Transaction
import org.hau21cn4nhom9.chompchompfooddeliveryserver.service.TransactionService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/transactions")
class TransactionController(private val transactionService: TransactionService) {
    // @gen-start

    @GetMapping
    fun getAllTransactions(@PageableDefault(size = 10) pageable: Pageable): Page<Transaction> = transactionService.getAllTransactions(pageable)

    @GetMapping("/{id}")
    fun getTransactionById(@PathVariable id: Int): ResponseEntity<Transaction> {
        val transaction = transactionService.getTransactionById(id)
        return if (transaction != null) ResponseEntity.ok(transaction) else ResponseEntity.notFound().build()
    }

    @PostMapping
    fun createTransaction(@RequestBody transaction: Transaction): Transaction = transactionService.saveTransaction(transaction)

    @PutMapping("/{id}")
    fun updateTransaction(@PathVariable id: Int, @RequestBody updatedTransaction: Transaction): ResponseEntity<Transaction> {
        val transaction = transactionService.updateTransaction(id, updatedTransaction)
        return if (transaction != null) ResponseEntity.ok(transaction) else ResponseEntity.notFound().build()
    }

    @DeleteMapping("/{id}")
    fun deleteTransaction(@PathVariable id: Int): ResponseEntity<Void> {
        transactionService.deleteTransaction(id)
        return ResponseEntity.noContent().build()
    }

    @GetMapping("/orders/{id}")
    fun findTransactionsByOrderId(@PageableDefault(size = 10) pageable: Pageable, @PathVariable id: Int): Page<Transaction> = transactionService.findTransactionsByOrderId(pageable, id)
    
    @GetMapping("/payment-methods/{id}")
    fun findTransactionsByPaymentMethodId(@PageableDefault(size = 10) pageable: Pageable, @PathVariable id: Byte): Page<Transaction> = transactionService.findTransactionsByPaymentMethodId(pageable, id)
    
    @GetMapping("/buyer-payments/{id}")
    fun findTransactionsByBuyerPaymentId(@PageableDefault(size = 10) pageable: Pageable, @PathVariable id: Int): Page<Transaction> = transactionService.findTransactionsByBuyerPaymentId(pageable, id)
    
    @GetMapping("/transaction-statuses/{id}")
    fun findTransactionsByTransactionStatusId(@PageableDefault(size = 10) pageable: Pageable, @PathVariable id: Byte): Page<Transaction> = transactionService.findTransactionsByTransactionStatusId(pageable, id)
    
    // code block here

    // @gen-end
}