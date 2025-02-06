package de.stundenplan.model

import de.stundenplan.model.enums.Wochentag
import jakarta.persistence.*

@Entity
@Table(name = "TAG")
data class Tag(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int?,

    @Enumerated(EnumType.STRING)
    val wochentag: Wochentag,

    @ManyToOne
    @JoinColumn(name = "STUNDENPLAN_FK") //todo in db
    val stundenplan: Stundenplan,

    @OneToMany(mappedBy = "tag", cascade = [CascadeType.ALL])
    val unterrichtsstunden: List<Unterrichtsstunde>,

    )