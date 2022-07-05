package com.odontologica.proyectfinal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class ProyectfinalApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectfinalApplication.class, args);
	}

	// Para correr el front en Visual y el back acá
//	@Configuration
//	@EnableWebMvc
//	public class WebConfig implements WebMvcConfigurer {
//
//		@Override
//		public void addCorsMappings(CorsRegistry registry) {
//
//			registry.addMapping("/**")
//					.allowedOriginPatterns("*")
//					.allowCredentials(true)
//					.allowedMethods("GET", "POST", "PUT", "DELETE")
//					.maxAge(3600);
//		}
//	}
}
