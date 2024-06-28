package com.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;



public class Products {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/Products";
        String user = "campus2023";
        String password = "campus2023";

        try {
            Connection connection = DriverManager.getConnection(url,user, password);
            System.out.println("Conexion exitosa!"); 
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        // try(Connection connection = DriverManager.getConnection(url, user, password);
        // Statement statement = connection.createStatement()) {
        // //CREACION DE TABLA
        //     String createTableSQL = "CREATE TABLE IF NOT EXISTS inventario (" +
        //                             "id INT PRIMARY KEY AUTO_INCREMENT," +
        //                             "name VARCHAR(50));";
        //     statement.execute(createTableSQL);
        //     System.out.println("Tabla creada!");
        //}
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();
            // //CREACION de tabla
            // String createTableSQL = "CREATE TABLE IF NOT EXISTS existencias (" +
            //                         "id INT PRIMARY KEY AUTO_INCREMENT," +
            //                         "name VARCHAR(50));";
            // statement.execute(createTableSQL);
            // System.out.println("Tabla creada!");

            //INSESION de datos
            // String query = "INSERT INTO inventario(name) VALUES" +
            // "('Pinturas')," +
            // "('Herramientas');";
            // statement.executeUpdate(query);
            // System.out.println("Categoria registrada");
            
            // CONSULTAS
            // String query = "SELECT id, name FROM inventario;";
            // ResultSet rs = statement.executeQuery(query);
            // while (rs.next()) {
            //     int id = rs.getInt("id");
            //     String name = rs.getString("name");
            //     System.out.println(MessageFormat.format("Id: {0}, Name: {1}", id, name));
            // }

            //ACTUALIZACION de datos
            // String updateSQL = "UPDATE inventario SET name = 'Grifos' WHERE id = 1;";
            // int rowsUpdate = statement.executeUpdate(updateSQL);
            // System.out.println("Numero de filas actualizadas: "+ rowsUpdate);

            //DELETE registros
            String deleteSQL = "DELETE from inventario  WHERE id = 1;";
            int rowsUpdate = statement.executeUpdate(deleteSQL);
            System.out.println("Numero de filas eliminadas: "+ rowsUpdate);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}