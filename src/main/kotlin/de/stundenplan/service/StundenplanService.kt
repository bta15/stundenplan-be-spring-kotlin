package de.stundenplan.service

import de.stundenplan.controller.dto.SchuleDto
import de.stundenplan.controller.dto.StundenplanDto
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class StundenplanService() {

    fun getBySchule(schuleDto: SchuleDto): List<StundenplanDto> {
        //TODO
        val foo = StundenplanDto(LocalDate.now(), LocalDate.now());
        return listOf(foo)
    }

    fun create(schuleDto: SchuleDto): List<StundenplanDto> {
        //TODO: automatisch erstellen und Anpassung im 2. Schritt ermöglichen
        val foo = StundenplanDto(LocalDate.now(), LocalDate.now());
        return listOf(foo)
    }
}