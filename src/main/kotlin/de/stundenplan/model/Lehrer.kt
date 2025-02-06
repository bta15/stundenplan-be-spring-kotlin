package de.stundenplan.model

import de.stundenplan.model.enums.FachBezeichnung
import jakarta.persistence.*

@Entity
@Table(name = "FACH")
data class Lehrer(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int?,


    @ManyToMany(mappedBy = "lehrerList", cascade = [(CascadeType.ALL)])
    val fachList: List<Fach>,

    @Column(name = "ANZ_STD_PRO_WOCHE")
    val anzahlStundenProWoche: Int,

//    @OneToMany(cascade = [CascadeType.ALL], orphanRemoval = true)//todo brauche ich nicht oder
//    val faecher: List<Fach>,
)