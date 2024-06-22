package com.ligabetplay;

import java.util.ArrayList;
import java.util.List;

public class Permiso {
    private String id;
    private String descripcion;


    //CONTRUCTORS
    public Permiso(String id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }
    
    // Getters y setters
    public  String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }  
}
