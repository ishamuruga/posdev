package com.app.pos.posapi;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class PosapiApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;
	@LocalServerPort
	private int randomServerPort;

	@Test
	void contextLoads() {
		System.out.println("=================================================================");
		
	}

	@Test
	void should_return_employee_list() {
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		Student[] employees = restTemplate.getForObject("http://localhost:" + randomServerPort + "/api/students",Student[].class);

		assertEquals(5, employees.length);  
	}

}
