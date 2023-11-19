package br.edu.infnet.gerenciador_vendas_app.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.gerenciador_vendas_app.model.domain.Bebida;
import br.edu.infnet.gerenciador_vendas_app.model.repository.BebidaRepository;

@Service
public class BebidaService {

	@Autowired
	private BebidaRepository bebidaRepository;
	
	public void incluir(Bebida bebida) {
		bebidaRepository.save(bebida);
	}
	
	public Collection<Bebida> obterLista(){	
		return (Collection<Bebida>) bebidaRepository.findAll();
	}

	public long obterQtde() {
		return bebidaRepository.count();
	}
}