package br.edu.ifrs.riogrande.tads.carloslucas.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import br.edu.ifrs.riogrande.tads.carloslucas.app.model.Role;
import br.edu.ifrs.riogrande.tads.carloslucas.app.services.RoleService;
import br.edu.ifrs.riogrande.tads.carloslucas.app.services.dto.RoleRequest;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Validated
@RestController
@RequestMapping("/api/v1")
public class RoleController {

    private final RoleService roleService;

    @GetMapping(path = "/roles", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Role>> listAll() {

        List<Role> roles = roleService.listAll();

        return ResponseEntity.ok(roles);
    }

    @GetMapping(path = "/roles/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> show(@PathVariable(name = "id") Integer id) {
        return ResponseEntity.ok(roleService.show(id));
    }

    @PostMapping(path = "/roles", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> create(
            @RequestBody @Valid RoleRequest body) {

        roleService.save(body);
        return ResponseEntity.ok(body);

    }

    @PutMapping(path = "/roles/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.OK)
    public void update(
            @PathVariable(name = "id") Integer id,
            @RequestBody @Valid RoleRequest body) {
        roleService.update(id, body);
    }

    @DeleteMapping(path = "/roles/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public void delete(@PathVariable(name = "id") Integer id) {
        roleService.delete(id);
    }
}
