package org.hau21cn4nhom9.chompchompfooddeliveryserver.service

import org.hau21cn4nhom9.chompchompfooddeliveryserver.entity.VoucherType
import org.hau21cn4nhom9.chompchompfooddeliveryserver.repository.VoucherTypeRepository
import org.hau21cn4nhom9.chompchompfooddeliveryserver.updateEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class VoucherTypeService(private val voucherTypeRepository: VoucherTypeRepository) {
    // @gen-start

    fun getAllVoucherTypes(pageable: Pageable): Page<VoucherType> = voucherTypeRepository.findAll(pageable)

    fun getVoucherTypeById(id: Byte): VoucherType? = voucherTypeRepository.findById(id).orElse(null)

    fun saveVoucherType(voucherType: VoucherType): VoucherType = voucherTypeRepository.save(voucherType)

    @Transactional
    fun updateVoucherType(id: Byte, updatedVoucherType: VoucherType): VoucherType? {
        return if (voucherTypeRepository.existsById(id)) {
            val existingVoucherType: VoucherType = voucherTypeRepository.findById(id).get()
            updateEntity(existingVoucherType, updatedVoucherType)
            voucherTypeRepository.save(existingVoucherType)
        } else {
            null
        }
    }

    @Transactional
    fun deleteVoucherType(id: Byte) = voucherTypeRepository.deleteById(id)

    // code block here

    // @gen-end
}