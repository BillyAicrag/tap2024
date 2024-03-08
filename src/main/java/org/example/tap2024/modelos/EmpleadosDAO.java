package org.example.tap2024.modelos;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.Statement;

public class EmpleadosDAO {

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public String getNomEmpleado() {
        return nomEmpleado;
    }

    public String getRfcEmpleado() {
        return rfcEmpleado;
    }

    public float getSalario() {
        return salario;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public void setNomEmpleado(String nomEmpleado) {
        this.nomEmpleado = nomEmpleado;
    }

    public void setRfcEmpleado(String rfcEmpleado) {
        this.rfcEmpleado = rfcEmpleado;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    private int idEmpleado;
    private String  nomEmpleado;
    private String rfcEmpleado;
    private float salario;
    private String telefono;
    private String direccion;

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
