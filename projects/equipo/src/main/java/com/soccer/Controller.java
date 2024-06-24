package com.soccer;

import java.util.Enumeration;
import java.util.Hashtable;

import com.soccer.model.entity.Team;

public class Controller {
    public Hashtable <Integer,Team> equipos = new Hashtable<>();
    
    public Team  getTeam(Integer llave){
        Team foundTeam = equipos.get(llave);
        return foundTeam;
    } 

    public void listarEquipo(Integer key){
        //System.out.println("Nuevo nombre: " + equipos.get(key).getNombre());
        //System.out.println("Nueva ciudad: " + equipos.get(key).getCiudad());
    }
    // Para poder saber las claves que se asignaron al Hashtable
    public void getKeys(){
        Enumeration<Integer> llaves = equipos.keys();
        while (llaves.hasMoreElements()) {
            Integer key = llaves.nextElement();
            System.out.println("Llave: " + key);
        }
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

}
