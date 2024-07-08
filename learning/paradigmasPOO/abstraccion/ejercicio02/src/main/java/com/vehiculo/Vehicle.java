package com.vehiculo;

public abstract class Vehicle {
    protected String marca;
    protected String modelo;
    private int año;
    public Vehicle(String marca, String modelo, int año) {
        this.marca = marca;
        this.modelo = modelo;
        this.año = año;
    }
    
    public Vehicle() {
    }

    public abstract String describeVehicle();
}
