package org.hau21cn4nhom9.chompchompfooddeliveryserver.service

import org.hau21cn4nhom9.chompchompfooddeliveryserver.entity.AccessLevel
import org.hau21cn4nhom9.chompchompfooddeliveryserver.repository.AccessLevelRepository
import org.hau21cn4nhom9.chompchompfooddeliveryserver.updateEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AccessLevelService(private val accessLevelRepository: AccessLevelRepository) {
    // @gen-start

    fun getAllAccessLevels(pageable: Pageable): Page<AccessLevel> = accessLevelRepository.findAll(pageable)

    fun getAccessLevelById(id: Byte): AccessLevel? = accessLevelRepository.findById(id).orElse(null)

    fun saveAccessLevel(accessLevel: AccessLevel): AccessLevel = accessLevelRepository.save(accessLevel)

    @Transactional
    fun updateAccessLevel(id: Byte, updatedAccessLevel: AccessLevel): AccessLevel? {
        return if (accessLevelRepository.existsById(id)) {
            val existingAccessLevel: AccessLevel = accessLevelRepository.findById(id).get()
            updateEntity(existingAccessLevel, updatedAccessLevel)
            accessLevelRepository.save(existingAccessLevel)
        } else {
            null
        }
    }

    @Transactional
    fun deleteAccessLevel(id: Byte) = accessLevelRepository.deleteById(id)

    // code block here

    // @gen-end
}