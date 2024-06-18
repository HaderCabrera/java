package com.poo;

public class Main {
    // public static void main(String[] args) {
    //     //Main principal = new Main(); //Crear instancia
    //     //System.out.println(principal.suma(4,7));
    //     System.out.println(suma(4,7));
    // }
    // //public int suma(int a, int b) {
    // public static int suma(int a, int b) {
    //     return a+b;
    // }

    // Cree un objeto de la clase Estudiante
    public static void main(String[] args) {
        Estudiante myStudent = new Estudiante();
        myStudent.setNombre("Hader");
        myStudent.setApellido("Cabrera");
        myStudent.setEdad(27);
    
        System.out.println(myStudent.getNombre());
    }

}