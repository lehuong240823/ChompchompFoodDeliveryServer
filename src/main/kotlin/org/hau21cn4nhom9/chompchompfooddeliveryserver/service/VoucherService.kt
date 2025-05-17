package org.hau21cn4nhom9.chompchompfooddeliveryserver.service

import org.hau21cn4nhom9.chompchompfooddeliveryserver.entity.Voucher
import org.hau21cn4nhom9.chompchompfooddeliveryserver.repository.VoucherRepository
import org.hau21cn4nhom9.chompchompfooddeliveryserver.updateEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class VoucherService(private val voucherRepository: VoucherRepository) {
    // @gen-start

    fun getAllVouchers(pageable: Pageable): Page<Voucher> = voucherRepository.findAll(pageable)

    fun getVoucherById(id: Int): Voucher? = voucherRepository.findById(id).orElse(null)

    fun saveVoucher(voucher: Voucher): Voucher = voucherRepository.save(voucher)

    @Transactional
    fun updateVoucher(id: Int, updatedVoucher: Voucher): Voucher? {
        return if (voucherRepository.existsById(id)) {
            val existingVoucher: Voucher = voucherRepository.findById(id).get()
            updateEntity(existingVoucher, updatedVoucher)
            voucherRepository.save(existingVoucher)
        } else {
            null
        }
    }

    @Transactional
    fun deleteVoucher(id: Int) = voucherRepository.deleteById(id)

    fun findVouchersByVoucherTypeId(pageable: Pageable, id: Byte): Page<Voucher> = voucherRepository.findVouchersByVoucherType_Id(pageable, id)

    // code block here

    // @gen-end
}