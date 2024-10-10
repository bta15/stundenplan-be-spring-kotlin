package de.stundenplan.mapper

import de.stundenplan.controller.dto.FachDto
import de.stundenplan.controller.dto.KlasseDto
import de.stundenplan.controller.dto.SchuleDto
import de.stundenplan.controller.dto.UnterrichtDto
import de.stundenplan.model.Fach
import de.stundenplan.model.Klasse
import de.stundenplan.model.Schule
import de.stundenplan.model.Unterricht
import de.stundenplan.repository.FachRepository

class DtoMapper {
    companion object {

        fun getOrCreateEntity(fachDto: FachDto, fachRepository: FachRepository): Fach {
            val existingFach = fachRepository.findByBezeichnung(fachDto.bezeichnung)
            if (existingFach.isPresent) {
                return existingFach.get()
            } else {
                return fachRepository.save(Fach(null, fachDto.bezeichnung))
            }
        }

        fun mapToEntity(unterricht: UnterrichtDto, klasse: Klasse, fachRepository: FachRepository): Unterricht =
            Unterricht(null, unterricht.anzahlProWoche, getOrCreateEntity(unterricht.fach, fachRepository), klasse)


        fun mapToEntity(klasseDto: KlasseDto, schule: Schule, fachRepository: FachRepository): Klasse {
            val klasse = Klasse(null, klasseDto.klassenstufe, klasseDto.bezeichnung, schule, listOf())
            val unterrichtList =
                klasseDto.unterrichtList.map { unterricht -> mapToEntity(unterricht, klasse, fachRepository) }
            klasse.unterrichtList = unterrichtList
            return klasse
        }

        fun mapToEntity(schuleDto: SchuleDto, fachRepository: FachRepository): Schule {
            val schule = Schule(null, schuleDto.schulname, schuleDto.schulId, schuleDto.schulform, listOf())
            val klassen = schuleDto.klassen.map { klasse -> mapToEntity(klasse, schule, fachRepository) }
            schule.klassen = klassen
            return schule
        }
    }


}