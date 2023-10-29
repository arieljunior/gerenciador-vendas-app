package br.edu.infnet.gerenciador_vendas_app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.gerenciador_vendas_app.model.domain.Vendedor;
import br.edu.infnet.gerenciador_vendas_app.model.service.LerArquivo;
import br.edu.infnet.gerenciador_vendas_app.model.service.VendedorService;

@Order(2)
@Component
public class VendedorLoader implements ApplicationRunner{

	@Autowired
	private VendedorService vendedorService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		List<String[]> linhas = LerArquivo.executar("arquivos/vendedores.txt");
		
		for (String[] linha : linhas) {
			Vendedor vendedor = new Vendedor();
			
			vendedor.setNome(linha[0]);
			vendedor.setCpf(linha[1]);
			vendedor.setEmail(linha[2]);
			
			vendedorService.incluir(vendedor);
		}
		for(Vendedor vendedor: vendedorService.obterLista()) {
			System.out.println("[Vendedor] " + vendedor);			
		}
		
	}
	
}
