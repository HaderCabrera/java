package com.ligabetplay.view;

import java.text.MessageFormat;
import java.util.Scanner;

import com.ligabetplay.controller.ControllerDate;
import com.ligabetplay.controller.Keyunique;
import com.ligabetplay.model.entity.Permiso;

public class viewEquipos {
    ControllerDate controlador = new ControllerDate();
    public void gestorEquipos(){
                Scanner scanner = new Scanner(System.in);
        // Menú de opciones
        int opcion = 0;
        while (opcion != 6) {
            try{
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
                System.out.print("-> Choose an option: ");
                opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer
                
                switch (opcion) {
                    case 1:
                        //Generamos llave unica
                        int keyT = Keyunique.generateUniqueKeyT(controlador.equipos);
                        
                        break;
                    case 2:
                        System.out.println("Saliendo...");
                        break;
                    default:
                        System.out.println("@@@@@@@@@@@@@@@@@");
                        System.out.println("Opción no válida.");
                        System.out.println("@@@@@@@@@@@@@@@@@");
                        break;
                }
            } catch (Exception e) {
                System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                System.out.println("Formato invalido. Input a nùmber!");
                System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                scanner.nextLine();
            } 
        } 
        
    }
}  

