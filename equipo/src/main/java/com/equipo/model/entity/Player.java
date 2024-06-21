package com.equipo.model.entity;

public class Player extends Person{
    private int dorsal;
    private String posicion;
    public Player(){
        super();
    }
    public Player(int dorsal, String posicion) {
        this.dorsal = dorsal;
        this.posicion = posicion;
    }
    public Player(int id, String nombre, String apellido, int edad, int dorsal, String posicion) {
        super(id, nombre, apellido, edad);
        this.dorsal = dorsal;
        this.posicion = posicion;
    }
}
