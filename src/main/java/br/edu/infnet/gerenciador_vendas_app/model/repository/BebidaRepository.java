package br.edu.infnet.gerenciador_vendas_app.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.gerenciador_vendas_app.model.domain.Bebida;

@Repository
public interface BebidaRepository extends CrudRepository<Bebida, Integer> {

}