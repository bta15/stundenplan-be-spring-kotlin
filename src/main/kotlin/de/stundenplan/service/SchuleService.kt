package de.stundenplan.service

import de.stundenplan.model.Schule
import de.stundenplan.repository.SchuleRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class SchuleService(val schuleRepository: SchuleRepository) {
    fun findMessages(): List<Schule> = schuleRepository.findAll().toList()

    fun findMessageById(id: String): List<Schule> = schuleRepository.findById(id).toList()

    fun save(message: Schule) {
        schuleRepository.save(message)
    }

    fun exists(schulId: String): Boolean {
        return schuleRepository.existsBySchulId(schulId)
    }

    fun <T : Any> Optional<out T>.toList(): List<T> =
        if (isPresent) listOf(get()) else emptyList()
}