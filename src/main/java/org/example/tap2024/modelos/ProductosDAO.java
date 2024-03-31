package org.example.tap2024.modelos;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.Statement;

public class ProductosDAO {
    public int getIdProducto() {
        return idProducto;
    }

    public String getNomProducto() {
        return nomProducto;
    }

    public float getPrecio() {
        return precio;
    }

    public float getCosto() { return costo; }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public void setNomProducto(String nomProducto) {
        this.nomProducto = nomProducto;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    private int idProducto;
    private String  nomProducto;
    private float precio;
    private float costo;
    private int idCategoria;

    public void insertar(){
        String query = "INSERT INTO Producto(nomProducto,precio,costo,idCategoria) VALUES('" +nomProducto+ "'," +precio+ "," +costo+ "," +idCategoria+ ")";
        try{
            Statement stmt = Conexion.connection.createStatement();
            stmt.executeUpdate(query);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void actualizar(){
        String query = "UPDATE Producto SET nomProducto='" +nomProducto+ "',precio=" +precio+ ",costo=" +costo+ ",idCategoria=" +idCategoria+ " WHERE idProducto="+idProducto;
        try{
            Statement stmt = Conexion.connection.createStatement();
            stmt.executeUpdate(query);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void eliminar(){
        String query = "DELETE FROM Producto WHERE idProducto=" +idProducto;
        try{
            Statement stmt = Conexion.connection.createStatement();
            stmt.executeUpdate(query);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public ObservableList<ProductosDAO> consultar(){
        ObservableList<ProductosDAO> listaPro = FXCollections.observableArrayList();
        String query = "SELECT * FROM Producto";
        try{
            ProductosDAO objPro;
            Statement stmt = Conexion.connection.createStatement();
            ResultSet res = stmt.executeQuery(query);
            while(res.next()){
                objPro = new ProductosDAO();
                objPro.idProducto = res.getInt("idProducto");
                objPro.nomProducto = res.getString("nomProducto");
                objPro.precio = res.getFloat("precio");
                objPro.costo = res.getFloat("costo");
                objPro.idCategoria = res.getInt("idCategoria");
                listaPro.add(objPro);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return listaPro;
    }
}

