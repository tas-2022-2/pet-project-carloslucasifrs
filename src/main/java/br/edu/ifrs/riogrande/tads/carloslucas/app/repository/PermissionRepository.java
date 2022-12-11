package br.edu.ifrs.riogrande.tads.carloslucas.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.Repository;

import br.edu.ifrs.riogrande.tads.carloslucas.app.model.Permission;

public interface PermissionRepository extends Repository<Permission, Integer> {
    
    Permission save(Permission permission);

    Optional<Permission> findById(Integer id);

    List<Permission> findAll();

    // void delete(Permission permission);

    void deleteById(Integer id);

    

}
