package br.edu.ifrs.riogrande.tads.carloslucas.app.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.edu.ifrs.riogrande.tads.carloslucas.app.Interface.IPermissionService;
import br.edu.ifrs.riogrande.tads.carloslucas.app.Interface.IRoleService;
import br.edu.ifrs.riogrande.tads.carloslucas.app.model.Permission;
import br.edu.ifrs.riogrande.tads.carloslucas.app.model.Role;
import br.edu.ifrs.riogrande.tads.carloslucas.app.services.dto.PermissionRequest;
import br.edu.ifrs.riogrande.tads.carloslucas.app.services.dto.RoleRequest;;

public class PermissionServiceTest {

    RoleServiceStub roleServiceStub;
    PermissionServiceStub permissionServiceStub;
    UserService userServiceDummy;

    @BeforeEach
    void init() {
        roleServiceStub = new RoleServiceStub();
        permissionServiceStub = new PermissionServiceStub();
    }

    @Test
    void testPermissionInexistente() {
        List<Permission> permissions =    
        Assertions.assertThat(p.getTotal())
    }

    static class PermissionServiceStub implements IPermissionService {

        @Override
        public void save(PermissionRequest request) {
            // TODO Auto-generated method stub

        }

        @Override
        public Optional<Permission> findById(Integer id) {
            // TODO Auto-generated method stub
            return Optional.empty();
        }

        @Override
        public List<Permission> listAll() {
            Role role = new Role(1, "create", null);
            Permission p1 = new Permission(1, "t1", role);
            Permission p2 = new Permission(2, "t2", role);
            Permission p3 = new Permission(3, "t3", role);

            return new ArrayList<Permission>(List.of(p1, p2, p3));
        }

        @Override
        public void delete(Integer id) {
            // TODO Auto-generated method stub

        }

        @Override
        public void update(Integer id, @Valid PermissionRequest body) {
            // TODO Auto-generated method stub

        }

        @Override
        public Permission show(Integer id) {
            Role role = new Role(1, "create", null);
            Permission p1 = new Permission(1, "t1", role);
            return p1;
        }
    }

    static class RoleServiceStub implements IRoleService {

        public List<Role> roles = new ArrayList<Role>();

        @Override
        public void save(RoleRequest request) {
            roles.add(request.getRole());
        }

        @Override
        public Optional<Role> findById(Integer id) {
            // TODO Auto-generated method stub
            return Optional.empty();
        }

        @Override
        public List<Role> listAll() {

            Role r1 = new Role(1, "create", null);
            Role r2 = new Role(2, "list", null);
            Role r3 = new Role(3, "show", null);

            return new ArrayList<Role>(List.of(r1, r2, r3));
        }

        @Override
        public void delete(Integer id) {
            // TODO Auto-generated method stub

        }

        @Override
        public void update(Integer id, @Valid RoleRequest body) {
            // TODO Auto-generated method stub

        }

        @Override
        public Role show(Integer id) {
            // TODO Auto-generated method stub
            return null;
        }

    }
}
