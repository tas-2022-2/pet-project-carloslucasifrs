package br.edu.ifrs.riogrande.tads.carloslucas.app.Interface;

import br.edu.ifrs.riogrande.tads.carloslucas.app.services.dto.RoleRequest;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import br.edu.ifrs.riogrande.tads.carloslucas.app.model.Role;

public interface IRoleService {

    public void save(RoleRequest request);

    public Optional<Role> findById(Integer id);

    public List<Role> listAll();

    public void delete(Integer id);

    public void update(Integer id, @Valid RoleRequest body);

    public Role show(Integer id);
}