package br.edu.infnet.gerenciador_vendas_app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.gerenciador_vendas_app.model.domain.Bebida;
import br.edu.infnet.gerenciador_vendas_app.model.domain.Produto;
import br.edu.infnet.gerenciador_vendas_app.model.domain.Vestimenta;
import br.edu.infnet.gerenciador_vendas_app.model.service.LerArquivo;
import br.edu.infnet.gerenciador_vendas_app.model.service.ProdutoService;

@Order(1)
@Component
public class ProdutoLoader implements ApplicationRunner{

	@Autowired
	private ProdutoService produtoService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("EXECUTOU PRODUTO LOADER JAVA");
		List<String[]> linhas = LerArquivo.run("arquivos/produtos.txt");
		
		for (String[] linha : linhas) {
			
			switch (linha[6]) {
			case "V":
				Vestimenta vestimenta = new Vestimenta();
				vestimenta.setCodigo(Integer.valueOf(linha[0]));
				vestimenta.setDescricao(linha[1]);
				vestimenta.setEstoque(Boolean.valueOf(linha[2]));
				vestimenta.setPreco(Float.valueOf(linha[3]));
				vestimenta.setMarca(linha[4]);
				vestimenta.setTamanho(linha[5]);
				
				produtoService.incluir(vestimenta);
				
				break;

			case "E":
				Bebida bebida = new Bebida();
				bebida.setCodigo(Integer.valueOf(linha[0]));
				bebida.setDescricao(linha[1]);
				bebida.setEstoque(Boolean.valueOf(linha[2]));
				bebida.setPreco(Float.valueOf(linha[3]));
				bebida.setTipoBebida(linha[4]);
				bebida.setSabor(linha[5]);
				
				produtoService.incluir(bebida);
				
				break;

			default:
				break;
			}
		}
		
		for(Produto produto: produtoService.obterLista()) {
			System.out.println("[Produto] " + produto);			
		}
		
	}
	
}
