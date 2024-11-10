package de.stundenplan.controller

import com.ninjasquad.springmockk.MockkBean
import de.stundenplan.controller.dto.FachDto
import de.stundenplan.controller.dto.SchuleDto
import de.stundenplan.model.Schulform
import de.stundenplan.service.SchuleService
import io.mockk.every
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

@WebMvcTest(controllers = [SchuleController::class])
class SchuleControllerTest(@Autowired val mockMvc: MockMvc) {

    @MockkBean
    lateinit var schuleService: SchuleService

    @Test
    fun getAllSchulen() {
        val schule = SchuleDto("Schule-123", "schul-id-123", Schulform.GRUNDSCHULE, listOf())
        every { schuleService.findSchulen() } returns listOf(schule);

        mockMvc.perform(get("/schule"))
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$[*].schulname").value("Schule-123"))
            .andExpect(jsonPath("$[*].schulId").value("schul-id-123"))
            .andExpect(jsonPath("$[*].schulform").value("GRUNDSCHULE"))
        //TODO ausführlich testen
    }

    //TODO auch die anderen Methoden testen
}