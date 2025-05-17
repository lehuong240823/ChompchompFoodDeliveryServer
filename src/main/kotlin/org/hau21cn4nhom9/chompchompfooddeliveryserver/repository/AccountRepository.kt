package org.hau21cn4nhom9.chompchompfooddeliveryserver.repository

import org.hau21cn4nhom9.chompchompfooddeliveryserver.entity.Account
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface AccountRepository: JpaRepository<Account, Int> {
    // @gen-start

    override fun findAll(pageable: Pageable): Page<Account>

    fun findAccountsByAccountRole_Id(pageable: Pageable, id: Byte): Page<Account>

    fun findAccountsByAccountStatus_Id(pageable: Pageable, id: Byte): Page<Account>

    // code block here

    // @gen-end
}