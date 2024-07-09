package infrastructure.in;

import application.CreateUserUseCase;
import application.UpdateUserUseCase;
import domain.entity.User;
import java.util.Scanner;

public class UserController {
    private  CreateUserUseCase createUserUseCase;
    private UpdateUserUseCase updateUserUseCase;

    public UserController(CreateUserUseCase createUserUseCase, UpdateUserUseCase updateUserUseCase) {
        this.createUserUseCase = createUserUseCase;
        this.updateUserUseCase = updateUserUseCase;
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
                        
                        break;
                    case 3:
                        //DELETE
                        break;
                    case 4:
                        //FIND
                        break;
                    case 5:
                        System.out.println("Saliendo...");
                        salir = true;
                        break;
                    default:
                        System.out.println("Opción no válida, por favor elige una opción entre 1 y 4");
                }
            } catch (Exception e) {
                System.out.println("Ha ocurrido un error inesperado: " + e.getMessage());
            }
            scanner.close();
        }

    }
}
