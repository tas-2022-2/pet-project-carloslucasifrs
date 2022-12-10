package br.edu.ifrs.riogrande.tads.carloslucas.app.Interface;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import br.edu.ifrs.riogrande.tads.carloslucas.app.model.Permission;

import br.edu.ifrs.riogrande.tads.carloslucas.app.services.dto.PermissionRequest;

public interface IPermissionService {

    public void save(PermissionRequest request);

    public Optional<Permission> findById(Integer id);

    public List<Permission> listAll();

    public void delete(Integer id);

    public void update(Integer id, @Valid PermissionRequest body);

    public Permission show(Integer id);
}
