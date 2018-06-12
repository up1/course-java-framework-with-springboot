package com.example.demo;

import org.springframework.boot.ImageBanner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.core.io.ClassPathResource;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
//		SpringApplication.run(DemoApplication.class, args);

        ImageBanner banner = new ImageBanner(
                new ClassPathResource("somkiat.png")
        );

        new SpringApplicationBuilder()
                .sources(DemoApplication.class)
                .banner(banner)
//                .bannerMode(Banner.Mode.OFF)
                .run(args);
	}

}


