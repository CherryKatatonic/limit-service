package com.katgrennan.currencyexchange.limitservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class LimitServiceApplicationTests {

	// Assert that context loads
	@Test
	void contextLoads() {
	}

	// Assert that context loads controllers
	@Autowired
	private LimitConfigurationController limitConfigurationController;

	@Test
	public void contexLoadsControllers() throws Exception {
		assertThat(limitConfigurationController).isNotNull();
	}

	// Assert that LimitConfigurationContrller returns hard-coded limits as JSON
	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void greetingShouldReturnDefaultMessage() throws Exception {
		assertThat(this.restTemplate
				.getForObject("http://localhost:" + port + "/limits", String.class))
				.contains("{\"maximum\":1000,\"minimum\":1}");
	}

}
