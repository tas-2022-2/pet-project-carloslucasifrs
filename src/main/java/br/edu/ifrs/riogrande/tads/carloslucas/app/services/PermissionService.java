package br.edu.ifrs.riogrande.tads.carloslucas.app.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import br.edu.ifrs.riogrande.tads.carloslucas.app.Interface.IPermissionService;
import br.edu.ifrs.riogrande.tads.carloslucas.app.exceptions.NotFoundException;
import br.edu.ifrs.riogrande.tads.carloslucas.app.model.Permission;
import br.edu.ifrs.riogrande.tads.carloslucas.app.model.Role;
import br.edu.ifrs.riogrande.tads.carloslucas.app.repository.PermissionRepository;
import br.edu.ifrs.riogrande.tads.carloslucas.app.repository.RoleRepository;
import br.edu.ifrs.riogrande.tads.carloslucas.app.services.dto.PermissionRequest;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PermissionService implements IPermissionService {

    private final PermissionRepository permissionRepository;
    private final RoleRepository roleRepository;

    public void save(PermissionRequest request) {
        // Pessoa doador = pessoaRepository.findByCpf(cpf).orElseThrow(() -> new
        // NotFoundException("Pessoa não encontrada"));

        Role role = roleRepository.findById(request.getRoles_id())
                .orElseThrow(() -> new NotFoundException("Role não encontrada"));

        Permission permission = new Permission();
        permission.setPermission(request.getPermission());
        permission.setRole(role);
        permissionRepository.save(permission);
    }

    public Optional<Permission> findById(Integer id) {
        return permissionRepository.findById(id);
    }

    public List<Permission> listAll() {
        return permissionRepository.findAll();
    }

    public void delete(Integer id) {
        permissionRepository.deleteById(id);
    }

    public void update(Integer id, @Valid PermissionRequest body) {

        Permission permission = permissionRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Permission não encontrada"));

        permission.setPermission(body.getPermission());

        permissionRepository.save(permission);
    }

    public Permission show(Integer id) {
        return this.findById(id)
                .orElseThrow(() -> new NotFoundException("Permission não Encontrada"));

    }
}
