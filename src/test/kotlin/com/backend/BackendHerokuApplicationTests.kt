package com.backend

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.http.HttpStatus
import org.assertj.core.api.Assertions.assertThat

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BackendHerokuApplicationTests {

	@LocalServerPort
	private var port: Int = 0

	@Autowired
	private lateinit var restTemplate: TestRestTemplate

	@Test
	fun contextLoads() {
	}

	@Test
	fun `hello endpoint returns a greeting`() {
		val response = restTemplate.getForEntity(url("/hello"), String::class.java)

		assertThat(response.statusCode).isEqualTo(HttpStatus.OK)
		assertThat(response.body).isEqualTo("Hello World")
	}

	@Test
	fun `personalized hello endpoint includes the requested name`() {
		val response = restTemplate.getForEntity(url("/hello/Ada"), String::class.java)

		assertThat(response.statusCode).isEqualTo(HttpStatus.OK)
		assertThat(response.body).isEqualTo("Hello Ada")
	}

	@Test
	fun `health endpoint reports the application is up`() {
		val response = restTemplate.getForEntity(url("/health"), String::class.java)

		assertThat(response.statusCode).isEqualTo(HttpStatus.OK)
		assertThat(response.body).isEqualTo("""{"status":"UP"}""")
	}

	private fun url(path: String) = "http://localhost:$port/services$path"
}
