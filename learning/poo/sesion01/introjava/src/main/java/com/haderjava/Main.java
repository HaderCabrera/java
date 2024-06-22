package com.haderjava;

import java.text.MessageFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int edad;
        double precio = 20000;
        String nombre = "Juan";
        // comentarios en linea
        /* Comentario en bloque */
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Ingrese la edad:");
            edad = sc.nextInt();
            sc.nextLine();
            System.out.println("Ingrese el nombre");
            nombre = sc.nextLine();
            sc.close();
        }
        // Concatenaciòn
        System.out.println(nombre+"tiene"+edad+"años");
        System.out.println(MessageFormat.format("{0} tiene {1} años", nombre, edad));

        // Ejercicio 1
        String mensaje = "Hola\nMundo"; // Salto de linea entre "Hola" y "Mundo"
        String tabla = "Nombre\tApellido\tEdad"; //Tabuladores entre las palabras
        String retroceso = "123\b45"; //  Se limina el '3' con retroseso
        String ruta = "C:\\Users\\Usuario\\Documentos"; // Incluyendo una barra invertida en una ruta
        String comillas = "\"Esto es una cita\""; // Inclutyredo comillas dobles en una cadena de texto
        System.out.println(mensaje);
        System.out.println(tabla);
        System.out.println(retroceso);
        System.out.println(ruta);
        System.out.println(comillas);

        // EJERCICIO DE CONDICIONAL
        try (Scanner sc = new Scanner(System.in))
        {
            int edadd = 0;
            System.out.println("Ingrese la edad");
            edadd = sc.nextInt();
            sc.close();
            if (edadd >= 18) {
                System.out.println("Persona mayor de edad");
            }
        }
        // EJERCICIO DE CONDICIONALES
        int acum = 0;
        int valor = 0;
        try (Scanner sc = new Scanner(System.in)) {
            
            /*while (valor >= 0) {
                System.out.println("Ingrese la edad:");
                valor = sc.nextInt();
                sc.nextLine();
                if (valor < 0) break;
                acum += valor;
            } */

            /*do {
                System.out.println("Ingrese la edad:");
                valor = sc.nextInt();
                sc.nextLine();
                if (valor < 0) break;
            }while (valor >= 0);*/
            
            int nrosInv = 0;
            int nrosVal = 0;
            for(int i = 1; i<= 3; i++){
                System.out.println("Ingrese la edad:");
                valor = sc.nextInt();
                sc.nextLine();
                if (valor < 0){
                    nrosInv++;
                    continue;
                }
                nrosVal++;
                acum += valor;
            }
        }
        
    }
}
