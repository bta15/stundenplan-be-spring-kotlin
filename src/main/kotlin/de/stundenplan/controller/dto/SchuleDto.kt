package de.stundenplan.controller.dto

import de.stundenplan.model.enums.Schulform

data class SchuleDto(
    var schulname: String,
    var schulId: String, //TODO muss unique sein (in DB)
    var schulform: Schulform,
//    var klassen: List<KlasseDto>
)

