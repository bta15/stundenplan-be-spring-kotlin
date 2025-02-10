package de.stundenplan.controller.dto

data class UnterrichtsstundeDto(
    val anzahlProWoche: Int,
    val fach: FachDto, //TODO
    var klassenstufe: Int,
)

