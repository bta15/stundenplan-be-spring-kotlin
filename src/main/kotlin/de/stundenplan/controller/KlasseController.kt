package de.stundenplan.controller

import de.stundenplan.controller.dto.KlasseDto
import de.stundenplan.controller.dto.SchuleDto
import de.stundenplan.model.Klasse
import de.stundenplan.model.enums.Schulform
import de.stundenplan.service.KlasseService
import de.stundenplan.service.SchuleService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("schule/{schulId}/klasse")
class KlasseController(val service: KlasseService) {

    @GetMapping
    fun getKlassenBySchulId(@PathVariable schulId: String): List<KlasseDto> {
        return service.findBySchulId(schulId)
    }

    @PostMapping
    fun createKlasse(@PathVariable schulId: String, @RequestBody klasse: KlasseDto): ResponseEntity<String> {
        service.create(schulId, klasse)
        return ResponseEntity("Gespeichert", HttpStatus.OK)
    }
}