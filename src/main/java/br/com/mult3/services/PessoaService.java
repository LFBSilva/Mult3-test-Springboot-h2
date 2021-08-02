package br.com.mult3.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import br.com.mult3.entities.Pessoa;
import br.com.mult3.repositories.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository repository;

	public Iterable<Pessoa> getPessoa() {
		return repository.findAll();
	}

	public Optional<Pessoa> getPessoaByid(Long id) {
		return repository.findById(id);
	}

	public Iterable<Pessoa> getPessoaByemail(String email) {
		return repository.findByEmail(email);
	}

	public Pessoa save(Pessoa pessoa) {
		return repository.save(pessoa);
	}

	public Pessoa update(Pessoa pessoa, Long id) {
		Assert.notNull(id, "Não foi possível atualizar o registro");

		Optional<Pessoa> optional = getPessoaByid(id);
		if (optional.isPresent()) {
			Pessoa db = optional.get();
			db.setNome(pessoa.getNome());
			db.setIdade(pessoa.getIdade());
			db.setEmail(pessoa.getEmail());
			System.out.println("Usuário id" + db.getId());

			repository.save(db);
			return db;
		} else {
			throw new RuntimeException("Não foi possível atualizar o registro");
		}

	}

	public void delete(Long id) {
		Optional<Pessoa> pessoa = getPessoaByid(id);
		if(pessoa.isPresent()) {
			repository.deleteById(id);
		}
	}
}
