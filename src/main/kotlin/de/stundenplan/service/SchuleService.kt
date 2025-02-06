package de.stundenplan.service

import de.stundenplan.controller.dto.SchuleDto
import de.stundenplan.mapper.DtoMapper
import de.stundenplan.mapper.EntityMapper
import de.stundenplan.model.enums.Schulform
import de.stundenplan.repository.FachRepository
import de.stundenplan.repository.SchuleRepository
import org.springframework.stereotype.Service

@Service
class SchuleService(val schuleRepository: SchuleRepository, val fachRepository: FachRepository) {
    fun findSchulen(): List<SchuleDto> {
        return EntityMapper.mapToDto(schuleRepository.findAll().toList())
    }

    fun findSchulenBySchulform(schulform: Schulform): List<SchuleDto> {
        return EntityMapper.mapToDto(schuleRepository.findBySchulform(schulform).toList())
    }

    fun findSchuleBySchulId(schulId: String): SchuleDto {
        return EntityMapper.mapToDto(schuleRepository.findBySchulId(schulId))
    }

    fun create(schuleDto: SchuleDto) {
        val schule = DtoMapper.mapToEntity(schuleDto, fachRepository)
//        val klassen = schuleDto.klassen.map { klasseDto ->  DtoMapper.mapToEntity(klasseDto, schule, fachRepository)}
        schuleRepository.save(schule)
    }

    fun exists(schulId: String): Boolean {
        return schuleRepository.existsBySchulId(schulId)
    }
}