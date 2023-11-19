package br.edu.infnet.gerenciador_vendas_app.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.gerenciador_vendas_app.model.domain.Vestimenta;
import br.edu.infnet.gerenciador_vendas_app.model.repository.VestimentaRepository;

@Service
public class VestimentaService {
	
	@Autowired
	private VestimentaRepository vestimentaRepository;

	public void incluir(Vestimenta vestimenta) {
		vestimentaRepository.save(vestimenta);
	}
	
	public Collection<Vestimenta> obterLista(){	
		return (Collection<Vestimenta>) vestimentaRepository.findAll();
	}

	public long obterQtde() {
		return vestimentaRepository.count();
	}
}