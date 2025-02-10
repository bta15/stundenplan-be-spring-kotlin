package de.stundenplan.service

import de.stundenplan.controller.dto.KlasseDto
import de.stundenplan.controller.dto.SchuleDto
import de.stundenplan.controller.dto.StundenplanDto
import de.stundenplan.controller.dto.TagDto
import de.stundenplan.model.Schule
import de.stundenplan.model.Stundenplan
import de.stundenplan.model.Tag
import de.stundenplan.repository.KlasseRepository
import de.stundenplan.repository.SchuleRepository
import de.stundenplan.repository.StundenplanRepository
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class StundenplanService(
    val stundenplanRepository: StundenplanRepository,
    val schuleRepository: SchuleRepository,
    val klasseRepository: KlasseRepository
) {

    fun getBySchule(schulId: String): List<StundenplanDto> {
        //TODO
        val schule = schuleRepository.findBySchulId(schulId)
        val stundenplanList = stundenplanRepository.findAllBySchule(schule)
        val stundenplanDto = ArrayList<StundenplanDto>()
        stundenplanList.forEach { stundenplan ->
            val klasse = stundenplan.klasse
            val tage = emptyList<TagDto>() //todo tage liste füllen
            stundenplanDto.add(
                StundenplanDto(
                    stundenplan.startDate,
                    stundenplan.endDate,
                    schule.id!!,
                    klasse.id!!,
                    tage
                )
            )
        }
        return stundenplanDto
    }

    fun create(stundenplanDto: StundenplanDto): StundenplanDto {
        //todo tage liste füllen
        val schule = schuleRepository.findById(stundenplanDto.idSchule).orElseThrow()
        val klasse = klasseRepository.findById(stundenplanDto.idKlasse).orElseThrow()
        var newStundenplan =
            Stundenplan(null, stundenplanDto.startDate, stundenplanDto.endDate, schule, klasse, listOf())
        newStundenplan = stundenplanRepository.save(newStundenplan)

        return StundenplanDto(
            newStundenplan.startDate,
            newStundenplan.endDate,
            stundenplanDto.idSchule,
            stundenplanDto.idKlasse,
            listOf()
        )
    }
}