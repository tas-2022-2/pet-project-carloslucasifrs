package br.edu.ifrs.riogrande.tads.carloslucas.app.services.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import lombok.AccessLevel;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RoleRequest {
    
    @NotNull(message = "Role é Obrigatória")
    @Size(min = 3, max = 30, message = "Role deve possuir de 3 a 20 caracteres")
    String role;

}
