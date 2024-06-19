package com.ahorcado;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        // Declaracion de variables
        boolean flag = true;
        int vidas = 3;
        boolean dead = true;
        String pala = "";

        // Creamos el array
        ArrayList<String> letters = new ArrayList<String>();

        // Agregamos palabras al array
        letters.add("Hola");
        letters.add("Mundo");
        letters.add("Java");
        letters.add("ArrayList");
        letters.add("String");
        letters.add("Ejemplo");
        letters.add("Programación");
        letters.add("Desarrollo");
        letters.add("OpenAI");
        letters.add("ChatGPT");

        //Ciclo de juego con bandera
        while (flag) {
            // Menu de juego Jugar/Salir
            String[] options = {"jugar", "salir"};
            Object defaultOption = options[0];
            // Mostrar el cuadro de diálogo y obtener la selección del usuario
            Object opcion = JOptionPane.showInputDialog(null, "Que deseas hacer?", "Ahorcado GAME",
            JOptionPane.QUESTION_MESSAGE,null,options,defaultOption);
            System.out.println("Opcion seleccionada: " + opcion);
            String select = "" + opcion;
            switch (select) {
                case "jugar":
                    //Eleginar palabra aleatoria del array
                    Random rand = new Random();
                    int indiceAleatorio = rand.nextInt(letters.size());
                    String palabraAleatoria = letters.get(indiceAleatorio);
                    System.out.println(palabraAleatoria);
                    drawMessage(palabraAleatoria, vidas);

                    do {
                        String letter = getLetter();
                        boolean exists = buscarLetra(letter, palabraAleatoria);
                        if (!exists) {
                            vidas --;
                            System.out.println("Menos una vida");
                            if (vidas < 1){
                                System.out.println("Eres un loser, try it again.");
                                dead = false;
                            }
                        } else {
                            String palabraAleatoriaa = palabraAleatoria.toLowerCase();
                            String letterr = letter.toLowerCase();
                                if(palabraAleatoriaa.contains(letterr)) {
                                    pala = palabraAleatoriaa.replace(letterr, "");

                                }
                        }
                        System.out.println(pala);
                    } while(dead);
                    break;
                case "salir":
                    System.out.println("Chaito");
                    flag = false;
                    break;
                default:
                    System.out.println("Valor ingresado no valido.");
                    break;
            }
        }
    }

    public static void drawMessage(String palabraAleatoria, int vidas){
        //Crear mensaje de la palabra
        String mensaje = "";
        for(int i = 0; i < palabraAleatoria.length(); i++ ) {
            mensaje += "__" + " "; 
        }
        JOptionPane.showMessageDialog(null, MessageFormat.format("Guess: {0}    Vidas: {1}",mensaje, vidas));
    }
    public static String getLetter(){
        String letra = JOptionPane.showInputDialog("Escriba una letra :");
        return letra;
    }

    public static boolean buscarLetra(String letra, String palabra){
        String l = letra.toLowerCase();
        String ll = palabra.toLowerCase();
        if (ll.contains(l)){
            return true;
        } else {
            return false;
        }
    }
}