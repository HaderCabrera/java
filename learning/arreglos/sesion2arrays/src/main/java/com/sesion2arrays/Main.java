package com.sesion2arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //
        ArrayList<String> list = new ArrayList<>();
        list.add("Fundamentos");
        list.add("Backend ");
        list.add(0, "Fundamentos");
        list.add("Pasteleria");

        //-----------------------------------
        boolean isEmpty = list.isEmpty();
        System.out.println(isEmpty);
        System.out.println(list);
        //-----------------------------------
        boolean contiene = list.contains("Fundamentos");
        System.out.println("Contiene?" + contiene);
        //-----------------------------------
        int posicion = list.indexOf("Pasteleria");
        System.out.println(posicion);
        //-----------------------------------
        int posicion2 = list.lastIndexOf("Fundamentos");
        System.out.println(posicion2);
        //-----------------------------------
        Object [] skills = list.toArray();
        System.out.println(Arrays.toString(skills));
        //-----------------------------------
        
    }
}