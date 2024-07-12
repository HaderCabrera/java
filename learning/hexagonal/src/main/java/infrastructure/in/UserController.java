package infrastructure.in;

import application.CreateUserUseCase;
import application.FindUserUseCase;
import application.RemoveUserUseCase;
import application.UpdateUserUseCase;
import domain.entity.User;

import java.text.MessageFormat;
import java.util.Scanner;


public class UserController {
    private  CreateUserUseCase createUserUseCase;
    private UpdateUserUseCase updateUserUseCase;
    private RemoveUserUseCase removeUserUseCase;
    private FindUserUseCase findUserUseCase;
    

    public UserController(CreateUserUseCase createUserUseCase, UpdateUserUseCase updateUserUseCase,
            RemoveUserUseCase removeUserUseCase, FindUserUseCase findUserUseCase) {
        this.createUserUseCase = createUserUseCase;
        this.updateUserUseCase = updateUserUseCase;
        this.removeUserUseCase = removeUserUseCase;
        this.findUserUseCase = findUserUseCase;
    }


    public void start() {
        boolean salir = false;

        while (!salir) {
            System.out.println("1. Create user");
            System.out.println("2. Update user");
            System.out.println("3. Delete user");
            System.out.println("4. Find user");
            System.out.println("5. Salir");
            System.out.print("Elige una opción:");
            Scanner scanner = new Scanner(System.in);
            try {

                int opcion = Integer.parseInt(scanner.nextLine());

                switch (opcion) {
                    case 1:
                        System.out.println("Enter user name: ");
                        String name = scanner.nextLine();
            
                        System.out.println("Enter user email: ");
                        String email = scanner.nextLine();
            
                        User user = new User();
                        user.setName(name);
                        user.setEmail(email);
            
                        createUserUseCase.execute(user);
                        System.out.println("User created successfully!");
                        break;
                    case 2:
                        //UPDATE
                        System.out.println("Enter user id: ");
                        Long id = scanner.nextLong();
                        scanner.nextLine();

                        System.out.println("Enter new user name: ");
                        String newName = scanner.nextLine();

                        System.out.println("Enter new user email: ");
                        String newEmail = scanner.nextLine();

                        User newUser = new User();
                        newUser.setId(id);
                        newUser.setEmail(newEmail);
                        newUser.setName(newName);

                        updateUserUseCase.execute(newUser);

                        System.out.println("Update succesfully!");
                        break;

                    case 3:
                        //DELETE
                        System.out.println("Enter user id to remove: ");
                        Long removeId = scanner.nextLong();
                        scanner.nextLine();

                        removeUserUseCase.execute(removeId);
                        
                        break;
                    case 4:
                        System.out.println("Enter user id: ");
                        Long findId = scanner.nextLong();
                        scanner.nextLine();
                        User findUser = findUserUseCase.execute(findId);
                        System.out.println(MessageFormat.format("Name: {0}, email: {1}",findUser.getName(),findUser.getEmail()));
                        break;
                    case 5:
                        System.out.println("Saliendo...");
                        salir = true;
                        break;
                    default:
                        System.out.println("Opción no válida, por favor elige una opción entre 1 y 4");
                }
            } catch (Exception e) {
                System.out.println("Ha ocurrido un error inesperado: " + e);
            }
        }

    }
}
