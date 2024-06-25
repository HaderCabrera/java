package com.soccer;

import java.util.Hashtable;
import java.util.Scanner;

import com.soccer.model.entity.Player;
import com.soccer.model.entity.Team;
import com.soccer.view.viewPlayer;
import com.soccer.view.viewTeam;

import java.util.concurrent.ThreadLocalRandom;
public class Main {
    public static void main(String[] args) {
        // Para acceder a vista d econtroladores
        Controller ctrlTeams = new Controller();
        viewTeam.controlador1 = ctrlTeams;   

        // Para acceder a vista d econtroladores
        Controller ctrlPlayer = new Controller();
        viewPlayer.controlador = ctrlPlayer;  


        boolean flag = true;
        Scanner scannerm = new Scanner(System.in); 
        System.out.println("SALI DEL WHILE");
        while (flag) {
            System.out.println("\t");
            System.out.println("     GESTOR SOCCER");
            System.out.println("___________________________");
            System.out.println("1. Access to Team");
            System.out.println("2. Access to Player");
            System.out.println("3. Access to Doctor");
            System.out.println("4. Access to Coatch");
            System.out.println("5. Salir");
            System.out.println("===========================");
            System.out.print("Elija una opción: ");
            try {
                int choice = scannerm.nextInt();
                scannerm.nextLine(); // Consume newline
                switch (choice) {
                    case 1:
                        viewTeam vt = new viewTeam();
                        vt.start(scannerm);
                        break;
                    case 2:
 
                        viewPlayer vp = new viewPlayer();
                        vp.start(scannerm);
                        break;
                    default:
                        System.out.println("\t");
                        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                        System.out.println("¡Invalid input, enter a number between 1 and 5!");
                        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

                        break;
                    case 5:
                        scannerm.close();
                        flag = false;
                        break;
                }
            } catch (Exception e) {
                System.out.println("\t");
                System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                System.out.println("   ¡Invalid input, enter a number!");
                System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                scannerm.next();
            }
        }
    }
    // Llave unica para Equipos
    public static int generateUniqueKeyT(Hashtable<Integer, Team> hashtable){
        do {
            int randomInt = ThreadLocalRandom.current().nextInt(0, 100);
            if(!hashtable.containsKey(randomInt)) {
                return randomInt;
            }
        } while (true);
    }
    // LLave unica para Jugadores
    public static int generateUniqueKey(Hashtable<Integer, Player> hashtable){
        do {
            int randomInt2 = ThreadLocalRandom.current().nextInt(0, 100);
            if(!hashtable.containsKey(randomInt2)) {
                return randomInt2;
            }
        } while (true);
    }

}