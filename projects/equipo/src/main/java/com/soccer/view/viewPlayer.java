package com.soccer.view;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.swing.text.View;

import com.soccer.Controller;
import com.soccer.Main;
import com.soccer.model.entity.Player;
import com.soccer.model.entity.Team;

public class viewPlayer {
    public static Controller controlador;// Variable que uso para
    //Controller controlador = new Controller();
    //establecer la comunicacion con la instancia del Objeto COntroller
    //desde MAIN.
    public void start(Scanner scanner) {
        //Scanner scanner = new Scanner(System.in);
        boolean flagE = true;
        while (flagE) {
            System.out.println("\t");
            System.out.println("  PLAYER ADMINISTRATION");
            System.out.println("___________________________");
            System.out.println("1. Create Player");
            System.out.println("2. Update Player");
            System.out.println("3. Search Player");
            System.out.println("4. Remove Player");
            System.out.println("5. Show Players");
            System.out.println("6. Exit.");
            System.out.println("===========================");
            System.out.print("Choose an option: ");
            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                Player player = new Player();
                switch (choice) {
                    case 1:
                        int codigoPlayer = Main.generateUniqueKey(controlador.players);
                        System.out.println("\t");
                        player.setId(codigoPlayer);

                        System.out.print("Player name: ");
                        String namePlayer = scanner.nextLine();
                        player.setNombre(namePlayer);

                        System.out.print("Player Last Name: ");
                        String lnamePlayer = scanner.nextLine();
                        player.setApellido(lnamePlayer);

                        System.out.print("Player's age: ");
                        int agePlayer = scanner.nextInt();
                        scanner.nextLine();
                        player.setEdad(agePlayer);

                        System.out.print("Player's position: ");
                        String positionPlayer = scanner.nextLine();
                        player.setPosicion(positionPlayer);

                        System.out.print("Player's dorsal: ");
                        int dorsalPlayer = scanner.nextInt();
                        scanner.nextLine();
                        player.setDorsal(dorsalPlayer);

                        controlador.players.put(codigoPlayer, player);
                        viewTeam.controlador1.players.put(codigoPlayer, player);

                        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                        System.out.println(MessageFormat.format("Player {0} has been added succesfully.", controlador.players.get(codigoPlayer).getNombre()));
                        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"); 

                        break;
    
                    case 2:
                        boolean flag;
                        if (controlador.players.size() > 0 ) { 
                            System.out.print("Ingrese el nombre del jugador que quiere modificar: ");
                            String nombre = scanner.nextLine();
                            Integer key = controlador.findKeyPlayer(nombre);
                            if (key == null) {
                                System.out.println("\t");
                                System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                                System.out.println("¡There isn't a team whit that name!");
                                System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                                continue;
                            } else {
                                flag = true;
                            }
                            //boolean flag = controlador.checkExistence(key);

                            while (flag) {
                                //
                                String namePlayerP = controlador.getNombreP(key);
                                System.out.println("\t");
                                System.out.println(MessageFormat.format("       {0}", namePlayerP.toUpperCase()));
                                System.out.println("___________________________");
                                System.out.println("1. Edit Name");
                                System.out.println("2. Edit Last Name");
                                System.out.println("3. Edit Age");
                                System.out.println("4. Edit Dorsal");
                                System.out.println("5. Edit Position");
                                System.out.println("6. Exit");
                                System.out.println("=============================");
                                System.out.print("Select an option: ");
                                int choice2 = scanner.nextInt();
                                scanner.nextLine(); // Consume newline   
                                    switch (choice2) {
                                        case 1:
                                            System.out.println("\t");  
                                            System.out.print("New player name: ");
                                            String newName = scanner.nextLine();
                                            controlador.setNombreP(key, newName);
                                            break;
                                        case 2:
                                            System.out.println("\t"); 
                                            System.out.print("New last name: ");
                                            String newApellido = scanner.nextLine();
                                            controlador.setApellidoP(key, newApellido);
                                            break;
                                        case 3:
                                            System.out.println("\t"); 
                                            System.out.print("New player's age: ");
                                            Integer newAgeP = scanner.nextInt();
                                            scanner.nextLine();
                                            controlador.setAgeP(key, newAgeP);
                                            break;
                                        case 4:
                                            System.out.println("\t"); 
                                            System.out.print("New player's dorsal: ");
                                            Integer newDorsalP = scanner.nextInt();
                                            scanner.nextLine();
                                            controlador.setDorsalP(key, newDorsalP);
                                            break;
                                        case 5:
                                            System.out.println("\t"); 
                                            System.out.print("New player's position: ");
                                            String newPositionP = scanner.nextLine();
                                            controlador.setPositionP(key, newPositionP);
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
                            System.out.println("¡Not players yet!");
                            System.out.println("@@@@@@@@@@@@@@@@@@");
                        }
                        break;
                    case 3:
                        if (controlador.players.size() > 0) {

                            System.out.print("Ingrese el nombre del player que quiere modificar: ");
                            String nombre = scanner.nextLine();
                            Integer key = controlador.findKeyPlayer(nombre);
                            if (key != null) {
                                Player findTeam = controlador.players.get(key);
                                String name = findTeam.getNombre();
                                String lastName = findTeam.getApellido();
                                int age = findTeam.getEdad();
                                int dorsal = findTeam.getDorsal();
                                String position = findTeam.getPosicion();
                                System.out.println("\n");
                                System.out.println("______________________________________________");
                                System.out.println("\tName:   \t" + name);
                                System.out.println("\tLast Name:   \t" + lastName);
                                System.out.println("\tAge:  \t" + age);
                                System.out.println("\tDorsal: \t" + dorsal);
                                System.out.println("\tPosition: \t" + position);
                                System.out.println("==============================================");
    
                            } else {
                                System.out.println("\t");
                                System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                                System.out.println("¡There isn't a player whit that name!");
                                System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                            }
                        } else {
                            System.out.println("\t");
                            System.out.println("@@@@@@@@@@@@@@@@@@");
                            System.out.println("¡Not players yet!");
                            System.out.println("@@@@@@@@@@@@@@@@@@");
                            continue;    
                        }
                        break;
    
                    case 4:
                        if (controlador.players.size() > 0) {

                            System.out.print("Ingrese el nombre del player que quiere eliminar: ");
                            String namePlayerP = scanner.nextLine();
                            Integer key = controlador.findKeyPlayer(namePlayerP);
                            if (key != null) {
                                controlador.removePlayer(key);
                                //Iterando PlayerControler para eliminar jugador de equipo
                                viewTeam.controlador1.equipos.values().forEach(equipoMod ->{
                                    // Iterar sobre la lista de jugadores
                                    for (int i = 0; i < equipoMod.getLstJugadores().size() ; i++) {
                                        Player jugador = equipoMod.getLstJugadores().get(i);
                                        if (jugador.getNombre().equals(namePlayerP)) {
                                            // Si encontramos el jugador por nombre, lo eliminamos
                                            equipoMod.getLstJugadores().remove(i);
                                        }
                                    }
                                });
                                //Iterando PlayerControler para eliminar jugador de equipo
                                viewTeam.controlador1.players.values().forEach(playerMod ->{
                                    if (playerMod.getNombre().equals(namePlayerP)) {
                                        viewTeam.controlador1.players.remove(playerMod.getId());
                                    }
                                });
                                System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                                System.out.println("Player wasremoved from Team/Player ");
                                System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"); 
                            } else {
                                System.out.println("\t");
                                System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                                System.out.println("¡There isn't a player whith that name!");
                                System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");  
                            }
                        } else {
                            System.out.println("\t");
                            System.out.println("@@@@@@@@@@@@@@@@@@");
                            System.out.println("¡Not players yet!");
                            System.out.println("@@@@@@@@@@@@@@@@@@"); 
                        }
                        break;
    
                    case 5:
                        if (controlador.players.size() != 0) {
                            controlador.showPlayers();
                        } else {
                            System.out.println("\t");
                            System.out.println("@@@@@@@@@@@@@@@@@@");
                            System.out.println("¡Not players yet!");
                            System.out.println("@@@@@@@@@@@@@@@@@@"); 
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
                System.out.println("   ¡Error deteted, veryfy you input!");
                System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                scanner.next();
            }
        }
    }
}