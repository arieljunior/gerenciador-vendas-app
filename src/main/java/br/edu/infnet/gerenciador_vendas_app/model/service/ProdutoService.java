package br.edu.infnet.gerenciador_vendas_app.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.gerenciador_vendas_app.model.domain.Produto;
import br.edu.infnet.gerenciador_vendas_app.model.repository.ProdutoRepository;

@Service
public class ProdutoService {
	@Autowired
	private ProdutoRepository produtoRepository;

	public void incluir(Produto produto) {
		produtoRepository.save(produto);
	}
	
	public Collection<Produto> obterLista(){	
		return (Collection<Produto>) produtoRepository.findAll();
	}
	
	public long obterQtde() {
		return produtoRepository.count();
	}
}
