package com.randomshop.shop;

import com.randomshop.shop.service.ImageStorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

@SpringBootApplication
public class ShopApplication implements CommandLineRunner {

	@Resource
	ImageStorageService imageStorageService;

	public static void main(String[] args) {
		SpringApplication.run(ShopApplication.class, args);
	}

	@Override
	public void run(String... arg) {
		imageStorageService.init();
	}

}
