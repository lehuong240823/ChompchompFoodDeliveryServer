package org.hau21cn4nhom9.chompchompfooddeliveryserver.controller

import org.hau21cn4nhom9.chompchompfooddeliveryserver.entity.Voucher
import org.hau21cn4nhom9.chompchompfooddeliveryserver.service.VoucherService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/vouchers")
class VoucherController(private val voucherService: VoucherService) {
    // @gen-start

    @GetMapping
    fun getAllVouchers(@PageableDefault(size = 10) pageable: Pageable): Page<Voucher> = voucherService.getAllVouchers(pageable)

    @GetMapping("/{id}")
    fun getVoucherById(@PathVariable id: Int): ResponseEntity<Voucher> {
        val voucher = voucherService.getVoucherById(id)
        return if (voucher != null) ResponseEntity.ok(voucher) else ResponseEntity.notFound().build()
    }

    @PostMapping
    fun createVoucher(@RequestBody voucher: Voucher): Voucher = voucherService.saveVoucher(voucher)

    @PutMapping("/{id}")
    fun updateVoucher(@PathVariable id: Int, @RequestBody updatedVoucher: Voucher): ResponseEntity<Voucher> {
        val voucher = voucherService.updateVoucher(id, updatedVoucher)
        return if (voucher != null) ResponseEntity.ok(voucher) else ResponseEntity.notFound().build()
    }

    @DeleteMapping("/{id}")
    fun deleteVoucher(@PathVariable id: Int): ResponseEntity<Void> {
        voucherService.deleteVoucher(id)
        return ResponseEntity.noContent().build()
    }

    @GetMapping("/voucher-types/{id}")
    fun findVouchersByVoucherTypeId(@PageableDefault(size = 10) pageable: Pageable, @PathVariable id: Byte): Page<Voucher> = voucherService.findVouchersByVoucherTypeId(pageable, id)
    
    // code block here

    // @gen-end
}