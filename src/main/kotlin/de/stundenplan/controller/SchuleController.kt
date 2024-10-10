package de.stundenplan.controller

import de.stundenplan.controller.dto.SchuleDto
import de.stundenplan.model.Schulform
import de.stundenplan.service.SchuleService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/schule")
class SchuleController(val service: SchuleService) {

    @GetMapping
    fun getAllSchulen(): List<SchuleDto> = service.findSchulen()

    @GetMapping("/bySchulform/{schulform}")
    fun getBySchulform(@PathVariable schulform: String): List<SchuleDto> {
        return service.findSchulenBySchulform(Schulform.valueOf(schulform.uppercase()))
    }

    @GetMapping("/bySchulId/{schulId}")
    fun getBySchulId(@PathVariable schulId: String): List<SchuleDto> {
        return service.findSchulenBySchulId(schulId)
    }

    @PutMapping
    fun createSchule(@RequestBody schule: SchuleDto): ResponseEntity<String> {

        if (service.exists(schule.schulId)) {
            return ResponseEntity("Schul-ID existiert bereits", HttpStatus.BAD_REQUEST)
        } else {
            service.create(schule)
            return ResponseEntity("Gespeichert", HttpStatus.OK)
        }
    }
}