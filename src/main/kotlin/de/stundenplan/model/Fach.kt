package de.stundenplan.model

import de.stundenplan.model.enums.FachBezeichnung
import jakarta.persistence.*

@Entity
@Table(name = "FACH")
data class Fach(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int?,

    @Enumerated(EnumType.STRING)
    val name: FachBezeichnung,

    @ManyToMany(cascade = [CascadeType.ALL]) //todo in db
    @JoinTable(
        name = "FACH_LEHRER",
        joinColumns = [JoinColumn(name = "LEHRER_FK", referencedColumnName = "id")],
        inverseJoinColumns = [JoinColumn(name = "FACH_FK", referencedColumnName = "id")]
    )
    val lehrerList: List<Lehrer>,

//    @OneToMany(mappedBy = "fach")//todo brauch ich nicht, oder
//    val stunden: List<Unterrichtsstunde>
)