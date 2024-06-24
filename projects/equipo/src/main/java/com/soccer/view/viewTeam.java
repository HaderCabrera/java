package com.soccer.view;

import java.text.MessageFormat;
import java.util.Scanner;

import com.soccer.Controller;
import com.soccer.Main;
import com.soccer.model.entity.Team;

public class viewTeam {
    public static Controller controlador; // Variable que uso para
    //Controller controlador = new Controller();
    //establecer la comunicacion con la instancia del Objeto COntroller
    //desde MAIN.
    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\t");
            System.out.println("     GESTOR DE EQUIPOS");
            System.out.println("___________________________");
            System.out.println("1. Crear Equipo");
            System.out.println("2. Actualizar Equipo");
            System.out.println("3. Buscar Equipo");
            System.out.println("4. Eliminar Equipo");
            System.out.println("5. Listar todos Equipos");
            System.out.println("6. Salir");
            System.out.println("===========================");
            System.out.print("Elija una opción: ");
            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                Team equipo = new Team();
                switch (choice) {
                    case 1:
                        System.out.println("\t");
                        int codigoEquipo = Main.generateUniqueKey(controlador.equipos);
                        System.out.print("Team name: ");
                        String teamName = scanner.nextLine();
                        equipo.setNombre(teamName);
    
                        System.out.print("Team city: ");
                        String teamCity = scanner.nextLine();
                        equipo.setCiudad(teamCity);
    
                        controlador.equipos.put(codigoEquipo, equipo);
                        break;
    
                    case 2:
    
                    if (controlador.equipos.size() > 0 ) { 
                        controlador.getKeys();
                        System.out.print("Ingrese el ID del equipo que quiere modificar: ");
                        Integer key = scanner.nextInt();
                        boolean flag = controlador.checkExistence(key);
                        if (flag == false) {
                            System.out.println("\t");
                            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                            System.out.println("¡There isn't a team whit that ID!");
                            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                            break;
                        }
                        while (flag) {
                            //
                            String nameTeam = controlador.getNombre(key);
                            System.out.println("\t");
                            System.out.println(MessageFormat.format("       {0}", nameTeam.toUpperCase()));
                            System.out.println("___________________________");
                            System.out.println("1. Editar nombre");
                            System.out.println("2. Editar ciudad");
                            System.out.println("3. Editar jugadores (N/D)");
                            System.out.println("4. Editar entrenadores (N/D)");
                            System.out.println("5. Editar doctores (N/D)");
                            System.out.println("6. Salir");
                            System.out.println("=============================");
                            System.out.print("Elija una opción: ");
                            int choice2 = scanner.nextInt();
                            scanner.nextLine(); // Consume newline   
                                switch (choice2) {
                                    case 1:
                                        System.out.println("\t");  
                                        System.out.print("New team name: ");
                                        String newName = scanner.nextLine();
                                        controlador.setNombre(key, newName);
                                        controlador.listarEquipo(key);
                                        break;
                                    case 2:
                                        System.out.println("\t"); 
                                        System.out.print("New team city: ");
                                        String newCity = scanner.nextLine();
                                        controlador.setCity(key, newCity);
                                        controlador.listarEquipo(key);
                                        break;
                                    case 3:
                                    
                                        break;
    
                                    case 6:
                                        flag = false;
                                        break;
                                
                                    default:
                                        System.out.println("\t");
                                        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                                        System.out.println("¡Opcion invalida, intentelo de nuevo!");
                                        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                                        break;
                                }  
                        }
                    } else {
                        System.out.println("\t");
                        System.out.println("@@@@@@@@@@@@@@@@@@");
                        System.out.println("¡Not teams yet!");
                        System.out.println("@@@@@@@@@@@@@@@@@@");
                    }
                    break;
                    case 3:
                        if (controlador.equipos.size() > 0) {
                            controlador.getKeys();
                            System.out.print("Indique el ID del equipo: ");
                            Integer choice3 = scanner.nextInt();
                            scanner.nextLine();
                            if (controlador.checkExistence(choice3)) {
                                Team findTeam = controlador.equipos.get(choice3);
                                String name = findTeam.getNombre();
                                String city = findTeam.getCiudad();
                                int players = findTeam.getLstJugadores().size();
                                int trainers = findTeam.getLstEntrenadores().size();
                                int doctors = findTeam.getLstMasajistas().size();
                                System.out.println("\n");
                                System.out.println("______________________________________________");
                                System.out.println("\tName:   \t" + name);
                                System.out.println("\tCity:   \t" + city);
                                System.out.println("\tJugadores: \t" + players);
                                System.out.println("\tTrainers: \t" + trainers);
                                System.out.println("\tDoctors: \t" + doctors);
                                System.out.println("==============================================");
    
                            } else {
                                System.out.println("\t");
                                System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                                System.out.println("¡There isn't a team whit that ID!");
                                System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                            }
                        } else {
                            System.out.println("\t");
                            System.out.println("@@@@@@@@@@@@@@@@@@");
                            System.out.println("¡Not teams yet!");
                            System.out.println("@@@@@@@@@@@@@@@@@@");
                            continue;    
                        }
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
                        System.out.println("\t");
                        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                        System.out.println("¡Opcion invalida, intentelo de nuevo!");
                        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("\t");
                System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                System.out.println("   ¡Invalid input, enter a number!");
                System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                scanner.next();
            }
        }
    }
}