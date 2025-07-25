package org.hau21cn4nhom9.chompchompfooddeliveryserver.controller

import org.hau21cn4nhom9.chompchompfooddeliveryserver.entity.AccessLevel
import org.hau21cn4nhom9.chompchompfooddeliveryserver.service.AccessLevelService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/access-levels")
class AccessLevelController(private val accessLevelService: AccessLevelService) {
    // @gen-start

    @GetMapping
    fun getAllAccessLevels(@PageableDefault(size = 10) pageable: Pageable): Page<AccessLevel> = accessLevelService.getAllAccessLevels(pageable)

    @GetMapping("/{id}")
    fun getAccessLevelById(@PathVariable id: Byte): ResponseEntity<AccessLevel> {
        val accessLevel = accessLevelService.getAccessLevelById(id)
        return if (accessLevel != null) ResponseEntity.ok(accessLevel) else ResponseEntity.notFound().build()
    }

//    @PostMapping
//    fun createAccessLevel(@RequestBody accessLevel: AccessLevel): AccessLevel = accessLevelService.saveAccessLevel(accessLevel)
//
//    @PutMapping("/{id}")
//    fun updateAccessLevel(@PathVariable id: Byte, @RequestBody updatedAccessLevel: AccessLevel): ResponseEntity<AccessLevel> {
//        val accessLevel = accessLevelService.updateAccessLevel(id, updatedAccessLevel)
//        return if (accessLevel != null) ResponseEntity.ok(accessLevel) else ResponseEntity.notFound().build()
//    }
//
//    @DeleteMapping("/{id}")
//    fun deleteAccessLevel(@PathVariable id: Byte): ResponseEntity<Void> {
//        accessLevelService.deleteAccessLevel(id)
//        return ResponseEntity.noContent().build()
//    }

    // code block here

    // @gen-end
}