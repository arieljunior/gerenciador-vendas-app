package br.edu.infnet.gerenciador_vendas_app.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.gerenciador_vendas_app.model.domain.Vestimenta;

@Repository
public interface VestimentaRepository extends CrudRepository<Vestimenta, Integer> {

}