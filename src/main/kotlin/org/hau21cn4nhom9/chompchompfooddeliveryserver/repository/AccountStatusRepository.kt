package org.hau21cn4nhom9.chompchompfooddeliveryserver.repository

import org.hau21cn4nhom9.chompchompfooddeliveryserver.entity.AccountStatus
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface AccountStatusRepository: JpaRepository<AccountStatus, Byte> {
    // @gen-start

    override fun findAll(pageable: Pageable): Page<AccountStatus>

    // code block here

    // @gen-end
}