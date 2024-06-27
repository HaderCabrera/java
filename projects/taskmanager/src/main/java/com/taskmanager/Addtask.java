package com.taskmanager;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class Addtask {  
    public static void agregar(File archivo, String tarea){
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(archivo, true), StandardCharsets.UTF_8))) {
            writer.write(tarea);
            writer.newLine();
            System.out.println("Tarea agregada: " + tarea);
        } catch (IOException e) {
            System.out.println("Ocurrió un error al agregar la tarea.");
            e.printStackTrace();
        }
    }
}
