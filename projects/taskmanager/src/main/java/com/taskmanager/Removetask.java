package com.taskmanager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class Removetask {
    public static void eliminar(File archivo, String tareaEliminar){
                File tempFile = new File(archivo.getAbsolutePath() + ".tmp");
        boolean eliminada = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(archivo, StandardCharsets.UTF_8));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(tempFile), StandardCharsets.UTF_8))) {
            String tarea;
            while ((tarea = reader.readLine()) != null) {
                if (tarea.equals(tareaEliminar)) {
                    eliminada = true;
                    continue;
                }
                writer.write(tarea);
                writer.newLine();
            }
            if (!eliminada) {
                System.out.println("Tarea no encontrada para eliminar.");
            } else {
                System.out.println("Tarea eliminada: " + tareaEliminar);
            }
        } catch (IOException e) {
            System.out.println("Ocurrió un error al eliminar la tarea.");
            e.printStackTrace();
        }

        // Reemplazar el archivo original con el archivo temporal
        if (!archivo.delete()) {
            System.out.println("Error al eliminar el archivo original.");
            return;
        }
        if (!tempFile.renameTo(archivo)) {
            System.out.println("Error al renombrar el archivo temporal.");
        }
    }
}
