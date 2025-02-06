package de.stundenplan.controller

import de.stundenplan.controller.dto.FachDto
import de.stundenplan.service.FachService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/fach")
class FachController(val service: FachService) {

//    @GetMapping
//    fun getAllFachList(): List<FachDto> = service.findFachList()
//
//    @PutMapping
//    fun createFach(@RequestBody fachDto: FachDto): ResponseEntity<String> {
//
//        if (service.exists(fachDto.bezeichnung)) {
//            return ResponseEntity("Fach existiert bereits", HttpStatus.BAD_REQUEST)
//        } else {
//            service.create(fachDto)
//            return ResponseEntity("Gespeichert", HttpStatus.OK)
//        }
//    }
}