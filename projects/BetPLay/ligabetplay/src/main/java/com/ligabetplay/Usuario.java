package com.ligabetplay;

public class Usuario extends Persona {
    private String email;
    private String password;
    private Rol rol;

    // Contructors 
    public Usuario(String id, String nombre, String email, String password, Rol rol) {
        super(id, nombre);
        this.email = email;
        this.password = password;
        this.rol = rol;
    }

    // Getters y setters
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Rol getRol() {
        return rol;
    }
    public void setRol(Rol rol) {
        this.rol = rol;
    } 
    
    public void acceder() {
        switch (rol.getNombre()) {
            case "Administrador":
                System.out.println("Acceso total como administrador.");
                break;
            case "Tecnico":
                System.out.println("Acceso limitado como tecnico.");
                break;
            default:
                System.out.println("Rol no reconocido.");
                break;
        }
    }
}
