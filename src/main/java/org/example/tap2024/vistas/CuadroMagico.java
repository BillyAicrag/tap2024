package org.example.tap2024.vistas;
//git pull es solo para uso de manera colaborativa
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class CuadroMagico extends Stage {

    private Scene escena;
    public CuadroMagico(){
        this.setTitle("Cuadro Mágico");
        this.setScene(new Scene(new Button("Da click")));
        this.show();
    }

    private void CrearUI(){
        escena = new Scene(new Button("Da click"));

    }
}
