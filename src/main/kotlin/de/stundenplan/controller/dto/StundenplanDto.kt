package de.stundenplan.controller.dto

import java.time.LocalDate

data class StundenplanDto(
    val startDate: LocalDate,
    val endDate: LocalDate,
    val idSchule: Int,
    val idKlasse: Int,
    val tage: List<TagDto>
)

