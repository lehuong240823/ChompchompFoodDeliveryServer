package org.hau21cn4nhom9.chompchompfooddeliveryserver.repository

import org.hau21cn4nhom9.chompchompfooddeliveryserver.entity.Administrator
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface AdministratorRepository: JpaRepository<Administrator, Int> {
    // @gen-start

    override fun findAll(pageable: Pageable): Page<Administrator>

    fun findAdministratorsByAccount_Id(pageable: Pageable, id: Int): Page<Administrator>

    fun findAdministratorsByAccessLevel_Id(pageable: Pageable, id: Byte): Page<Administrator>

    // code block here

    // @gen-end
}