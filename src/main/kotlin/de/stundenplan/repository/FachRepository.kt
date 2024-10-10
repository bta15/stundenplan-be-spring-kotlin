package de.stundenplan.repository

import de.stundenplan.model.Fach
import org.springframework.data.repository.CrudRepository
import java.util.*

interface FachRepository : CrudRepository<Fach, Int> {
    fun findByBezeichnung(bezeichnung: String): Optional<Fach>

    fun existsByBezeichnung(bezeichnung: String): Boolean

}
