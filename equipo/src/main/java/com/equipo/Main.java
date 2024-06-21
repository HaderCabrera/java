package com.equipo;

import com.equipo.model.entity.Player;
import com.equipo.model.entity.Team;

public class Main {
    public static void main(String[] args) {
        Controller ctrlTeams = new Controller();
        Team equipo = new Team();

        equipo.setNombre("Bucaros");
        equipo.setCiudad("Bucaramanga");
        Player jugador = new Player(1, "Pepito", "Juanito", 23, 12, "Medio");
        equipo.setLstJugadores(jugador);

        ctrlTeams.equipos.put("001", equipo);

        equipo = ctrlTeams.equipos.get("001");
        System.out.println("Mi equipo" + equipo.getNombre());
        System.out.println("JUgador" + equipo.getLstJugadores().get(0).getNombre());
    }
}