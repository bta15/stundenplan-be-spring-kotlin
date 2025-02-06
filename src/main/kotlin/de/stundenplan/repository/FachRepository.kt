package de.stundenplan.repository

import de.stundenplan.model.Fach
import de.stundenplan.model.enums.FachBezeichnung
import org.springframework.data.repository.CrudRepository
import java.util.*

interface FachRepository : CrudRepository<Fach, Int> {
    fun findByName(bezeichnung: FachBezeichnung): Optional<Fach>

    fun existsByName(bezeichnung: FachBezeichnung): Boolean

}
