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
    var schule: Schule,

    @OneToMany(fetch = FetchType.LAZY, cascade = [CascadeType.ALL], mappedBy = "klasse")
    var unterrichtList: List<Unterricht>
)