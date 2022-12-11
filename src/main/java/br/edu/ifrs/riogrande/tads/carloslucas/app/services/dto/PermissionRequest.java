package br.edu.ifrs.riogrande.tads.carloslucas.app.services.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;


@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PermissionRequest {

    @NotNull(message = "Permissão é Obrigatória")
    @Size(min = 3, max = 30, message = "Permissão deve possuir de 3 a 30 caracteres")
    String permission;

    @NotNull(message = "Role ID é Obrigatória")
    Integer roles_id;

}
