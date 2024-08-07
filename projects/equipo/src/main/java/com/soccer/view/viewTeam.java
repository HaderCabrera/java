package com.soccer.view;

import java.text.MessageFormat;
import java.util.Scanner;

import com.soccer.Controller;
import com.soccer.Main;
import com.soccer.model.entity.Player;
import com.soccer.model.entity.Team;

public class viewTeam {
    public static Controller controlador1;// Variable que uso para
    //Controller controlador = new Controller();
    //establecer la comunicacion con la instancia del Objeto COntroller
    //desde MAIN.
    public void start(Scanner scanner) {
        //Scanner scanner = new Scanner(System.in);
        boolean flagE = true;
        while (flagE) { 
            System.out.println("\t");
            System.out.println("  Team Administration");
            System.out.println("___________________________");
            System.out.println("1. Create Team");
            System.out.println("2. Update Team");
            System.out.println("3. Search Team");
            System.out.println("4. Remove Team");
            System.out.println("5. Show Teams");
            System.out.println("6. Exit.");
            System.out.println("===========================");
            System.out.print("Choose an option: ");
            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                Team equipo = new Team();
                switch (choice) {
                    case 1:
                        System.out.println("\t");

                        System.out.print("Team name: ");
                        String teamName = scanner.nextLine();
                        equipo.setNombre(teamName);
    
                        System.out.print("Team city: ");
                        String teamCity = scanner.nextLine();
                        equipo.setCiudad(teamCity);
                        int codigoEquipo = Main.generateUniqueKeyT(controlador1.equipos);
                        controlador1.equipos.put(codigoEquipo, equipo);
                        //añaniendo comuinicacion al controlador de viewPLayer
                        viewPlayer.controlador.equipos.put(codigoEquipo, equipo);
                        break;
    
                    case 2:

                        if (controlador1.equipos.size() > 0 ) { 
                            System.out.print("Ingrese el nombre del equipo que quiere modificar: ");
                            String nombre = scanner.nextLine();
                            Integer key = controlador1.findKeyEquipo(nombre);
                            if (key == null) {
                                System.out.println("\t");
                                System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                                System.out.println("¡There isn't a team whit that name!");
                                System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                                continue;
                            }
                            boolean flag = controlador1.checkExistence(key);

                            while (flag) {
                                //
                                String nameTeam = controlador1.getNombre(key);
                                System.out.println("\t");
                                System.out.println(MessageFormat.format("       {0}", nameTeam.toUpperCase()));
                                System.out.println("___________________________");
                                System.out.println("1. Editar nombre");
                                System.out.println("2. Editar ciudad");
                                System.out.println("3. Agregar jugador");
                                System.out.println("4. Agregar entrenadores (N/D)");
                                System.out.println("5. Agregar doctores (N/D)");
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
                                            controlador1.setNombre(key, newName);
                                            break;
                                        case 2:
                                            System.out.println("\t"); 
                                            System.out.print("New team city: ");
                                            String newCity = scanner.nextLine();
                                            controlador1.setCity(key, newCity);
                                            break;
                                        case 3:
                                            if (controlador1.players.size() > 0) {
                                                System.out.print("Enter the name's player to add: ");
                                                String playerAdd = scanner.nextLine();
                                                Integer keyP = controlador1.findKeyPlayer(playerAdd);
                                                if (keyP != null) {
                                                    Player addPlayer = controlador1.players.get(keyP);
                                                    controlador1.equipos.get(key).setLstJugadores(addPlayer);
                                                }     
                                            } else {
                                                System.out.println("\t");
                                                System.out.println("@@@@@@@@@@@@@@@@@@");
                                                System.out.println("¡Not players yet!");
                                                System.out.println("@@@@@@@@@@@@@@@@@@");
                                            }
                                            break;
        
                                        case 6:
                                            flag = false;
                                            break;
                                    
                                        default:
                                            System.out.println("\t");
                                            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                                            System.out.println("¡Invalid input, enter a number between 1 and 6!");
                                            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
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
                        if (controlador1.equipos.size() > 0) {

                            System.out.print("Ingrese el nombre del equipo que quiere modificar: ");
                            String nombre = scanner.nextLine();
                            Integer key = controlador1.findKeyEquipo(nombre);
                            if (key != null) {
                                Team findTeam = controlador1.equipos.get(key);
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
                                System.out.println("¡There isn't a team whit that name!");
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
                        if (controlador1.equipos.size() > 0) {
                            System.out.print("Ingrese el nombre del equipo que quiere eliminar: ");
                            String nameEquipo = scanner.nextLine();
                            Integer key = controlador1.findKeyEquipo(nameEquipo);

                            if (key != null) {
                                controlador1.removeTeam(key);
                            }
                        } else {
                            System.out.println("\t");
                            System.out.println("@@@@@@@@@@@@@@@@@@");
                            System.out.println("¡Not teams yet!");
                            System.out.println("@@@@@@@@@@@@@@@@@@"); 
                        }
                        break;
    
                    case 5:
                        if (controlador1.equipos.size() != 0) {
                            controlador1.showTeams();
                        }
                        break;
    
                    case 6:
                        //scanner.close();
                        //System.exit(0);
                        flagE = false;
                        break;
    
                    default:
                        System.out.println("\t");
                        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                        System.out.println("¡Invalid input, enter a number between 1 and 6!");
                        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("\t");
                System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                System.out.println(e);
                System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                scanner.next();
            }
        }
    }
}