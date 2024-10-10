package de.stundenplan.mapper

import de.stundenplan.controller.dto.FachDto
import de.stundenplan.controller.dto.KlasseDto
import de.stundenplan.controller.dto.SchuleDto
import de.stundenplan.controller.dto.UnterrichtDto
import de.stundenplan.model.Fach
import de.stundenplan.model.Klasse
import de.stundenplan.model.Schule
import de.stundenplan.model.Unterricht

class EntityMapper {
    companion object {
        fun mapToDto(fach: Fach): FachDto = FachDto(fach.bezeichnung)

        fun mapToDto(unterricht: Unterricht): UnterrichtDto =
            UnterrichtDto(unterricht.anzahlProWoche, mapToDto(unterricht.fach))

        fun mapToDto(klasse: Klasse): KlasseDto {
            val unterrichtDtos = klasse.unterrichtList.map { unterricht -> mapToDto(unterricht) }
            return KlasseDto(klasse.klassenstufe, klasse.bezeichnung, unterrichtDtos)
        }

        fun mapToDto(schule: Schule): SchuleDto {
            val klasseDtos = schule.klassen.map { klasse -> mapToDto(klasse) }
            return SchuleDto(schule.schulname, schule.schulId, schule.schulform, klasseDtos)
        }

        fun mapToDto(schulen: List<Schule>): List<SchuleDto> = schulen.map { schule -> mapToDto(schule) }
    }
}