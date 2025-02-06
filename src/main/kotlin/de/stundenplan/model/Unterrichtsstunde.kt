package de.stundenplan.model

import jakarta.persistence.*

@Entity
@Table(name = "UNTERRICHT")
data class Unterrichtsstunde(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int?,

    val anzahlProWoche: Int,

    @ManyToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "FACH_FK", nullable = false) //todo in db
    var fach: Fach,

    var klassenstufe: Int,

    @ManyToOne
    @JoinColumn(name = "TAG_FK") //todo in db
    var tag: Tag
)