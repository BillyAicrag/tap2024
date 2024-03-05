package org.example.tap2024.modelos;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.Statement;

public class EmpleadosDAO {
    int idEmpleado;
    String nomEmpleado;
    String rfcEmpleado;
    float salario;
    String telefono;
    String direccion;

    public void insertar(){
        String query = "INSERT INTO Empleado(nomEmpleado,rfcEmpleado,salario,telefono,direccion) VALUES('" +nomEmpleado+ "','" +rfcEmpleado+ "'," +salario+ ",'" +telefono+ "','" +direccion+ "')";
        try{
            Statement stmt = Conexion.connection.createStatement();
            stmt.executeUpdate(query);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void actualizar(){
        String query = "UPDATE Empleado SET nomEmpleado='" +nomEmpleado+ "',rfcEmpleado='" +rfcEmpleado+ "',salario=" +salario+ ",telefono='" +telefono+ "',direccion='" +direccion+ "' WHERE idEmpleado="+idEmpleado;
        try{
            Statement stmt = Conexion.connection.createStatement();
            stmt.executeUpdate(query);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void eliminar(){
        String query = "DELETE FROM Empleado WHERE idEmpleado=" +idEmpleado;
        try{
            Statement stmt = Conexion.connection.createStatement();
            stmt.executeUpdate(query);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public ObservableList<EmpleadosDAO> consultar(){
        ObservableList<EmpleadosDAO> listaEmp = FXCollections.observableArrayList();
        String query = "SELECT * FROM Empleado";
        try{
            EmpleadosDAO objEmp;
            Statement stmt = Conexion.connection.createStatement();
            ResultSet res = stmt.executeQuery(query);
            while(res.next()){
                objEmp = new EmpleadosDAO();
                objEmp.idEmpleado = res.getInt("idEmpleado");
                objEmp.nomEmpleado = res.getString("nomEmpleado");
                objEmp.rfcEmpleado = res.getString("rfcEmpleado");
                objEmp.salario = res.getFloat("salario");
                objEmp.telefono = res.getString("telefono");
                objEmp.direccion = res.getString("direccion");
                listaEmp.add(objEmp);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return listaEmp;
    }
}
