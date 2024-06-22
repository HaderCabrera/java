package com.equipo.model.entity;

public class Coach extends Person{
    private int idFederacion;

    public Coach(){
        super();
    }

    public Coach(int idFederacion) {
        this.idFederacion = idFederacion;
    }

    public Coach(int id, String nombre, String apellido, int edad, int idFederacion) {
        super(id, nombre, apellido, edad);
        this.idFederacion = idFederacion;
    }
    
}
