package com.vehiculo;

public class Moto extends Vehicle{
    private int cilindrada;

    public Moto(String marca, String modelo, int año, int cilindrada) {
        super(marca, modelo, año);
        this.cilindrada = cilindrada;
    }

    @Override
    public String describeVehicle(){
        return cilindrada + marca + modelo;
    }
}
