import de.stundenplan.model.Schule
import de.stundenplan.model.Schulform
import de.stundenplan.repository.FachRepository
import de.stundenplan.repository.SchuleRepository
import de.stundenplan.service.SchuleService
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test
import kotlin.test.assertFalse


class SchuleServiceTest {
    val schuleRepository: SchuleRepository = mockk()
    val fachRepository: FachRepository = mockk()
    val schuleService = SchuleService(schuleRepository, fachRepository)

    @Test
    fun findSchulenOk() {
        val schule = Schule(1, "Scbule1", "schule-id-1", Schulform.GRUNDSCHULE, emptyList())

        every { schuleRepository.findAll() } returns listOf(schule)

        val schulenResult = schuleService.findSchulen()

        verify(exactly = 1) { schuleRepository.findAll() }
        assertFalse { schulenResult.isEmpty() }
    }
}