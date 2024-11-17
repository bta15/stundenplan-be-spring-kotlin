package de.stundenplan.controller

import de.stundenplan.controller.dto.SchuleDto
import de.stundenplan.controller.dto.StundenplanDto
import de.stundenplan.service.StundenplanService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/schule")
class StundenplanController(val service: StundenplanService) {

    @GetMapping("/bySchule")
    fun getBySchule(@RequestBody schule: SchuleDto): List<StundenplanDto> {
        return service.getBySchule(schule)
    }

    @PutMapping
    fun createStundenplan(@RequestBody schule: SchuleDto): ResponseEntity<String> {
        service.create(schule)
        return ResponseEntity("Gespeichert", HttpStatus.OK)
    }
}