package de.stundenplan.repository

import de.stundenplan.model.Schule
import org.springframework.data.repository.CrudRepository

interface SchuleRepository : CrudRepository<Schule, String> {
    fun existsBySchulId(schulId: String): Boolean
}
