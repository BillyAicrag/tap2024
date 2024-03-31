package org.example.tap2024.vistas;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.kordamp.bootstrapfx.BootstrapFX;
import org.kordamp.bootstrapfx.scene.layout.Panel;

import java.util.ArrayList;

public class Taqueria extends Stage {
    private Scene escena;
    private Panel pnlPrincipal;
    private BorderPane bdpPrincipal;
    private ToolBar tlbTablas;
    private GridPane gdpPrincipal,gdpCategoria, gdpMesas;
    private VBox vbxIzq,vbxDer,vbxOrden;
    private VBox[] vbxProductos = new VBox[4];
    private HBox[] hbxTacos = new HBox[5];
    private HBox[] hbxTortas = new HBox[5];
    private HBox[] hbxQuesadillas = new HBox[5];
    private HBox[] hbxBebidas = new HBox[5];
    ArrayList<HBox> hbxOrden = new ArrayList<>();
    private HBox hbxCabecera, hbxBoton;
    private Button btnAgregar, btnEliminar, btnMas, btnMenos, btnOrdenar, btnEmpleado, btnProducto, btnOrden, btnCategoria, btnTacos, btnTortas, btnQuesadillas, btnBebidas;
    private Button[] btnMesa = new Button[9];
    private int cotrolcategorias = 0;


    public Taqueria(){
        CrearUI();
        this.setTitle("Taqueria los Inges");
        this.setScene(escena);
        this.show();
    }

    private void CrearUI() {
        /*ImageView imvEmp = new ImageView(getClass().getResource("/images/NewEmployee.png").toString());
        imvEmp.setFitHeight(30);
        imvEmp.setFitWidth(30);
        btnAgregarEmpleado = new Button();
        btnAgregarEmpleado.setOnAction(event -> new EmpleadosForm(tbvEmpleados, null));
        btnAgregarEmpleado.setPrefSize(30, 30);
        btnAgregarEmpleado.setGraphic(imvEmp);
        tlbMenu = new ToolBar(btnAgregarEmpleado);*/
        btnTacos = new Button("Tacos");
        btnTacos.setOnAction(event -> cambiarCategoria(0));
        btnTortas = new Button("Tortas");
        btnTortas.setOnAction(event -> cambiarCategoria(1));
        btnQuesadillas = new Button("Quesadillas");
        btnQuesadillas.setOnAction(event -> cambiarCategoria(2));
        btnBebidas = new Button("Bebidas");
        btnBebidas.setOnAction(event -> cambiarCategoria(3));
        gdpCategoria = new GridPane();
        gdpCategoria.add(btnTacos,0,0);
        gdpCategoria.add(btnTortas,0,1);
        gdpCategoria.add(btnQuesadillas,1,0);
        gdpCategoria.add(btnBebidas,1,1);

        crearHboxes();


        vbxIzq = new VBox(gdpCategoria);




        gdpPrincipal = new GridPane();
        gdpPrincipal.add(gdpCategoria,0,0);


        bdpPrincipal = new BorderPane();
        bdpPrincipal.setTop(tlbTablas);
        bdpPrincipal.setCenter(gdpPrincipal);

        //gdpCategoria.autosize();

        btnEmpleado = new Button();
        btnCategoria = new Button();
        btnProducto = new Button();
        btnOrden = new Button();
        tlbTablas = new ToolBar(btnEmpleado,btnCategoria,btnProducto, btnOrden);
        bdpPrincipal.setTop(tlbTablas);
        bdpPrincipal.setCenter(gdpPrincipal);
        pnlPrincipal = new Panel("Taqueria");
        pnlPrincipal.getStyleClass().add("panel-primary");
        pnlPrincipal.setBody(bdpPrincipal);
        escena = new Scene(pnlPrincipal,700,400);
        escena.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());
    }

    private void crearHboxes() {
        for (int i = 0; i < hbxTacos.length; i++) {
            hbxTacos[i] = new HBox();
        }

        for (int i = 0; i < hbxTortas.length; i++) {
            hbxTortas[i] = new HBox();
        }

        for (int i = 0; i < hbxQuesadillas.length; i++) {
            hbxQuesadillas[i] = new HBox();
        }

        for (int i = 0; i < hbxBebidas.length; i++) {
            hbxBebidas[i] = new HBox();
        }
    }

    private void cambiarCategoria(int i) {

    }
}
