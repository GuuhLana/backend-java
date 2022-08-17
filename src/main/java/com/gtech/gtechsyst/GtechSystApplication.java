package com.gtech.gtechsyst;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.gtech.gtechsyst.controller.ProdutoController;

@SpringBootApplication
public class GtechSystApplication {

	public static void main(String[] args) {
		SpringApplication.run(GtechSystApplication.class, args);
	}

}
