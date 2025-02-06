package de.stundenplan.model

import de.stundenplan.model.enums.Schulform
import jakarta.persistence.*

@Entity
@Table(name = "SCHULE")
class Schule(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int?,

    var schulname: String,

    var schulId: String, //TODO muss unique sein (in DB)

    @Enumerated(EnumType.STRING)
    var schulform: Schulform,

//    @OneToMany(fetch = FetchType.LAZY, cascade = [CascadeType.ALL], mappedBy = "schule") //todo brauch ich nicht oder
//    var klasseList: List<Klasse>,

//    @OneToMany(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])//todo prüfen
//    var stundenplanList: List<Stundenplan>
)

