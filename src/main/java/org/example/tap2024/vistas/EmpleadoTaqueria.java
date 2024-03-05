package org.example.tap2024.vistas;

import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.tap2024.modelos.EmpleadosDAO;

public class EmpleadoTaqueria extends Stage {

    private VBox vbxPrincipal;
    private ToolBar tlbMenu;
    private Scene escena;
    private TableView<EmpleadosDAO> tbvEmpleados;
    public EmpleadoTaqueria (){
        CrearUI();
        this.setTitle("Taqueria los Inges");
        this.setScene(escena);
        this.show();
    }

    private void CrearUI() {

    }

}
