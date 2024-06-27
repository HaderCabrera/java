package com.taskmanager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Searchtask {
    public static void buscar(File archivo, String tareaBuscada){
                try (BufferedReader reader = new BufferedReader(new FileReader(archivo, StandardCharsets.UTF_8))) {
            String tarea;
            boolean encontrada = false;
            while ((tarea = reader.readLine()) != null) {
                if (tarea.contains(tareaBuscada)) {
                    System.out.println("Tarea encontrada: " + tarea);
                    encontrada = true;
                    break;
                }
            }
            if (!encontrada) {
                System.out.println("Tarea no encontrada.");
            }
        } catch (IOException e) {
            System.out.println("Ocurrió un error al buscar la tarea.");
            e.printStackTrace();
        }
    }
}
