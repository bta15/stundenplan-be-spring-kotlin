package de.stundenplan.model

import jakarta.persistence.*

@Entity
@Table(name = "FACH")
data class Fach(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int?,

    val bezeichnung: String, //todo unique in DB
)