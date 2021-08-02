package br.com.mult3.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.mult3.entities.Pessoa;

public interface PessoaRepository extends CrudRepository<Pessoa, Long> {

	Iterable<Pessoa> findByEmail(String email);
}
