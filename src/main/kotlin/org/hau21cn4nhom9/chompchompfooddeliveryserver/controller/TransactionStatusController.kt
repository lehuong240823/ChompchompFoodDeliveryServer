package org.hau21cn4nhom9.chompchompfooddeliveryserver.controller

import org.hau21cn4nhom9.chompchompfooddeliveryserver.entity.TransactionStatus
import org.hau21cn4nhom9.chompchompfooddeliveryserver.service.TransactionStatusService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/transaction-statuses")
class TransactionStatusController(private val transactionStatusService: TransactionStatusService) {
    // @gen-start

    @GetMapping
    fun getAllTransactionStatuses(@PageableDefault(size = 10) pageable: Pageable): Page<TransactionStatus> = transactionStatusService.getAllTransactionStatuses(pageable)

    @GetMapping("/{id}")
    fun getTransactionStatusById(@PathVariable id: Byte): ResponseEntity<TransactionStatus> {
        val transactionStatus = transactionStatusService.getTransactionStatusById(id)
        return if (transactionStatus != null) ResponseEntity.ok(transactionStatus) else ResponseEntity.notFound().build()
    }

//    @PostMapping
//    fun createTransactionStatus(@RequestBody transactionStatus: TransactionStatus): TransactionStatus = transactionStatusService.saveTransactionStatus(transactionStatus)
//
//    @PutMapping("/{id}")
//    fun updateTransactionStatus(@PathVariable id: Byte, @RequestBody updatedTransactionStatus: TransactionStatus): ResponseEntity<TransactionStatus> {
//        val transactionStatus = transactionStatusService.updateTransactionStatus(id, updatedTransactionStatus)
//        return if (transactionStatus != null) ResponseEntity.ok(transactionStatus) else ResponseEntity.notFound().build()
//    }
//
//    @DeleteMapping("/{id}")
//    fun deleteTransactionStatus(@PathVariable id: Byte): ResponseEntity<Void> {
//        transactionStatusService.deleteTransactionStatus(id)
//        return ResponseEntity.noContent().build()
//    }

    // code block here

    // @gen-end
}