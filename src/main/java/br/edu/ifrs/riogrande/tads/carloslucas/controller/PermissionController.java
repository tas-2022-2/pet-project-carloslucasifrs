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

import br.edu.ifrs.riogrande.tads.carloslucas.app.model.Permission;
import br.edu.ifrs.riogrande.tads.carloslucas.app.services.PermissionService;
import br.edu.ifrs.riogrande.tads.carloslucas.app.services.dto.PermissionRequest;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Validated
@RestController
@RequestMapping("/api/v1")
public class PermissionController {

    private final PermissionService permissionService;

    @GetMapping(path = "/permissions", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Permission>> listAll() {

        List<Permission> permissions = permissionService.listAll();

        return ResponseEntity.ok(permissions);
    }

    @GetMapping(path = "/permissions/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> show(@PathVariable(name = "id") Integer id) {
        return ResponseEntity.ok(permissionService.show(id));
    }

    @PostMapping(path = "/permissions", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> create(
            @RequestBody @Valid PermissionRequest body) {

        permissionService.save(body);
        
        return ResponseEntity.ok(body);

    }

    @PutMapping(path = "/permissions/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.OK)
    public void update(
            @PathVariable(name = "id") Integer id,
            @RequestBody @Valid PermissionRequest body) {
        permissionService.update(id, body);
    }

    @DeleteMapping(path = "/permissions/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public void delete(@PathVariable(name = "id") Integer id) {
        permissionService.delete(id);
    }
}
