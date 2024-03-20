package org.example.tap2024.components;

import javafx.scene.control.*;
import org.example.tap2024.modelos.EmpleadosDAO;
import org.example.tap2024.vistas.EmpleadosForm;

import java.util.Optional;

public class ButtonCell extends TableCell<EmpleadosDAO,String> {
    Button btnCelda;
    int opc;
    EmpleadosDAO objEmp;

    public ButtonCell(int opc){
        this.opc = opc;
        String txtButton = (opc == 1) ? "Editar" : "Eliminar";
        btnCelda = new Button(txtButton);
        btnCelda.setOnAction(event -> accionBoton(opc));
    }

    private void accionBoton(int opc) {
        TableView<EmpleadosDAO> tbvEmpleados = ButtonCell.this.getTableView();
        objEmp = tbvEmpleados.getItems().get(ButtonCell.this.getIndex());
        if (opc == 1) {
            //Código de Editar
            new EmpleadosForm(tbvEmpleados, objEmp);
        } else {
            //Código de Eliminar
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Mensaje del Sistema");
            alert.setHeaderText("Confirmación de acción");
            alert.setContentText("¿Deseas borrar al Empleado " + objEmp.getNomEmpleado() + "?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK){
                objEmp.eliminar();
                tbvEmpleados.setItems(objEmp.consultar());
                tbvEmpleados.refresh();
            }
        }
    }

    @Override
    protected void updateItem(String item, boolean empty) {
        super.updateItem(item, empty);
        if(!empty)
            this.setGraphic(btnCelda);
    }
}
