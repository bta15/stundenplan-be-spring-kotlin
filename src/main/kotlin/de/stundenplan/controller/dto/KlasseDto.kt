package de.stundenplan.controller.dto

data class KlasseDto(
    var id: Int? = null,
    var klassenstufe: Int,
    var bezeichnung: String,
    var unterrichtList: List<UnterrichtsstundeDto>
)