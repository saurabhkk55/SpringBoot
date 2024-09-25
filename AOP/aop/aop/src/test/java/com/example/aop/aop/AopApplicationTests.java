package com.example.aop.aop;

import com.example.aop.aop.services.impl.ShipmentServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class AopApplicationTests {
	@Autowired
	private ShipmentServiceImpl shipmentService;

	@Test
	void contextLoads() {
	}

	@Test
	void testOrderPackage() {
		String response = shipmentService.orderPackage(2L);
		log.info("response: {}", response);
	}

	@Test
	void testTrackPackage() {
		String response = shipmentService.trackPackage(2L);
		log.info("response: {}", response);
	}

}
