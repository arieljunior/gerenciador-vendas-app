package br.edu.infnet.gerenciador_vendas_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class GerenciadorVendasAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(GerenciadorVendasAppApplication.class, args);
	}

}
