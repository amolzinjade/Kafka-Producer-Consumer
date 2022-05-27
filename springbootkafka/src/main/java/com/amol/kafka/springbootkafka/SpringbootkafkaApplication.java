package com.amol.kafka.springbootkafka;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.Assert;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

@SpringBootApplication
public class SpringbootkafkaApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringbootkafkaApplication.class, args);
	}

}

