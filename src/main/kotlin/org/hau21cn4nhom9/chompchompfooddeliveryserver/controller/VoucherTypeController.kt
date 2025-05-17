package org.hau21cn4nhom9.chompchompfooddeliveryserver.controller

import org.hau21cn4nhom9.chompchompfooddeliveryserver.entity.VoucherType
import org.hau21cn4nhom9.chompchompfooddeliveryserver.service.VoucherTypeService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/voucher-types")
class VoucherTypeController(private val voucherTypeService: VoucherTypeService) {
    // @gen-start

    @GetMapping
    fun getAllVoucherTypes(@PageableDefault(size = 10) pageable: Pageable): Page<VoucherType> = voucherTypeService.getAllVoucherTypes(pageable)

    @GetMapping("/{id}")
    fun getVoucherTypeById(@PathVariable id: Byte): ResponseEntity<VoucherType> {
        val voucherType = voucherTypeService.getVoucherTypeById(id)
        return if (voucherType != null) ResponseEntity.ok(voucherType) else ResponseEntity.notFound().build()
    }

    @PostMapping
    fun createVoucherType(@RequestBody voucherType: VoucherType): VoucherType = voucherTypeService.saveVoucherType(voucherType)

    @PutMapping("/{id}")
    fun updateVoucherType(@PathVariable id: Byte, @RequestBody updatedVoucherType: VoucherType): ResponseEntity<VoucherType> {
        val voucherType = voucherTypeService.updateVoucherType(id, updatedVoucherType)
        return if (voucherType != null) ResponseEntity.ok(voucherType) else ResponseEntity.notFound().build()
    }

    @DeleteMapping("/{id}")
    fun deleteVoucherType(@PathVariable id: Byte): ResponseEntity<Void> {
        voucherTypeService.deleteVoucherType(id)
        return ResponseEntity.noContent().build()
    }

    // code block here

    // @gen-end
}