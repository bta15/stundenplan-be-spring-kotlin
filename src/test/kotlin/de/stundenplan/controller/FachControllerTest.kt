package de.stundenplan.controller

import com.ninjasquad.springmockk.MockkBean
import de.stundenplan.controller.dto.FachDto
import de.stundenplan.service.FachService
import io.mockk.every
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

@WebMvcTest(controllers = [FachController::class])
class FachControllerTest(@Autowired val mockMvc: MockMvc) {

    @MockkBean
    lateinit var fachService: FachService

    @Test
    fun givenExistingBankAccount_whenGetRequest_thenReturnsBankAccountJsonWithStatus200() {
        val fach = FachDto("Englisch")
        every { fachService.findFachList() } returns listOf(fach);

        mockMvc.perform(get("/fach"))
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$[*].bezeichnung").value("Englisch"));
    }

}