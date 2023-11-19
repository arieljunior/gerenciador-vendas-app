package br.edu.infnet.gerenciador_vendas_app;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.gerenciador_vendas_app.model.domain.Vestimenta;
import br.edu.infnet.gerenciador_vendas_app.model.domain.Vendedor;
import br.edu.infnet.gerenciador_vendas_app.model.service.VestimentaService;

@Order(3)
@Component
public class VestimentaLoader implements ApplicationRunner {
	
	@Autowired
	private VestimentaService vestimentaService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		FileReader file = new FileReader("arquivos/vestimenta.txt");		
		BufferedReader leitura = new BufferedReader(file);
		
		String linha = leitura.readLine();

		String[] campos = null;
				
		while(linha != null) {
			
			campos = linha.split(";");
			
			Vestimenta vestimenta = new Vestimenta();

			vestimenta.setCodigo(Integer.valueOf(campos[0]));
			vestimenta.setDescricao(campos[1]);
			vestimenta.setEstoque(Boolean.valueOf(campos[2]));
			vestimenta.setPreco(Float.valueOf(campos[3]));
			vestimenta.setCor(campos[4]);
			vestimenta.setTamanho(campos[5]);
			
			Vendedor vendedor = new Vendedor();
			vendedor.setId(Integer.valueOf(campos[6]));
			
			vestimenta.setVendedor(vendedor);
			
			vestimentaService.incluir(vestimenta);
			
			linha = leitura.readLine();
		}

		for(Vestimenta vestimenta: vestimentaService.obterLista()) {
			System.out.println("[Vestimenta] " + vestimenta);			
		}

		leitura.close();
	}
}