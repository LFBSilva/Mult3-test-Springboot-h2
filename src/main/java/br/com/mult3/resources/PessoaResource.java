package br.com.mult3.resources;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mult3.entities.Pessoa;
import br.com.mult3.services.PessoaService;

@RestController
@RequestMapping("/pessoa")
public class PessoaResource {

	@Autowired
	private PessoaService service;

	@GetMapping
	public Iterable<Pessoa> get() {
		return service.getPessoa();
	}

	@GetMapping("/{id}")
	public Optional<Pessoa> get(@PathVariable("id") Long id) {
		return service.getPessoaByid(id);
	}

	@GetMapping("/email/{email}")
	public Iterable<Pessoa> getPessoaByEmail(@PathVariable("email") String email) {
		return service.getPessoaByemail(email);
	}

	@PostMapping
	public void post(@RequestBody Pessoa pessoa) {
		service.save(pessoa);
	}
	
	@PutMapping("/{id}")
	public String put(@PathVariable("id") Long id, @RequestBody Pessoa pessoa) {
		Pessoa p = service.update(pessoa, id);
		return "Dados Atualizados";
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable("id") Long id) {
		service.delete(id);
		return "Dados deletados";
}
}