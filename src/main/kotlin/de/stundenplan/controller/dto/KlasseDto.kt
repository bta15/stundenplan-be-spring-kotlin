package de.stundenplan.controller.dto

data class KlasseDto(
    var klassenstufe: Int,
    var bezeichnung: String,
    var unterrichtList: List<UnterrichtDto>
)