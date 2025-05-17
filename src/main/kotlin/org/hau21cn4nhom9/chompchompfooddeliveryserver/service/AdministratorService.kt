package org.hau21cn4nhom9.chompchompfooddeliveryserver.service

import org.hau21cn4nhom9.chompchompfooddeliveryserver.entity.Administrator
import org.hau21cn4nhom9.chompchompfooddeliveryserver.repository.AdministratorRepository
import org.hau21cn4nhom9.chompchompfooddeliveryserver.updateEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AdministratorService(private val administratorRepository: AdministratorRepository) {
    // @gen-start

    fun getAllAdministrators(pageable: Pageable): Page<Administrator> = administratorRepository.findAll(pageable)

    fun getAdministratorById(id: Int): Administrator? = administratorRepository.findById(id).orElse(null)

    fun saveAdministrator(administrator: Administrator): Administrator = administratorRepository.save(administrator)

    @Transactional
    fun updateAdministrator(id: Int, updatedAdministrator: Administrator): Administrator? {
        return if (administratorRepository.existsById(id)) {
            val existingAdministrator: Administrator = administratorRepository.findById(id).get()
            updateEntity(existingAdministrator, updatedAdministrator)
            administratorRepository.save(existingAdministrator)
        } else {
            null
        }
    }

    @Transactional
    fun deleteAdministrator(id: Int) = administratorRepository.deleteById(id)

    fun findAdministratorsByAccountId(pageable: Pageable, id: Int): Page<Administrator> = administratorRepository.findAdministratorsByAccount_Id(pageable, id)

    fun findAdministratorsByAccessLevelId(pageable: Pageable, id: Byte): Page<Administrator> = administratorRepository.findAdministratorsByAccessLevel_Id(pageable, id)

    // code block here

    // @gen-end
}