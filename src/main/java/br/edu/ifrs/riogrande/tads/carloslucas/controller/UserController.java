package br.edu.ifrs.riogrande.tads.carloslucas.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifrs.riogrande.tads.carloslucas.app.model.User;
import br.edu.ifrs.riogrande.tads.carloslucas.app.services.UserService;
import br.edu.ifrs.riogrande.tads.carloslucas.app.services.dto.UserRequest;
import lombok.RequiredArgsConstructor;

// para "puristas" de rest (restafarian)
// path é para um recurso (subrecurso)
// www.dominio/v1/users/12345678901

@RequiredArgsConstructor
@Validated
@RestController
@RequestMapping("/api/v1") 
public class UserController { 

	private final UserService service;
	
	@PostMapping(path = "/users", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> nova(
			@RequestBody @Valid UserRequest body) {

		service.salvar(body);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	@PutMapping(path = "/users/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	public void atualizar(
		@PathVariable(name = "id") Integer id,
		@RequestBody @Valid UserRequest body) {

			service.update(id, body);

	}

	@GetMapping(path = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<User>> listar() {

		List<User> users = service.listar();

		return ResponseEntity.ok(users);
	}

	@GetMapping(path = "/users/{cpf}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> ler(
		@Pattern(regexp = "^\\d{11}$", message = "CPF inválido: deve ter 11 dígitos")
		@CPF(message = "CPF inválido: número inválido") 
		@PathVariable
		String cpf) {

		return ResponseEntity.ok(service.load(cpf));
	}

	@DeleteMapping(path = "/users/{cpf}")
	@ResponseStatus(code = HttpStatus.OK)
	public void excluir(
		@Pattern(regexp = "^\\d{11}$", message = "CPF inválido: deve ter 11 dígitos")
		@CPF(message = "CPF inválido: número inválido")
		@PathVariable
		String cpf) {

		service.delete(cpf);
	}

	@ExceptionHandler(ConstraintViolationException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	Map<String, List<String>> trataConstraintViolationException(ConstraintViolationException ex) {

		Set<ConstraintViolation<?>> violations = ex.getConstraintViolations();
		List<String> erros = violations.stream()
			.map(v -> v.getMessage())//.toList();
			.collect(Collectors.toList());
 
		return Map.of("erros", erros);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	Map<String, List<String>> trataMethodArgumentNotValidException
		(MethodArgumentNotValidException ex) {

			List<String> erros = ex.getFieldErrors().stream()
				.map(e -> e.getDefaultMessage())//.toList();
				.collect(Collectors.toList());

			return Map.of("erros", erros);
	}
}
