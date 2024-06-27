package com.taskmanager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Showtask {
    public static void listar(File archivo){
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo, StandardCharsets.UTF_8))) {
            String tarea;
            System.out.println("\nLista de Tareas:");
            while ((tarea = reader.readLine()) != null) {
                System.out.println(tarea);
            }
        } catch (IOException e) {
            System.out.println("Ocurrió un error al listar las tareas.");
            e.printStackTrace();
        }
    }
}
