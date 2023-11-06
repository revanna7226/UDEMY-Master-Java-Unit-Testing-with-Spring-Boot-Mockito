package com.revs.unittesting;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(locations = "classpath:test-application.properties")
class SpringbootUnittestingApplicationTests {

	@Test
	void contextLoads() {
	}



}
