package org.example.tap2024.modelos;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.Statement;

public class CategoriasDAO {
    public int getIdCategoria() {
        return idCategoria;
    }

    public String getNomCategoria() {
        return nomCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public void setNomCategoria(String nomCategoria) {
        this.nomCategoria = nomCategoria;
    }

    private int idCategoria;
    private String  nomCategoria;

    public void insertar(){
        String query = "INSERT INTO Categorias(nomCategoria) VALUES('" +nomCategoria+ "')";
        try{
            Statement stmt = Conexion.connection.createStatement();
            stmt.executeUpdate(query);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void actualizar(){
        String query = "UPDATE Categorias SET nomCategoria='" +nomCategoria+ "' WHERE idCategoria="+idCategoria;
        try{
            Statement stmt = Conexion.connection.createStatement();
            stmt.executeUpdate(query);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void eliminar(){
        String query = "DELETE FROM Categorias WHERE idCategoria=" +idCategoria;
        try{
            Statement stmt = Conexion.connection.createStatement();
            stmt.executeUpdate(query);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public ObservableList<CategoriasDAO> consultar(){
        ObservableList<CategoriasDAO> listaCat = FXCollections.observableArrayList();
        String query = "SELECT * FROM Categorias";
        try{
            CategoriasDAO objCat;
            Statement stmt = Conexion.connection.createStatement();
            ResultSet res = stmt.executeQuery(query);
            while(res.next()){
                objCat = new CategoriasDAO();
                objCat.idCategoria = res.getInt("idCategoria");
                objCat.nomCategoria = res.getString("nomCategoria");
                listaCat.add(objCat);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return listaCat;
    }
}
