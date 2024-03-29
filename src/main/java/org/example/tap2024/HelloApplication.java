package org.example.tap2024;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.example.tap2024.components.Hilo;
import org.example.tap2024.modelos.Conexion;
import org.example.tap2024.vistas.Calculadora;
import org.example.tap2024.vistas.EmpleadoTaqueria;
import org.example.tap2024.vistas.Pista;

import java.io.IOException;

public class HelloApplication extends Application {

    private MenuBar mnbPrincipal;
    private Menu menParcial1, menParcial2, menSalir;
    private MenuItem mitCalculadora, mitSalir, mitEmpleado, mitPista;
    private BorderPane bdpPanel;
    @Override
    public void start(Stage stage) throws IOException {
        CrearMenu();
        //FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        //Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        bdpPanel = new BorderPane();
        bdpPanel.setTop(mnbPrincipal);
        Scene scene = new Scene(bdpPanel);
        scene.getStylesheets().add(getClass().getResource("/estilos/main.css").toString());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
        stage.setMaximized(true);

        Conexion.crearConexion();
    }

    private void CrearMenu() {

        /* Menu primer parcial */
        mitCalculadora = new MenuItem("Calculadora");
        mitCalculadora.setOnAction(event -> new Calculadora());

        mitEmpleado = new MenuItem("Empleado Taqueria");
        mitEmpleado.setOnAction(event -> new EmpleadoTaqueria());

        menParcial1 = new Menu("Primer Parcial");
        menParcial1.getItems().addAll(mitCalculadora,mitEmpleado);

        /* Menu segundo parcial */
        mitPista = new MenuItem("Manejo de Hilos");
        mitPista.setOnAction(event -> new Pista());

        menParcial2 = new Menu("Segundo Parcial");
        menParcial2.getItems().add(mitPista);

        /* Menu salir */
        mitSalir = new MenuItem("Salir");
        menSalir = new Menu("Salir");
        menSalir.getItems().add(mitSalir);
        menSalir.setOnAction(event -> System.exit(0));

        mnbPrincipal = new MenuBar();
        mnbPrincipal.getMenus().addAll(menParcial1,menParcial2,menSalir);

    }

    public static void main(String[] args) {
        launch();
    }
}