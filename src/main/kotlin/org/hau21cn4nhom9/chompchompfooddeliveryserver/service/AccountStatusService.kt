package org.hau21cn4nhom9.chompchompfooddeliveryserver.service

import org.hau21cn4nhom9.chompchompfooddeliveryserver.entity.AccountStatus
import org.hau21cn4nhom9.chompchompfooddeliveryserver.repository.AccountStatusRepository
import org.hau21cn4nhom9.chompchompfooddeliveryserver.updateEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AccountStatusService(private val accountStatusRepository: AccountStatusRepository) {
    // @gen-start

    fun getAllAccountStatuses(pageable: Pageable): Page<AccountStatus> = accountStatusRepository.findAll(pageable)

    fun getAccountStatusById(id: Byte): AccountStatus? = accountStatusRepository.findById(id).orElse(null)

    fun saveAccountStatus(accountStatus: AccountStatus): AccountStatus = accountStatusRepository.save(accountStatus)

    @Transactional
    fun updateAccountStatus(id: Byte, updatedAccountStatus: AccountStatus): AccountStatus? {
        return if (accountStatusRepository.existsById(id)) {
            val existingAccountStatus: AccountStatus = accountStatusRepository.findById(id).get()
            updateEntity(existingAccountStatus, updatedAccountStatus)
            accountStatusRepository.save(existingAccountStatus)
        } else {
            null
        }
    }

    @Transactional
    fun deleteAccountStatus(id: Byte) = accountStatusRepository.deleteById(id)

    // code block here

    // @gen-end
}