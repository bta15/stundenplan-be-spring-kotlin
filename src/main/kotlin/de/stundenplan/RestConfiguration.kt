package de.stundenplan

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
//@ComponentScan
class RestConfiguration {

    @Value("\${stundenplan.cors.originPatterns}")
    private val corsOriginPatterns: String = ""

    @Bean
    fun corsConfigurer(): WebMvcConfigurer {
        return object: WebMvcConfigurer {
            override fun addCorsMappings(corsRegistry: CorsRegistry) {
                val allowedOriginis = corsOriginPatterns.split(",").toTypedArray()
                corsRegistry.addMapping("/**")
                    .allowedMethods("*")
                    .allowedOriginPatterns(*allowedOriginis)
                    .allowCredentials(true)
            }
        }

    }
}