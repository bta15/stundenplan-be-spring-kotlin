package de.stundenplan.model

//@Table("KLASSE")
data class Klasse(
    val klassenstufe: Int,
    val bezeichnung: String,
    val unterrichtsfachList: List<Unterrichtsfach>
)