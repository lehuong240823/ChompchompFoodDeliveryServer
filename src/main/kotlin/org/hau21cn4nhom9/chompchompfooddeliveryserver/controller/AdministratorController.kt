package org.hau21cn4nhom9.chompchompfooddeliveryserver.controller

import org.hau21cn4nhom9.chompchompfooddeliveryserver.entity.Administrator
import org.hau21cn4nhom9.chompchompfooddeliveryserver.service.AdministratorService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/administrators")
class AdministratorController(private val administratorService: AdministratorService) {
    // @gen-start

    @GetMapping
    fun getAllAdministrators(@PageableDefault(size = 10) pageable: Pageable): Page<Administrator> = administratorService.getAllAdministrators(pageable)

    @GetMapping("/{id}")
    fun getAdministratorById(@PathVariable id: Int): ResponseEntity<Administrator> {
        val administrator = administratorService.getAdministratorById(id)
        return if (administrator != null) ResponseEntity.ok(administrator) else ResponseEntity.notFound().build()
    }

    @PostMapping
    fun createAdministrator(@RequestBody administrator: Administrator): Administrator = administratorService.saveAdministrator(administrator)

    @PutMapping("/{id}")
    fun updateAdministrator(@PathVariable id: Int, @RequestBody updatedAdministrator: Administrator): ResponseEntity<Administrator> {
        val administrator = administratorService.updateAdministrator(id, updatedAdministrator)
        return if (administrator != null) ResponseEntity.ok(administrator) else ResponseEntity.notFound().build()
    }

    @DeleteMapping("/{id}")
    fun deleteAdministrator(@PathVariable id: Int): ResponseEntity<Void> {
        administratorService.deleteAdministrator(id)
        return ResponseEntity.noContent().build()
    }

    @GetMapping("/accounts/{id}")
    fun findAdministratorsByAccountId(@PageableDefault(size = 10) pageable: Pageable, @PathVariable id: Int): Page<Administrator> = administratorService.findAdministratorsByAccountId(pageable, id)
    
    @GetMapping("/access-levels/{id}")
    fun findAdministratorsByAccessLevelId(@PageableDefault(size = 10) pageable: Pageable, @PathVariable id: Byte): Page<Administrator> = administratorService.findAdministratorsByAccessLevelId(pageable, id)
    
    // code block here

    // @gen-end
}