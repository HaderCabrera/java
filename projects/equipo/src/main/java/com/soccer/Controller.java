package com.soccer;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import com.soccer.model.entity.Player;
import com.soccer.model.entity.Team;

public class Controller {
    public Hashtable <Integer,Team> equipos = new Hashtable<>();
    public Hashtable <Integer, Player> players = new Hashtable<>();
    
    //TODOS LOS METODOS QUE LLAMO DESDE VISTA-TEAM
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
                modifiedTeam.setNombre(newName);
        }

        public void setCity(Integer key, String newCity){
            Team modifiedTeam = equipos.get(key);
            if (modifiedTeam != null) {
                modifiedTeam.setCiudad(newCity);
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
            ArrayList<String> playersList = new ArrayList<>();
            for (Team valor : equipos.values()) {
                
                for (Player jugador : valor.getLstJugadores()) {
                    playersList.add(jugador.getNombre());
                }
                System.out.println("==============================================");
                System.out.println("\tName:   \t" + valor.getNombre());
                System.out.println("\tCity:   \t" + valor.getCiudad());
                System.out.println("\tJugadores: \t" + playersList);
                System.out.println("\tTrainers: \t" + valor.getLstEntrenadores());
                System.out.println("\tDoctors: \t" + valor.getLstMasajistas());
                System.out.println("______________________________________________");
                System.out.println("==============================================");
                playersList.clear();
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


    //TODOS LOS METODOS QUE LLAMO DE VISTA-PLAYER
        public void setNombreP(Integer key, String newName) {
            Player modifiedPlayer = players.get(key);
            if (modifiedPlayer != null) {
                modifiedPlayer.setNombre(newName);
            }
        }
        public boolean checkExistenceP(Integer key){
            Player foundPlayer = players.get(key);
            if(foundPlayer == null) {
                return false;
            } else {
                return true;
            }
        }
        public Integer findKeyPlayer(String namePlayer){
            for (Integer key : players.keySet()) {
                if (players.get(key).getNombre().equals(namePlayer)) {
                    return key;
                }
            }
            return null;
        }
        public String getNombreP(Integer key){
            String p =  players.get(key).getNombre();
            if(p == null) {
                return "Hellou";
            } else {
                return p;
            }
        }
        public void setApellidoP(Integer key, String newApellido){
            Player modifiedPlayer = players.get(key);
            if (modifiedPlayer != null) {
                modifiedPlayer.setApellido(newApellido);
            }
        }
        public void setAgeP(Integer key, Integer newAge){
            Player modifiedPlayer = players.get(key);
            if (modifiedPlayer != null) {
                modifiedPlayer.setEdad(newAge);
            }
        }
        public void setDorsalP(Integer key, Integer newDorsal){
            Player modifiedPlayer = players.get(key);
            if (modifiedPlayer != null) {
                modifiedPlayer.setDorsal(newDorsal);
            }  
        }
        public void setPositionP(Integer key, String newPosition){
            Player modifiedPlayer = players.get(key);
            if (modifiedPlayer != null) {
                modifiedPlayer.setPosicion(newPosition);
            }  
        }
        public void removePlayer(Integer key){
            Player playerRemove = new Player();
            String nombre = players.get(key).getNombre();
            playerRemove = players.remove(key);
            if (playerRemove != null) {
                System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                System.out.println(MessageFormat.format("Player {0} has been removed succesfully.", nombre.toUpperCase() ));
                System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"); 
            }
        }
        public void showPlayers(){
            System.out.println("==============================================");
            players.values().forEach(player -> {
                System.out.println("\tName:   \t" + player.getNombre());
                System.out.println("\tLast Name:   \t" + player.getApellido());
                System.out.println("\tAge: \t" + player.getEdad());
                System.out.println("\tPosition: \t" + player.getPosicion());
                System.out.println("\tDorsal: \t" + player.getDorsal());
                System.out.println("______________________________________________");
            });
            System.out.println("==============================================");
        }
    ////////////////////////////////////////////////////////////////
    public Integer buscarEquipoPlayer(String namePlayerP) {
        // Verificar si 'equipos' está vacío antes de iterar
        if (!equipos.isEmpty()) {
            for (Integer llave : equipos.keySet()) {
                for (Team equipo : equipos.values()) {
                    int sumador = 0;
                    System.out.println("EQUIPOS BUCANDO...." + equipo.getNombre());
                    for (Player jugador : equipo.getLstJugadores()) {
                        System.out.println("CANTIDAD DE JUGADORES DENTRO DE LA LISTAÇ:" + equipo.getLstJugadores().size());
                        System.out.println("JUGADOR BUCANDO...." + equipo.getLstJugadores().get(sumador));
                        sumador ++;
                        if (jugador.getNombre().equals(namePlayerP)) {
                            // Se encontró el jugador, retornar la llave
                            return llave;
                        } else {
                            System.out.println("NO ENCONTRE NADA");
                        }
                    }
                }
            }
            // Si no se encontró ningún jugador con el nombre especificado
            System.out.println("No se encontró ninguna llave para el jugador '" + namePlayerP + "'.");
            return null;
        } else {
            System.out.println("El Hashtable 'equipos' está vacío.");
            return null;
        }
    }
    
        public void eliminarPlayerTeam(Integer llaveTeam) {
            System.out.println("asd");
        }
}

