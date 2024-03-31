package org.example.tap2024.modelos;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.Statement;

public class DetOrdenDAO {
    public int getIdOrden() {
        return idOrden;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public int getCantidad() {
        return cantidad;
    }

    public float getPrecio() {
        return precio;
    }

    public void setIdOrden(int idOrden) {
        this.idOrden = idOrden;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    private int idOrden,idEmpleado;
    private int  cantidad;
    private float precio;
    public void insertar(){
        String query = "INSERT INTO DetOrden(idOrden,idEmpleado,cantidad,precio) VALUES(" +idOrden+ "," +idEmpleado+ "," +cantidad+ "," +precio+ ")";
        try{
            Statement stmt = Conexion.connection.createStatement();
            stmt.executeUpdate(query);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void actualizar(){
        String query = "UPDATE DetOrden SET idOrden=" +idOrden+ ",idEmpleado=" +idEmpleado+ ",cantidad=" +cantidad+ ",precio=" +precio+ " WHERE idOrden="+idOrden+ " AND idEmpleado="+ idEmpleado;
        try{
            Statement stmt = Conexion.connection.createStatement();
            stmt.executeUpdate(query);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void eliminar(){
        String query = "DELETE FROM DetOrden WHERE idOrden=" +idOrden+ " AND idEmpleado=" +idEmpleado;
        try{
            Statement stmt = Conexion.connection.createStatement();
            stmt.executeUpdate(query);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public ObservableList<DetOrdenDAO> consultar(){
        ObservableList<DetOrdenDAO> listaDet = FXCollections.observableArrayList();
        String query = "SELECT * FROM DetOrden";
        try{
            DetOrdenDAO objDet;
            Statement stmt = Conexion.connection.createStatement();
            ResultSet res = stmt.executeQuery(query);
            while(res.next()){
                objDet = new DetOrdenDAO();
                objDet.idOrden = res.getInt("idOrden");
                objDet.idEmpleado = res.getInt("idEmpleado");
                objDet.cantidad = res.getInt("cantidad");
                objDet.precio = res.getFloat("precio");
                listaDet.add(objDet);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return listaDet;
    }
}


