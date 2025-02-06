package de.stundenplan.model

import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name = "STUNDENPLAN")
data class Stundenplan(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int?,

    @Column(name = "START_DATE")
    val startDate: LocalDate,

    @Column(name = "END_DATE")
    val endDate: LocalDate,

    @ManyToOne
    @JoinColumn(name = "SCHULE_FK")//todo in db
    val schule: Schule,

    @OneToOne //todo in db
    @JoinColumn(name = "KLASSE_FK")
    val klasse: Klasse,

    @OneToMany(mappedBy = "stundenplan") //todo in db
    val tage: List<Tag>,

    )