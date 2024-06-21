//trainerleader REPO JHOLVER

package com.equipo.model.entity;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String nombre;
    private String ciudad;
    private List<Player> lstJugadores;
    private List<Coach> lsTEntrenadores;
    private List<Doctor> lstMasajistas;
    public Team() {
        lstJugadores = new ArrayList<Player>();
        lsTEntrenadores = new ArrayList<Coach>();
        lstMasajistas = new ArrayList<Doctor>();
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getCiudad() {
        return ciudad;
    }
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    public List<Player> getLstJugadores() {
        return lstJugadores;
    }
    public void setLstJugadores(Player player) {
        this.lstJugadores.add(player);
    }
    public List<Coach> getLsTEntrenadores() {
        return lsTEntrenadores;
    }
    public void setLsTEntrenadores(Coach coach) {
        this.lsTEntrenadores.add(coach);
    }
    public List<Doctor> getLstMasajistas() {
        return lstMasajistas;
    }
    public void setLstMasajistas(Doctor doctor) {
        this.lstMasajistas.add(doctor);
    }
    
}
