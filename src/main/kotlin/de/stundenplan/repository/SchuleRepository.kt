package de.stundenplan.repository

import de.stundenplan.model.Schule
import de.stundenplan.model.Schulform
import org.springframework.data.repository.CrudRepository

interface SchuleRepository : CrudRepository<Schule, Int> {
    fun existsBySchulId(schulId: String): Boolean

    fun findBySchulId(schulId: String): List<Schule>

    fun findBySchulform(schulform: Schulform): List<Schule>
}
