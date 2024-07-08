package com.exagonaldemo;

import application.CreateUserUseCase;
import domain.service.UserService;
import infraestructure.in.UserController;
import infraestructure.out.UserRepository;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserRepository();
        CreateUserUseCase createUserUseCase = new CreateUserUseCase(userService);
        UserController consoleAdapter = new UserController(createUserUseCase);

        consoleAdapter.start();
    }
}