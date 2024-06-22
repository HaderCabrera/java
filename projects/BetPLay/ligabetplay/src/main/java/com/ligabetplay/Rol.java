package com.ligabetplay;

import java.util.ArrayList;
import java.util.List;

public class Rol {
    private String id;
    private String nombre;
    private List<Permiso> permisos;

    //CONTRUCTOR
    public Rol(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.permisos = new ArrayList<>();
    }
    
    public void agregarPermiso(Permiso permiso) {
        permisos.add(permiso);
    }

    // Getters y setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public List<Permiso> getPermisos() {
        return permisos;
    }
    public void setPermisos(List<Permiso> permisos) {
        this.permisos = permisos;
    }

    public ArrayList<String>  mostrarPermisos() {
        ArrayList<String> permisosG = new ArrayList<String>();
        for (Permiso permiso : permisos) {
            permisosG.add(permiso.getDescripcion());
            System.out.println(permiso.getDescripcion());
        }
        return permisosG;
    }
    
}
