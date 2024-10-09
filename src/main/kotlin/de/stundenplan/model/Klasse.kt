package de.stundenplan.model

import jakarta.persistence.*

@Entity
@Table(name = "KLASSE")
class Klasse(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int?,

    var klassenstufe: Int,

    var bezeichnung: String,

    @ManyToOne
    @JoinColumn(name = "SCHULE_FK", nullable = false)
    var schule: Schule

//    val unterrichtsfachList: List<Unterrichtsfach>
)