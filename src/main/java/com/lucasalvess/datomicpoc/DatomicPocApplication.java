package com.lucasalvess.datomicpoc;

import datomic.Peer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DatomicPocApplication {

	public static void main(String[] args) throws InterruptedException {

		SpringApplication.run(DatomicPocApplication.class, args);
	}

}
