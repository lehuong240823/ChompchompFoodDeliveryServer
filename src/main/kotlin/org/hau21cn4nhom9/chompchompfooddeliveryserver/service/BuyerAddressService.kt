package org.hau21cn4nhom9.chompchompfooddeliveryserver.service

import org.hau21cn4nhom9.chompchompfooddeliveryserver.entity.BuyerAddress
import org.hau21cn4nhom9.chompchompfooddeliveryserver.repository.BuyerAddressRepository
import org.hau21cn4nhom9.chompchompfooddeliveryserver.updateEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class BuyerAddressService(private val buyerAddressRepository: BuyerAddressRepository) {
    // @gen-start

    fun getAllBuyerAddresses(pageable: Pageable): Page<BuyerAddress> = buyerAddressRepository.findAll(pageable)

    fun getBuyerAddressById(id: Int): BuyerAddress? = buyerAddressRepository.findById(id).orElse(null)

    fun saveBuyerAddress(buyerAddress: BuyerAddress): BuyerAddress = buyerAddressRepository.save(buyerAddress)

    @Transactional
    fun updateBuyerAddress(id: Int, updatedBuyerAddress: BuyerAddress): BuyerAddress? {
        return if (buyerAddressRepository.existsById(id)) {
            val existingBuyerAddress: BuyerAddress = buyerAddressRepository.findById(id).get()
            updateEntity(existingBuyerAddress, updatedBuyerAddress)
            buyerAddressRepository.save(existingBuyerAddress)
        } else {
            null
        }
    }

    @Transactional
    fun deleteBuyerAddress(id: Int) = buyerAddressRepository.deleteById(id)

    fun findBuyerAddressesByBuyer(pageable: Pageable, id: Int): Page<BuyerAddress> = buyerAddressRepository.findBuyerAddressesByBuyer(pageable, id)

    // code block here

    // @gen-end
}