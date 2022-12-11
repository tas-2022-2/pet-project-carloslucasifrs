package br.edu.ifrs.riogrande.tads.carloslucas.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.Repository;

import br.edu.ifrs.riogrande.tads.carloslucas.app.model.User;
// Spring Data JPA
public interface UserRepository extends Repository<User, Integer> {

// CRUD, Create, Read, Update, Delete

	User save(User p);

	List<User> findAll();

	Optional<User> findByCpf(String cpf);

	void delete(User user);

	Optional<User> findById(Integer id);

	boolean existsByCpf(String cpf);

	// É possível usar query nativa
	// @Query(value = "select a, b, c ....", nativeQuery = true)
	// User findUserAlgumaCoisa();

}

// CoC // Convention Over Configuration

/*
@Component
class UserRepositoryH2Concreta implements UserRepository {

	@Autowired
	EntityManager em;

	@Override
	public User save(User u) {
		em.persist(p);
		return p;
	}

	@Override
	public List<User> findAll() {
		return em.createQuery("FROM User p").getResultList();
	}

	@Override
	public Optional<User> findByCpf(String cpf) {
		return Optional.ofNullable(em.createQuery("FROM User p WHERE p.cpf = :cpf", User.class)
		.setParameter("cpf", cpf)
		.getSingleResult());
	}

}
*/