package com.ligabetplay;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {

        //Creamos permisos
        Permiso permiso1 = new Permiso("1", "Agregar jugador");
        Permiso permiso2 = new Permiso("2", "Editar jugador");
        Permiso permiso3 = new Permiso("3", "Eliminar jugador");
        Permiso permiso4 = new Permiso("4", "probando");
        
        //Creamos roles y asignamos permisos
        Rol admin = new Rol("1", "Administrador");
        admin.agregarPermiso(permiso1);
        admin.agregarPermiso(permiso2);
        admin.agregarPermiso(permiso3);
        admin.agregarPermiso(permiso4);


        Rol tecnico = new Rol("2", "Tecnico");
        tecnico.agregarPermiso(permiso2);
        tecnico.agregarPermiso(permiso1);

        //Creamos usuarios y asignamos roles
        Usuario usuario1 = new Usuario("1","Hader","hader.cabrera96@gmail.com","hader123", admin);
        Usuario usuario2 = new Usuario("2","Elkin","Elkin.campus@gmail.com","elkin123", tecnico);

        //Recorrer usuarios/roles/permisos
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        usuarios.add(usuario1);
        usuarios.add(usuario2);

        ArrayList<Rol> roles = new ArrayList<Rol>();
        roles.add(admin);
        roles.add(tecnico);

        ArrayList<Permiso> permisos = new ArrayList<Permiso>();
        permisos.add(permiso1);
        permisos.add(permiso2);
        permisos.add(permiso3);

        for(Usuario usuario : usuarios) {
            System.out.println(usuario.getNombre());
        }


        // Menu de inicio
        String[] options = {admin.getNombre(), tecnico.getNombre()};
        Object defaultOption = options[0];
        // Mostrar el cuadro de diálogo y obtener la selección del usuario
        Object opcion = JOptionPane.showInputDialog(null, "Acceder como:", "betPLay",
        JOptionPane.QUESTION_MESSAGE,null,options,defaultOption);
        String select = "" + opcion;

        ArrayList<String> permisosS = new ArrayList<String>();
        ArrayList<String> permisosAl = new ArrayList<String>();
        ArrayList<String> permisosAlA = new ArrayList<String>();
        switch (select) {
            case "Administrador":
                permisosS = admin.mostrarPermisos();
                // Menu de inicio
                for(int i = 0; i < permisosS.size(); i++) {
                    permisosAlA.add(permisosS.get(i));
                }
                String[] optionsAdm = permisosAlA.toArray(new String[permisosAlA.size()]);
                Object defaultOptionAdm = optionsAdm[0];
                // Mostrar el cuadro de diálogo y obtener la selección del usuario
                Object opcionAdm = JOptionPane.showInputDialog(null, "Elija una gestion:", "betPLay",
                JOptionPane.QUESTION_MESSAGE,null,optionsAdm,defaultOptionAdm);
                String selectAdm = "" + opcionAdm;
                switch (selectAdm) {
                    case "Agregar jugador":
                        System.out.println("Administrador AGREGANDO");
                        break;
                    case "Editar jugador":
                        System.out.println("Administrador EDITANDO");
                        break;  
                    case "Eliminar jugador":
                        System.out.println("Administrador ELIMINANDO");
                        break;              
                    default:
                        break;
                }                
                break;
            case "Tecnico":
                //TOMAR PERMISOS DE LA INSTANCIA Y AGREGARLOS EN PANE
                permisosS = tecnico.mostrarPermisos();
                for(int i = 0; i < permisosS.size(); i++) {
                    permisosAl.add(permisosS.get(i));
                }
                // Convertir ArrayList a String[]
                String[] stringArrayPermisos = permisosAl.toArray(new String[permisosAl.size()]);
                // Menu de inicio
                Object defaultOptionTec = stringArrayPermisos[0];
                // Mostrar el cuadro de diálogo y obtener la selección del usuario
                Object opcionTec = JOptionPane.showInputDialog(null, "Elija una gestion:", "betPLay", JOptionPane.QUESTION_MESSAGE,null,stringArrayPermisos,defaultOptionTec);
                String selectTec = "" + opcionTec;
                switch (selectTec) {
                    case "Editar jugador":
                        System.out.println("TECNICO EDITANDO");
                        break;
                    case "Agregar jugador":
                        System.out.println("TECNICO AGREGANDO"); 
                        break;
                
                    default:
                        break;
                }                 
                break;
            default:
                break;
        }
    }
}