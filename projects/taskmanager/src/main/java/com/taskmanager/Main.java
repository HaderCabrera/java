package com.taskmanager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    private static final String FILE_NAME = "tasks.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Path path, rutaPaquete;
        File archivo;

        try {
            // Obtener la ruta del directorio que contiene el archivo JAR o el directorio de clases
            path = Paths.get(Main.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getParent();

            // Mover hacia el directorio del proyecto
            Path projectDir = path.getParent();

            // Construir la ruta relativa del paquete 'src/main/java/com/filemanager/data'
            rutaPaquete = projectDir.resolve(Paths.get("src", "main", "java", "com", "taskmanager"));
            File carpeta = rutaPaquete.toFile();
            archivo = new File(carpeta, FILE_NAME);

            // Crear la carpeta si no existe
            if (!carpeta.exists()) {
                if (carpeta.mkdirs()) {
                    System.out.println("Carpeta creada: " + carpeta.getAbsolutePath());
                } else {
                    System.out.println("Error al crear la carpeta.");
                    return;
                }
            }

            // Crear el archivo si no existe
            if (!archivo.exists()) {
                if (archivo.createNewFile()) {
                    System.out.println("Archivo de tareas creado: " + archivo.getName());
                } else {
                    System.out.println("Error al crear el archivo de tareas.");
                    return;
                }
            }

            // Menú de opciones
            int opcion;
            do {
                System.out.println("\nGestor de Tareas");
                System.out.println("1. Agregar Tarea");
                System.out.println("2. Listar Tareas");
                System.out.println("3. Buscar Tarea");
                System.out.println("4. Eliminar Tarea");
                System.out.println("5. Salir");
                System.out.print("Selecciona una opción: ");
                opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer

                switch (opcion) {
                    case 1:
                        System.out.print("Escribe la tarea a agregar: ");
                        String nuevaTarea = scanner.nextLine();
                        // agregarTarea(archivo, nuevaTarea);
                        //INTENTO SOLID
                        Manager agregar = new addTask(nuevaTarea, archivo);
                        Controller controlador = new Controller();
                        controlador.addTask(agregar);

                        break;
                    case 2:
                        //listarTareas(archivo);
                        Manager listar = new showTask(archivo);
                        Controller controlador2 = new Controller();
                        controlador2.showTask(listar);
                        break;
                    case 3:
                        System.out.print("Escribe la tarea a buscar: ");
                        String tareaBuscar = scanner.nextLine();
                        //buscarTarea(archivo, tareaBuscar);
                        Manager buscar = new findTask(tareaBuscar, archivo);
                        Controller controlador4 = new Controller();
                        controlador4.findTask(buscar);
                        break;
                    case 4:
                        System.out.print("Escribe la tarea a eliminar: ");
                        String tareaEliminar = scanner.nextLine();
                        //eliminarTarea(archivo, tareaEliminar);
                        Manager eliminar = new removeTask(archivo, tareaEliminar);
                        Controller controlador3 = new Controller();
                        controlador3.removeTask(eliminar);
                        break;
                    case 5:
                        System.out.println("Saliendo...");
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
            } while (opcion != 5);

        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }




}