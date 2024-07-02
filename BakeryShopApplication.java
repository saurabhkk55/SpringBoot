package com.saurabhorg.bakery.shop;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BakeryShopApplication implements CommandLineRunner {
	private CakeBakery cakeBakery;

	public BakeryShopApplication(CakeBakery cakeBakery) {
		this.cakeBakery = cakeBakery;
	}

	public static void main(String[] args) {
		SpringApplication.run(BakeryShopApplication.class, args);
		System.out.println("Hi Bakery Shop");
	}

	@Override
	public void run(String... args) throws Exception {
		cakeBakery.bakeCake(); // same as this.car.start();
	}
}
