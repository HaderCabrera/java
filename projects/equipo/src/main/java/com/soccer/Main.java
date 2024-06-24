package com.soccer;

import java.util.Hashtable;


import com.soccer.model.entity.Team;
import com.soccer.view.viewTeam;

import java.util.concurrent.ThreadLocalRandom;
public class Main {
    public static void main(String[] args) {
        Controller ctrlTeams = new Controller();
        viewTeam.controlador = ctrlTeams;
        viewTeam vt = new viewTeam();
        vt.start(); 

    }

    public static int generateUniqueKey(Hashtable<Integer, Team> hashtable){
        do {
            int randomInt = ThreadLocalRandom.current().nextInt(0, 100);
            if(!hashtable.containsKey(randomInt)) {
                return randomInt;
            }
        } while (true);
    }

}