package br.edu.infnet.gerenciador_vendas_app;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.gerenciador_vendas_app.model.domain.Bebida;
import br.edu.infnet.gerenciador_vendas_app.model.domain.Vendedor;
import br.edu.infnet.gerenciador_vendas_app.model.service.BebidaService;

@Order(4)
@Component
public class BebidaLoader implements ApplicationRunner {
	
	@Autowired
	private BebidaService bebidaService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		FileReader file = new FileReader("arquivos/bebida.txt");		
		BufferedReader leitura = new BufferedReader(file);
		
		String linha = leitura.readLine();

		String[] campos = null;
				
		while(linha != null) {
			
			campos = linha.split(";");
			
			Bebida bebida = new Bebida();

			bebida.setCodigo(Integer.valueOf(campos[0]));
			bebida.setDescricao(campos[1]);
			bebida.setEstoque(Boolean.valueOf(campos[2]));
			bebida.setPreco(Float.valueOf(campos[3]));
			bebida.setTipo(campos[4]);
			bebida.setMarca(campos[5]);
			
			Vendedor vendedor = new Vendedor();
			vendedor.setId(Integer.valueOf(campos[6]));
			
			bebida.setVendedor(vendedor);
			
			bebidaService.incluir(bebida);
			
			linha = leitura.readLine();
		}

		for(Bebida bebida : bebidaService.obterLista()) {
			System.out.println("[Bebida] " + bebida);
		}
		
		leitura.close();
	}
}