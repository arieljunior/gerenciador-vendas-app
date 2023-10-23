package br.edu.infnet.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.infnet.model.domain.Vestimenta;


@Service
public class VestimentaService {
	private Map<Integer, Vestimenta> mapaVestimenta = new HashMap<Integer, Vestimenta>();

	public void incluir(Vestimenta vestimenta) {
		mapaVestimenta.put(vestimenta.getCodigo(), vestimenta);
	}
	
	public Collection<Vestimenta> obterLista(){	
		return mapaVestimenta.values();
	}
	
}
