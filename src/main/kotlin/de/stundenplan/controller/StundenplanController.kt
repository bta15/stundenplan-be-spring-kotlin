package de.stundenplan.controller

import de.stundenplan.controller.dto.SchuleDto
import de.stundenplan.controller.dto.StundenplanDto
import de.stundenplan.service.StundenplanService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/stundenplan")
class StundenplanController(val service: StundenplanService) {

    @GetMapping("/schule/{schulId}")
    fun getBySchulId(@PathVariable schulId: String): List<StundenplanDto> {
        return service.getBySchule(schulId)
    }

    @PutMapping
    fun createStundenplan(@RequestBody stundenplanDto: StundenplanDto): ResponseEntity<String> {
        service.create(stundenplanDto)
        return ResponseEntity("Gespeichert", HttpStatus.OK)
    }
}