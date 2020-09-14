package com.katgrennan.currencyexchange.limitservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@EnableConfigurationProperties
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
		assertNotNull(limitConfigurationController);
	}

	// Assert that LimitConfigurationContrller returns hard-coded limits as JSON
	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Value("${limit-service.minimum}")
	private String limitServiceMinimum;

	@Value("${limit-service.maximum}")
	private String limitServiceMaximum;

	@Test
	public void limitsPathReturnsLimits() throws Exception {
		assert(this.restTemplate
				.getForObject("http://localhost:" + port + "/limits", String.class))
				.contains("{\"maximum\":" + limitServiceMaximum + ",\"minimum\":" + limitServiceMinimum + "}");
	}

}
