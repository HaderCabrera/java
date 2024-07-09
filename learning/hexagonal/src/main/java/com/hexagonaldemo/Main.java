package com.hexagonaldemo;

import application.CreateUserUseCase;
import application.UpdateUserUseCase;
import domain.service.UserService;
import infrastructure.in.UserController;
import infrastructure.out.UserRepository;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserRepository();
        CreateUserUseCase createUserUseCase = new CreateUserUseCase(userService);
        UpdateUserUseCase updateUserUseCase = new UpdateUserUseCase(userService);
        UserController consoleAdapter = new UserController(createUserUseCase, updateUserUseCase);
        consoleAdapter.start();

    }
}