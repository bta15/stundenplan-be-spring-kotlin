package de.stundenplan.repository

import de.stundenplan.model.Schule
import de.stundenplan.model.Stundenplan
import org.springframework.data.repository.CrudRepository

interface StundenplanRepository : CrudRepository<Stundenplan, Int> {

    fun findAllBySchule(schule: Schule): List<Stundenplan>


}
