package de.stundenplan.model

import jakarta.persistence.*

@Entity
@Table(name = "UNTERRICHT")
data class Unterricht(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int?,

    val anzahlProWoche: Int,

    @ManyToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "FACH_FK", nullable = false)
    var fach: Fach,

    @ManyToOne
    @JoinColumn(name = "KLASSE_FK", nullable = false)
    var klasse: Klasse
)