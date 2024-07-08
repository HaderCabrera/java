package com.vehiculo;

public class Auto extends Vehicle{
    private int puertas;

    public Auto(String marca, String modelo, int año, int puertas) {
        super(marca, modelo, año);
        this.puertas = puertas;
    }
    

    public Auto(int puertas) {
        this.puertas = puertas;
    }

    @Override
    public String describeVehicle(){
        String description;
        description = puertas + marca + modelo ;
        return description;
    }
}
