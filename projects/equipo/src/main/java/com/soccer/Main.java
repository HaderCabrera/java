package com.soccer;

import java.util.Hashtable;
import java.util.Random;

import com.soccer.model.entity.Team;
import com.soccer.view.viewTeam;

public class Main {
    public static void main(String[] args) {
        Controller ctrlTeams = new Controller();
        viewTeam.controlador = ctrlTeams;
        viewTeam vt = new viewTeam();
        vt.start(); 

    }

    public static int generateUniqueKey(Hashtable<Integer, Team> hashtable){
        Random random = new Random();
        int key;
        do {
            key =  random.nextInt(1000);
            if(!hashtable.containsKey(key)) {
                return key;
            }
        } while (true);
    }

}