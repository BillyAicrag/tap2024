package org.example.tap2024.modelos;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.Statement;

public class OrdenDAO {
    public int getIdOrden() {
        return idOrden;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public String getFecha() {
        return fecha;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setIdOrden(int idOrden) {
        this.idOrden = idOrden;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setRfcEmpleado(String observaciones) {
        this.observaciones = observaciones;
    }

    private int idOrden,idEmpleado;
    private String  fecha;
    private String observaciones;
    public void insertar(){
        String query = "INSERT INTO Orden(idEmpleado,fecha,observaciones) VALUES(" +idEmpleado+ ",'" +fecha+ "','" +observaciones+ "')";
        try{
            Statement stmt = Conexion.connection.createStatement();
            stmt.executeUpdate(query);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void actualizar(){
        String query = "UPDATE Orden SET idEmpleado=" +idEmpleado+ ",fecha='" +fecha+ "',observaciones='" +observaciones+ "' WHERE idOrden="+idOrden;
        try{
            Statement stmt = Conexion.connection.createStatement();
            stmt.executeUpdate(query);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void eliminar(){
        String query = "DELETE FROM Orden WHERE idOrden=" +idOrden;
        try{
            Statement stmt = Conexion.connection.createStatement();
            stmt.executeUpdate(query);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public ObservableList<OrdenDAO> consultar(){
        ObservableList<OrdenDAO> listaOrd = FXCollections.observableArrayList();
        String query = "SELECT * FROM Orden";
        try{
            OrdenDAO objOrd;
            Statement stmt = Conexion.connection.createStatement();
            ResultSet res = stmt.executeQuery(query);
            while(res.next()){
                objOrd = new OrdenDAO();
                objOrd.idOrden = res.getInt("idOrden");
                objOrd.idEmpleado = res.getInt("idEmpleado");
                objOrd.fecha = res.getString("fecha");
                objOrd.observaciones = res.getString("observaciones");
                listaOrd.add(objOrd);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return listaOrd;
    }
}

