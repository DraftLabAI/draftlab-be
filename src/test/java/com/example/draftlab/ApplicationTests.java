package com.example.draftlab;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest(classes = Application.class)
@TestPropertySource(locations = "classpath:application.properties")
class ApplicationTests {

	@Test
	void contextLoads() {
	}

}
