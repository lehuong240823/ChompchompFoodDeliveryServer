package org.hau21cn4nhom9.chompchompfooddeliveryserver.repository

import org.hau21cn4nhom9.chompchompfooddeliveryserver.entity.AccountRole
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface AccountRoleRepository: JpaRepository<AccountRole, Byte> {
    // @gen-start

    override fun findAll(pageable: Pageable): Page<AccountRole>

    // code block here

    // @gen-end
}