package com.example.bitcoindemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
public class BitcoindemoApplication {

	private static final Logger log = LoggerFactory.getLogger(BitcoindemoApplication.class);

	public static void main(String[] args) {

		SpringApplication.run(BitcoindemoApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder){
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception{
		return args ->{
			Bitcoin bitcoin = restTemplate.getForObject("https://api.cryptonator.com/api/ticker/btc-usd", Bitcoin.class);
			log.info(bitcoin.toString());
		};
	}
}
