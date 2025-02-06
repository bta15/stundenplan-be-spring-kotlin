package de.stundenplan.service

import de.stundenplan.controller.dto.KlasseDto
import de.stundenplan.mapper.DtoMapper
import de.stundenplan.mapper.EntityMapper
import de.stundenplan.model.Klasse
import de.stundenplan.repository.FachRepository
import de.stundenplan.repository.KlasseRepository
import de.stundenplan.repository.SchuleRepository
import org.springframework.stereotype.Service

@Service
class KlasseService(val klasseRepository: KlasseRepository, val schuleRepository: SchuleRepository) {

    fun findBySchulId(schulId: String): List<KlasseDto> {
        val schule = schuleRepository.findBySchulId(schulId)
        val klassenBySchule = klasseRepository.findBySchule(schule).toList()
        val klassenDtoList =
            klassenBySchule.map { klasse: Klasse -> KlasseDto(klasse.klassenstufe, klasse.bezeichnung, listOf()) }
        return klassenDtoList
    }

    fun create(schulId: String, klasseDto: KlasseDto) {
        val schule = schuleRepository.findBySchulId(schulId)
        val klasse = Klasse(null, klasseDto.klassenstufe, klasseDto.bezeichnung, schule, listOf())
        klasseRepository.save(klasse)
    }
}