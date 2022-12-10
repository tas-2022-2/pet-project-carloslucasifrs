package br.edu.ifrs.riogrande.tads.carloslucas.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.Repository;

import br.edu.ifrs.riogrande.tads.carloslucas.app.model.Role;

public interface RoleRepository extends Repository<Role, Integer> {
    
    Role save(Role role);

    Optional<Role> findById(Integer id);

    List<Role> findAll();

    // void delete(Role role);

    void deleteById(Integer id);

    

}
