import de.stundenplan.controller.dto.FachDto
import de.stundenplan.model.Fach
import de.stundenplan.repository.FachRepository
import de.stundenplan.service.FachService
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.util.*


class FachServiceTest {
    val fachRepository: FachRepository = mockk()
    val bankAccountService = FachService(fachRepository)

    @Test
    fun createFachOk() {
        val fach = Fach(null, "Deutsch")

        every { fachRepository.findByBezeichnung("Deutsch") } returns Optional.empty()
        every { fachRepository.save(fach) } returns fach

        bankAccountService.create(FachDto("Deutsch"))

        verify(exactly = 1) { fachRepository.findByBezeichnung("Deutsch") }
        verify(exactly = 1) { fachRepository.save(fach) }
    }

    @Test
    fun createFachError() {
        val fach = Fach(null, "Deutsch")

        every { fachRepository.findByBezeichnung("Deutsch") } returns Optional.of(fach)

        try {
            bankAccountService.create(FachDto("Deutsch"))
        } catch (e: IllegalArgumentException) {
            assertEquals("Fach existiert bereits und konnte nicht gespeichert werden", e.message)
        }

        verify(exactly = 1) { fachRepository.findByBezeichnung("Deutsch") }
    }
}