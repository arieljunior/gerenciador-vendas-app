package br.edu.infnet.gerenciador_vendas_app;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.gerenciador_vendas_app.model.domain.Vestimenta;
import br.edu.infnet.gerenciador_vendas_app.model.domain.Bebida;
import br.edu.infnet.gerenciador_vendas_app.model.domain.Produto;
import br.edu.infnet.gerenciador_vendas_app.model.domain.Vendedor;
import br.edu.infnet.gerenciador_vendas_app.model.service.ProdutoService;
import br.edu.infnet.gerenciador_vendas_app.model.service.VendedorService;

@Order(2)
@Component
public class ProdutoLoader implements ApplicationRunner {
	
	@Autowired
	private ProdutoService produtoService;
	
	@Autowired
	private VendedorService vendedorService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		FileReader file = new FileReader("arquivos/produtos.txt");		
		BufferedReader leitura = new BufferedReader(file);
		
		String linha = leitura.readLine();

		String[] campos = null;

		Vendedor vendedor = new Vendedor();
		
		while(linha != null) {
			
			campos = linha.split(";");

			switch (campos[6]) {
			case "V":
				Vestimenta vestimenta = new Vestimenta();
				vestimenta.setCodigo(Integer.valueOf(campos[0]));
				vestimenta.setDescricao(campos[1]);
				vestimenta.setEstoque(Boolean.valueOf(campos[2]));
				vestimenta.setPreco(Float.valueOf(campos[3]));
				vestimenta.setCor(campos[4]);
				vestimenta.setTamanho(campos[5]);
				
				vendedor.setId(Integer.valueOf(campos[7]));
				
				vestimenta.setVendedor(vendedor);

				produtoService.incluir(vestimenta);
				
				break;

			case "B":
				Bebida bebida = new Bebida();
				bebida.setCodigo(Integer.valueOf(campos[0]));
				bebida.setDescricao(campos[1]);
				bebida.setEstoque(Boolean.valueOf(campos[2]));
				bebida.setPreco(Float.valueOf(campos[3]));
				bebida.setTipo(campos[4]);
				bebida.setMarca(campos[5]);

				vendedor.setId(Integer.valueOf(campos[7]));
				
				bebida.setVendedor(vendedor);
				
				produtoService.incluir(bebida);
				
				break;

			default:
				break;
			}
									
			linha = leitura.readLine();
		}

		for(Vendedor v : vendedorService.obterLista()) {
			for(Produto produto : produtoService.obterLista(v) ) {
				System.out.println("[Produto] " + produto);				
			}			
		}

		leitura.close();
	}
}