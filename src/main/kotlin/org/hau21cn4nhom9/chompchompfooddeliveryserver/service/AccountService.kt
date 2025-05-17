package org.hau21cn4nhom9.chompchompfooddeliveryserver.service

import org.hau21cn4nhom9.chompchompfooddeliveryserver.entity.Account
import org.hau21cn4nhom9.chompchompfooddeliveryserver.repository.AccountRepository
import org.hau21cn4nhom9.chompchompfooddeliveryserver.updateEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AccountService(private val accountRepository: AccountRepository) {
    // @gen-start

    fun getAllAccounts(pageable: Pageable): Page<Account> = accountRepository.findAll(pageable)

    fun getAccountById(id: Int): Account? = accountRepository.findById(id).orElse(null)

    fun saveAccount(account: Account): Account = accountRepository.save(account)

    @Transactional
    fun updateAccount(id: Int, updatedAccount: Account): Account? {
        return if (accountRepository.existsById(id)) {
            val existingAccount: Account = accountRepository.findById(id).get()
            updateEntity(existingAccount, updatedAccount)
            accountRepository.save(existingAccount)
        } else {
            null
        }
    }

    @Transactional
    fun deleteAccount(id: Int) = accountRepository.deleteById(id)

    fun findAccountsByAccountRoleId(pageable: Pageable, id: Byte): Page<Account> = accountRepository.findAccountsByAccountRole_Id(pageable, id)

    fun findAccountsByAccountStatusId(pageable: Pageable, id: Byte): Page<Account> = accountRepository.findAccountsByAccountStatus_Id(pageable, id)

    // code block here

    // @gen-end
}