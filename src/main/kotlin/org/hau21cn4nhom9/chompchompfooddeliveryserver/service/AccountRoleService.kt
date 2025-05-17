package org.hau21cn4nhom9.chompchompfooddeliveryserver.service

import org.hau21cn4nhom9.chompchompfooddeliveryserver.entity.AccountRole
import org.hau21cn4nhom9.chompchompfooddeliveryserver.repository.AccountRoleRepository
import org.hau21cn4nhom9.chompchompfooddeliveryserver.updateEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AccountRoleService(private val accountRoleRepository: AccountRoleRepository) {
    // @gen-start

    fun getAllAccountRoles(pageable: Pageable): Page<AccountRole> = accountRoleRepository.findAll(pageable)

    fun getAccountRoleById(id: Byte): AccountRole? = accountRoleRepository.findById(id).orElse(null)

    fun saveAccountRole(accountRole: AccountRole): AccountRole = accountRoleRepository.save(accountRole)

    @Transactional
    fun updateAccountRole(id: Byte, updatedAccountRole: AccountRole): AccountRole? {
        return if (accountRoleRepository.existsById(id)) {
            val existingAccountRole: AccountRole = accountRoleRepository.findById(id).get()
            updateEntity(existingAccountRole, updatedAccountRole)
            accountRoleRepository.save(existingAccountRole)
        } else {
            null
        }
    }

    @Transactional
    fun deleteAccountRole(id: Byte) = accountRoleRepository.deleteById(id)

    // code block here

    // @gen-end
}