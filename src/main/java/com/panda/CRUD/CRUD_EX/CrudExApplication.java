package com.panda.CRUD.CRUD_EX;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.panda.CRUD.CRUD_EX"})
public class CrudExApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudExApplication.class, args);
	}

}
