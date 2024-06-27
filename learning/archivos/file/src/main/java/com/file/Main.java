package com.file;

import java.io.File;
import java.io.IOException;



public class Main {
    public static void main(String[] args) {
        String paquete = "learning/archivos/file/src/main/java/com/file";
        //String paquete = "src/main/java/com/file"; //la ruta varia de donde este en el terminal   
        String file = "contenido.txt";
        //Crear un objeto File para la carpeta del paquete 'data'
        File carpeta = new File(paquete);
        File archivo = new File(carpeta, file);

        try {
            if(archivo.createNewFile()){
                System.out.println("Archivo creado: " + archivo.getName());
            } else {
                System.out.println("El archivo ya existe.");
            }
        } catch (IOException e) {
            System.out.println("Error al crear archivo." + e);
            e.printStackTrace();
        }
    }
}