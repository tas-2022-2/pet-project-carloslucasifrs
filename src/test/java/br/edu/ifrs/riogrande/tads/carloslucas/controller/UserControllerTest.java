package br.edu.ifrs.riogrande.tads.carloslucas.controller;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.assertj.core.api.Assertions;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import br.edu.ifrs.riogrande.tads.carloslucas.app.model.User;
import br.edu.ifrs.riogrande.tads.carloslucas.app.services.UserService;
import br.edu.ifrs.riogrande.tads.carloslucas.app.services.dto.UserRequest;

@WebMvcTest(UserController.class)
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    ObjectMapper mapper;

    @MockBean
    UserService userService;

    @Autowired
    MockMvc mvc;

    @Test
    void testNewUserCPFInvalidRetun400BadRequest() throws Exception {
        mvc.perform(
                post("/api/v1/users")
                        .content("{\"cpf\": \"57649,11691\", \"nome\": \"Delanode tal\"}")
                        .header("Content-Type", "application/json")
                        .accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(status().isBadRequest())
                .andExpect(content().string(
                        Matchers.containsString("CPF inválido: deve ter 11 dígitos com dígito verificador correto")));
    }

    @Test
    void testNewUserNameMin2CharRetun400BadRequest() throws Exception {
        mvc.perform(
                post("/api/v1/users")
                        .content("{\"cpf\": \"76203811041\", \"name\": \"D\"}")
                        .header("Content-Type", "application/json")
                        .accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(status().isBadRequest())
                .andExpect(content().string(Matchers.containsString("Nome inválido: deve ter pelo menos duas letras")));

    }

    @Test
    void testNewUserCPFNameValidRetun200OK() throws Exception {
        UserRequest request = new UserRequest();
        request.setCpf("76203811041");
        request.setName("Fulano de Tal");

        mvc.perform(
                post("/api/v1/users")
                        .content("{\"cpf\": \"76203811041\", \"name\": \"Fulano de Tal\"}")
                        .header("Content-Type", "application/json")
                        .accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(status().isOk());

        Mockito.verify(userService).salvar(request);
    }

    @Test
    void testListReturnUSersOK() throws Exception {

        Mockito.when(userService.listar()).thenReturn(getFakerUsers());

        mvc.perform(
                get("/api/v1/users/")
                        .accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(status().isOk())
                .andExpect(content().json(getFakerUsersJson()));

        Mockito.verify(userService).listar();
    }

    List<User> getFakerUsers() {
        List<User> users = new ArrayList<>();

        users.add(new User(1, "76203811041", "Fulano de Tal"));
        users.add(new User(1, "16536078748", "Beltrano de Tal"));

        return users;

    }

    String getFakerUsersJson() throws Exception {
        return mapper.writeValueAsString(getFakerUsers());

    }

    @Test
    void testaVerdade() {
        assertTrue(true);
        Assertions.assertThat(true).isTrue();
    }
}
