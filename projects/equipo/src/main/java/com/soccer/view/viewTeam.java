package com.soccer.view;

import java.util.Scanner;

import com.soccer.Controller;
import com.soccer.Main;
import com.soccer.model.entity.Team;

public class viewTeam {
    public static Controller controlador; // Variable que uso para
    //establecer la comunicacion con la instancia del Objeto COntroller
    //desde MAIN.
    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Crear Equipo");
            System.out.println("2. Actualizar Equipo");
            System.out.println("3. Buscar Equipo");
            System.out.println("4. Eliminar Equipo");
            System.out.println("5. Listar todos Equipos");
            System.out.println("6. Salir");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                        Team equipo = new Team();
                        int codigoEquipo = Main.generateUniqueKey(controlador.equipos);
                        System.out.println("PASE EL MAIN");
                        System.out.println("Ingrese Nombre del equipo :");
                        equipo.setNombre(scanner.nextLine());
                        System.out.println("Ingrese la ciudad :");
                        equipo.setCiudad(scanner.nextLine());
                        controlador.equipos.put(codigoEquipo, equipo);
                    break;

                case 2:
                    System.out.println(controlador.equipos.keySet());

                    break;

                case 3:
                    //Team eq = new Team();
                    //String codigoE = "001";
                    //eq = controlador.equipos.get(codigoE);
                    //System.out.println("Mi equipo" + eq.getNombre());
                    break;
                case 4:

                    break;

                case 5:

                    break;

                case 6:
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opcion invalida, intentelo de nuevo.");
            }
        }
    }
}
