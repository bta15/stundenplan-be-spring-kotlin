package de.stundenplan.service

import de.stundenplan.controller.dto.KlasseDto
import de.stundenplan.controller.dto.SchuleDto
import de.stundenplan.model.Schule
import de.stundenplan.model.Schulform
import de.stundenplan.repository.SchuleRepository
import org.springframework.stereotype.Service

@Service
class SchuleService(val schuleRepository: SchuleRepository) {
    fun findSchulen(): List<SchuleDto> {
        return mapToDto(schuleRepository.findAll().toList())
    }

    fun findSchulenBySchulform(schulform: Schulform): List<SchuleDto> {
        return mapToDto(schuleRepository.findBySchulform(schulform).toList())
    }

    fun findSchulenBySchulId(schulId: String): List<SchuleDto> {
        return mapToDto(schuleRepository.findBySchulId(schulId).toList())
    }

    fun save(schule: Schule) {
        schule.klassen.forEach { klasse -> klasse.schule = schule }
        schuleRepository.save(schule)
    }

    fun exists(schulId: String): Boolean {
        return schuleRepository.existsBySchulId(schulId)
    }

    private fun mapToDto(schulen: List<Schule>): List<SchuleDto> {
        val schuleDtos: MutableList<SchuleDto> = mutableListOf()
        schulen.forEach { schule ->
            val klasseDtos: MutableList<KlasseDto> = mutableListOf()
            schule.klassen.forEach { klasse ->
                klasseDtos.add(KlasseDto(klasse.klassenstufe, klasse.bezeichnung))
            }
            val schuleDto = SchuleDto(schule.schulname, schule.schulId, schule.schulform, klasseDtos)
            schuleDtos.add(schuleDto)
        }
        return schuleDtos
    }
}