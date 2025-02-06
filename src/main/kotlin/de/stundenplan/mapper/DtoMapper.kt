package de.stundenplan.mapper

import de.stundenplan.controller.dto.FachDto
import de.stundenplan.controller.dto.KlasseDto
import de.stundenplan.controller.dto.SchuleDto
import de.stundenplan.controller.dto.UnterrichtDto
import de.stundenplan.model.*
import de.stundenplan.model.enums.FachBezeichnung
import de.stundenplan.model.enums.Wochentag
import de.stundenplan.repository.FachRepository

class DtoMapper {
    companion object {

        fun getOrCreateEntity(fachDto: FachDto, fachRepository: FachRepository): Fach {
            val existingFach = fachRepository.findByName(fachDto.bezeichnung)
            if (existingFach.isPresent) {
                return existingFach.get()
            } else {
                return fachRepository.save(Fach(null, fachDto.bezeichnung, listOf()))
            }
        }

//        fun mapToEntity(unterricht: UnterrichtDto, klasse: Klasse, fachRepository: FachRepository): Unterrichtsstunde {
//            val tag = Tag(null, Wochentag.MONTAG, null, listOf())
//            return Unterrichtsstunde(null, unterricht.anzahlProWoche, getOrCreateEntity(unterricht.fach, fachRepository), klasse.klassenstufe, tag)
//        }



        fun mapToEntity(klasseDto: KlasseDto, schule: Schule, fachRepository: FachRepository): Klasse {
            val klasse = Klasse(null, klasseDto.klassenstufe, klasseDto.bezeichnung, schule, listOf())
//            val unterrichtList =
//                klasseDto.unterrichtList.map { unterricht -> mapToEntity(unterricht, klasse, fachRepository) }
//            klasse.unterrichtList = unterrichtList
            return klasse
        }

        fun mapToEntity(schuleDto: SchuleDto, fachRepository: FachRepository): Schule {
            val schule = Schule(null, schuleDto.schulname, schuleDto.schulId, schuleDto.schulform)
//            schuleDto.klassen
//            val klassen = schuleDto.klassen.map { klasse -> mapToEntity(klasse, schule, fachRepository) }
//            schule.klassen = klassen
            return schule
        }
    }


}