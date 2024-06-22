package com.ahorcado;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        // Declaracion de variables
        boolean flag = true;
        //int vidas = 3;
        boolean dead = true;
        String pala = "";

        // Creamos el array
        ArrayList<String> letters = new ArrayList<String>();
        ArrayList<String> lett = new ArrayList<String>();

        // Agregamos palabras al array
        letters.add("Hola");
        letters.add("Mundo");
        letters.add("Java");
        letters.add("ArrayList");
        letters.add("String");
        letters.add("Ejemplo");
        letters.add("Programacion");
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
                    // Moviendo varables para que pueda seguir jugando
                    int vidas = 3;

                    //Eleginar palabra aleatoria del array
                    Random rand = new Random();
                    int indiceAleatorio = rand.nextInt(letters.size());
                    String palabraAleatoria = letters.get(indiceAleatorio);
                    System.out.println(palabraAleatoria);
                    // MENSAJE INICIAL
                    String mensaje = "";
                    for(int i = 0; i < palabraAleatoria.length(); i++ ) {
                        mensaje += "__" + " "; 
                    }
                    JOptionPane.showMessageDialog(null, MessageFormat.format("Guess: {0}    Vidas: {1}",mensaje, vidas));
                    // BUSQUEDA DE LETRAS
                    do {
                        String letter = getLetter();
                        boolean exists = buscarLetra(letter, palabraAleatoria);
                        if (!exists) {
                            vidas --;
                            JOptionPane.showMessageDialog(null, "¡Has perdido una vida!");
                            System.out.println(lett);
                            drawMessage(palabraAleatoria, vidas, lett);
                            if (vidas < 1){
                                JOptionPane.showMessageDialog(null, "No te quedan mas vidas, try again!");
                                lett.clear();
                                //dead = false;
                                break;
                            }
                        } else {
                            String palabraAleatoriaa = palabraAleatoria.toLowerCase();
                            String letterr = letter.toLowerCase();
                                if(palabraAleatoriaa.contains(letterr)) {
                                    lett.add(letterr);
                                    drawMessage(palabraAleatoria, vidas, lett);
                                    pala = recortaLetra(palabraAleatoriaa, lett);
                                    if (pala.length() <= 0) {
                                        JOptionPane.showMessageDialog(null, MessageFormat.format("La suerte te acompaña. Palabra: {0}", palabraAleatoria));
                                        lett.clear();    
                                        break;
                                    }
                                }
                        }
                        System.out.println(pala);
                        System.out.println("SALGO Y PIDO LETRA DE NUEVO");
                    } while(dead);
                    break;
                case "salir":
                    System.out.println("Chaito");
                    flag = false;
                    break;
                default:
                    System.out.println("Valor ingresado no valido.");
                    flag = false;
                    break;
            }
        }
    }

    public static void drawMessage(String palabraAleatoria, int vidas, ArrayList<String> correctas){
        // Arrays para la palabra y la palabra en curso
        ArrayList<Character> adivinar = new ArrayList<Character>();
        ArrayList<Character> adivinando = new ArrayList<Character>();
        // Crear mensaje para el popAp
        String mensaje = "";

        for(int i = 0; i < palabraAleatoria.length(); i++ ) {
            adivinando.add('_');
            adivinar.add(palabraAleatoria.charAt(i)); 
        }
        for(int i = 0; i < adivinar.size(); i++){
            Character letraaa = adivinar.get(i);
            if(correctas.contains(letraaa.toString().toLowerCase())){
                adivinando.set(i, letraaa);
            }
        }
        for(int p = 0; p < adivinando.size(); p++) {
            mensaje += adivinando.get(p);
            mensaje += " ";
        }
        JOptionPane.showMessageDialog(null, MessageFormat.format("Guess: {0} Vidas: {1}",mensaje, vidas));

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

    public static String recortaLetra(String pala, ArrayList<String> letras){
        for(String item: letras){
            pala = pala.replace(item, "");
        }
        return pala;
    }
}