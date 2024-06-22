package com.studyarray;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        System.out.println();
        //Crear arrayList
        ArrayList<String> list = new ArrayList<>();
        //Crear arrayList de pbjetos
        // ArrayList<Estudiante> lstStudents = new ArrayList<>();
        // Estudiante student;
        //     //Cuadro de dialogo para confirmacion de accion

        //     //Acciones (Modificar arriba para usar hacer acciones dentro de while)
        //     try (Scanner sc = new Scanner(System.in)){
        //         //showInputDialog solo captura cadenas de texto
        //         //student.setNombre(JOptionPane.showConfirmDialog(null, "Mensaje", "Informacion", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE) == 0){
        //             System.out.println("Ingrese el nombre del estudiante");
        //             student.setNombre(sc.nextLine());
        //             System.out.println("Ingrese el apellido del estudiante");
        //             student.setApellido(sc.nextLine());
        //             System.out.println("Ingrese el edad del estudiante");
        //             student.setEdad(sc.nextInt());
        //             sc.nextLine();
        //             lstStudents.add(student);
        //         }

        //     }
        //Agregar elementos
        list.add("Backend Java");
        list.add(0, "Fundamentos");
        System.out.println(list);

        //GET -> Obtener elementos por index 
        String elemento = list.get(0);
        System.out.println(elemento);

        // SET -> Modificar posicion especifica en el arreewglo
        list.set(0, "Programacion web");
        System.out.println(list);

        // Eliminar elemento por index
        String eliminado = list.remove(1);
        System.out.println(eliminado);
        // Eliminar por objeoto
        list.add("Mandarina");
        boolean result = list.remove("Mandarina");
        System.out.println(result);

        //Recorre lista con FOR
        for(String item: list){
            System.out.println(item);
        }

        // Vaciar el contenido de la lista
        list.clear();
        System.out.println(list);


    }
}