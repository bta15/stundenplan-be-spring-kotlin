package de.stundenplan.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("SCHULE")
data class Schule(
    @Id val id: Int?,
    val schulname: String,
    val schulId: String, //TODO muss unique sein (in DB)
    val schulform: Schulform,
//    val klassen: List<Klasse>
)

