import de.stundenplan.model.*
import de.stundenplan.repository.FachRepository
import de.stundenplan.repository.SchuleRepository
import de.stundenplan.service.SchuleService
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse


class SchuleServiceTest {
    val schuleRepository: SchuleRepository = mockk()
    val fachRepository: FachRepository = mockk()
    val schuleService = SchuleService(schuleRepository, fachRepository)

    @Test
    fun findSchulenOk() {
        val schule = Schule(1, "Schule1", "schule-id-1", Schulform.GRUNDSCHULE, emptyList())
        val klasse = Klasse(1, 1, "1b", schule, emptyList())
        val fach = Fach(1, "Deutsch")
        val unterricht = Unterricht(1, 3, fach, klasse)
        klasse.unterrichtList = listOf(unterricht)
        schule.klassen = listOf(klasse)

        every { schuleRepository.findAll() } returns listOf(schule)

        val schulenResult = schuleService.findSchulen()

        verify(exactly = 1) { schuleRepository.findAll() }

        assertFalse { schulenResult.isEmpty() }
        assertEquals("Schule1", schulenResult.get(0).schulname)
        assertEquals("schule-id-1", schulenResult.get(0).schulId)

        assertFalse { schulenResult.get(0).klassen.isEmpty() }
        assertEquals("1b", schulenResult.get(0).klassen.get(0).bezeichnung)
        assertEquals(1, schulenResult.get(0).klassen.get(0).klassenstufe)

        assertFalse { schulenResult.get(0).klassen.get(0).unterrichtList.isEmpty() }
        assertEquals(3, schulenResult.get(0).klassen.get(0).unterrichtList.get(0).anzahlProWoche)
        assertEquals("Deutsch", schulenResult.get(0).klassen.get(0).unterrichtList.get(0).fach.bezeichnung)
    }
}