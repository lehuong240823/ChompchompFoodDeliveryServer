package org.hau21cn4nhom9.chompchompfooddeliveryserver.service

import org.hau21cn4nhom9.chompchompfooddeliveryserver.entity.Buyer
import org.hau21cn4nhom9.chompchompfooddeliveryserver.repository.BuyerRepository
import org.hau21cn4nhom9.chompchompfooddeliveryserver.updateEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class BuyerService(private val buyerRepository: BuyerRepository) {
    // @gen-start

    fun getAllBuyers(pageable: Pageable): Page<Buyer> = buyerRepository.findAll(pageable)

    fun getBuyerById(id: Int): Buyer? = buyerRepository.findById(id).orElse(null)

    fun saveBuyer(buyer: Buyer): Buyer = buyerRepository.save(buyer)

    @Transactional
    fun updateBuyer(id: Int, updatedBuyer: Buyer): Buyer? {
        return if (buyerRepository.existsById(id)) {
            val existingBuyer: Buyer = buyerRepository.findById(id).get()
            updateEntity(existingBuyer, updatedBuyer)
            buyerRepository.save(existingBuyer)
        } else {
            null
        }
    }

    @Transactional
    fun deleteBuyer(id: Int) = buyerRepository.deleteById(id)

    fun findBuyersByAccountId(pageable: Pageable, id: Int): Page<Buyer> = buyerRepository.findBuyersByAccount_Id(pageable, id)

    // code block here

    // @gen-end
}