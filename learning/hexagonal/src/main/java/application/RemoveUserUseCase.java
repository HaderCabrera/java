package application;

import domain.service.UserService;

public class RemoveUserUseCase {
    private final UserService userService;

    public RemoveUserUseCase(UserService userService) {
        this.userService = userService;
    }

    public void execute(Long id) {
        userService.removeUser(id);
    }
}
