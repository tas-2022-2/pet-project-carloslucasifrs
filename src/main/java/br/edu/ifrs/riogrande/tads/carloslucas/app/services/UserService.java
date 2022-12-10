package br.edu.ifrs.riogrande.tads.carloslucas.app.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifrs.riogrande.tads.carloslucas.app.exceptions.NotFoundException;
import br.edu.ifrs.riogrande.tads.carloslucas.app.model.User;
import br.edu.ifrs.riogrande.tads.carloslucas.app.repository.UserRepository;
import br.edu.ifrs.riogrande.tads.carloslucas.app.services.dto.UserRequest;

@Service
public class UserService { // Use Case (independente da comunição)
	// Feign, RestTemplate
	// DAO: Data Access Object, DAL: Data Access Layer
	// Inversão da Dependência (Clean Code)
	private final UserRepository repository; // inspirado na ideia do Eric Evans (DDD)

	@Autowired
	public UserService(UserRepository repository) {
		this.repository = repository;
	}

	public void salvar(UserRequest request) {

		// mapeamento
		User user = new User();
		user.setCpf(request.getCpf());
		user.setName(request.getName());

		repository.save(user);
	}

	public List<User> listar() {
		return repository.findAll();
	}

	public Optional<User> find(String cpf) {
		return repository.findByCpf(cpf);
	}

	public User load(String cpf) {
		return this.find(cpf)
			.orElseThrow(() -> new NotFoundException("Pessoa não encontrada"));
	}

	public void delete(String cpf) {

		User user = repository.findByCpf(cpf) // param hint
			.orElseThrow(() -> new NotFoundException("Pessoa não encontrada"));

		repository.delete(user);

		// if (user.isPresent()) {
		// } else {
		// 	throw NotFoundException("Pessoa com o CPF %s não foi encontrada");
		// }
	}

	public void update(Integer id, @Valid UserRequest body) {

		User user = repository.findById(id)
				.orElseThrow(() -> new NotFoundException("Pessoa não encontrada"));

		// mapeamento
		user.setName(body.getName());
		// user.setCpf(body.getCpf());

		repository.save(user);
	}

}
