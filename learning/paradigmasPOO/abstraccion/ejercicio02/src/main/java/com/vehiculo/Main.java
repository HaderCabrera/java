package com.vehiculo;

public class Main {
    public static void main(String[] args) {
       Vehicle automotor = new Auto("Vitara", "SEDAN", 2000, 5);
       Vehicle moto = new Moto("yamaha", "MT03", 2025, 300);

       System.out.println(moto.describeVehicle());
       System.out.println(automotor.describeVehicle());
    }
}