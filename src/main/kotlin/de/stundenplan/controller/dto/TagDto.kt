package de.stundenplan.controller.dto

import de.stundenplan.model.enums.Wochentag

data class TagDto(
    val wochentag: Wochentag,
    val unterrichtsstunden: List<UnterrichtsstundeDto>
)

