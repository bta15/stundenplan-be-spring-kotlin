package de.stundenplan.service

import de.stundenplan.controller.dto.FachDto
import de.stundenplan.mapper.EntityMapper
import de.stundenplan.model.Fach
import de.stundenplan.repository.FachRepository
import org.springframework.stereotype.Service

@Service
class FachService(val fachRepository: FachRepository) {
//    fun findFachList(): List<FachDto> {
//        return fachRepository.findAll().toList().map { fach ->  EntityMapper.mapToDto(fach)}
//    }
//
//    fun create(fachDto: FachDto) {
//        val existingFach = fachRepository.findByBezeichnung(fachDto.bezeichnung)
//        if (existingFach.isPresent) {
//            throw IllegalArgumentException("Fach existiert bereits und konnte nicht gespeichert werden")
//        } else {
//            fachRepository.save(Fach(null, fachDto.bezeichnung))
//        }
//    }
//
//    fun exists(bezeichnung: String): Boolean {
//        return fachRepository.existsByBezeichnung(bezeichnung)
//    }
}