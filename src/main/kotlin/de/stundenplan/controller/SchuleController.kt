package de.stundenplan.controller

import de.stundenplan.model.Schule
import de.stundenplan.service.SchuleService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/schule")
class SchuleController(val service: SchuleService) {

    @GetMapping
    fun index(): List<Schule> = service.findMessages()

    @PutMapping
    fun post(@RequestBody schule: Schule): ResponseEntity<String> {

        if (service.exists(schule.schulId)) {
            return ResponseEntity("Schul-ID existiert bereits", HttpStatus.BAD_REQUEST)
        } else {
            service.save(schule)
            return ResponseEntity("Gespeichert", HttpStatus.OK)
        }
    }
}