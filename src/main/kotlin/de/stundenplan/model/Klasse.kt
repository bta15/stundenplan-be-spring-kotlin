package de.stundenplan.model

import jakarta.persistence.*

@Entity
@Table(name = "KLASSE")
class Klasse(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int?,

    var klassenstufe: Int,

    var bezeichnung: String, //TODO sollte unique sein?!

    @ManyToOne
    @JoinColumn(name = "SCHULE_FK", nullable = false)
    var schule: Schule,

    @ManyToMany(cascade = [CascadeType.ALL])
    @JoinTable(
        name = "KLASSE_FACH",
        joinColumns = [JoinColumn(name = "FACH_FK", referencedColumnName = "id")],
        inverseJoinColumns = [JoinColumn(name = "KLASSE_FK", referencedColumnName = "id")]
    )
    var fachList: List<Fach>,

//    @OneToOne(cascade = [CascadeType.ALL])//todo brauch ich nicht oder
//    @JoinColumn(name = "stundenplan_id")
//    var stundenplan: Stundenplan,
)