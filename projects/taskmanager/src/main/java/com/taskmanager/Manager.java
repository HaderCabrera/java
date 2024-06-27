package com.taskmanager;

import java.io.File;

public interface Manager {
    void toDo();
}

class addTask implements Manager {
    private String tarea;
    private File archivo;
    
    public addTask(String tarea, File archivo) {
        this.tarea = tarea;
        this.archivo = archivo;
    }

    @Override
    public void toDo() {
        Addtask.agregar(archivo, tarea);
    }
}

class showTask implements Manager {
    private File archivo;
    
    public showTask(File archivo) {
        this.archivo = archivo;
    }

    @Override
    public void toDo() {
        Showtask.listar(archivo);
    }
}

class findTask implements Manager {
    private String tarea;
    private File archivo;
    
    public findTask(String tarea, File archivo) {
        this.tarea = tarea;
        this.archivo = archivo;
    }

    @Override
    public void toDo() {
        Searchtask.buscar(archivo, tarea);
    }
}

class removeTask implements Manager {
    private File archivo;
    private String tarea;

    public removeTask(File archivo, String tarea) {
        this.archivo = archivo;
        this.tarea = tarea;
    }

    @Override
    public void toDo() {
        Removetask.eliminar(archivo, tarea);
    }
}

