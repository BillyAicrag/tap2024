package org.example.tap2024.modelos;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    static private String DB = "Taqueria";
    static private String USER = "adminTacos";
    static private String PWD = "1234";
    static public Connection connection;
    public static void crearConexion(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + DB + "?allowPublicKeyRetrieval=true&useSSL=false",USER,PWD);
            System.out.print("Conexión establecida");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
