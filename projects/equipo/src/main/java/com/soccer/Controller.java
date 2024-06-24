package com.soccer;

import java.text.MessageFormat;
import java.util.Hashtable;

import com.soccer.model.entity.Player;
import com.soccer.model.entity.Team;

public class Controller {
    public Hashtable <Integer,Team> equipos = new Hashtable<>();
    public Hashtable <Integer, Player> players = new Hashtable<>();
    
    public Team  getTeam(Integer llave){
        Team foundTeam = equipos.get(llave);
        return foundTeam;
    } 

    public Integer findKeyEquipo(String nameEquipo){
        for (Integer key : equipos.keySet()) {
            if (equipos.get(key).getNombre().equals(nameEquipo)) {
                return key;
            }
        }
        return null;
    }

    public boolean checkExistence(Integer key){
        Team foundTeam = equipos.get(key);
        if(foundTeam == null) {
            return false;
        } else {
            return true;
        }
    }

    public void setNombre(Integer key, String newName) {
        Team modifiedTeam = equipos.get(key);
        if (modifiedTeam != null) {
            modifiedTeam.setNombre(newName);
        }
    }

    public void setCity(Integer key, String newCity){
        Team modifiedTeam = equipos.get(key);
        if (modifiedTeam != null) {
            modifiedTeam.setCiudad(newCity);;
        }   
    }

    public String getNombre(Integer key){
        String p =  equipos.get(key).getNombre();
        if(p == null) {
            return "Hellou";
        } else {
            return p;
        }
    }

    public void removeTeam(Integer key){
        Team teamRemove = new Team();
        String nombre = equipos.get(key).getNombre();
        teamRemove = equipos.remove(key);
        if (teamRemove != null) {
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
            System.out.println(MessageFormat.format("Team {0} has been remove succesfully.", nombre.toUpperCase() ));
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"); 
        }
    }

    public void showTeams(){
        System.out.println("==============================================");
        equipos.values().forEach(team -> {
            System.out.println("\tName:   \t" + team.getNombre());
            System.out.println("\tCity:   \t" + team.getCiudad());
            System.out.println("\tJugadores: \t" + team.getLstJugadores());
            System.out.println("\tTrainers: \t" + team.getLstEntrenadores());
            System.out.println("\tDoctors: \t" + team.getLstMasajistas());
            System.out.println("______________________________________________");
        });
        System.out.println("==============================================");
    }

}
