package br.edu.ifrs.riogrande.tads.carloslucas.app.services;

import org.junit.jupiter.api.BeforeEach;

public class RoleServiceTest {
    UserService userServiceStub;

    @BeforeEach
    void init() {
        userServiceStub = new UserServiceStub();
    }

}
