package de.stundenplan.repository

import de.stundenplan.model.Klasse
import de.stundenplan.model.Schule
import de.stundenplan.model.enums.Schulform
import org.springframework.data.repository.CrudRepository

interface KlasseRepository : CrudRepository<Klasse, Int> {

    fun findBySchule(schule: Schule): List<Klasse>


}
