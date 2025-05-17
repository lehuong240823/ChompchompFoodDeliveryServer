package org.hau21cn4nhom9.chompchompfooddeliveryserver.repository

import org.hau21cn4nhom9.chompchompfooddeliveryserver.entity.AccessLevel
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface AccessLevelRepository: JpaRepository<AccessLevel, Byte> {
    // @gen-start

    override fun findAll(pageable: Pageable): Page<AccessLevel>

    // code block here

    // @gen-end
}