package org.example.tap2024.components;

import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import org.example.tap2024.modelos.EmpleadosDAO;

public class ButtonCell extends TableCell<EmpleadosDAO,String> {
    Button btnCelda;
    int opc;

    public ButtonCell(int opc){
        this.opc = opc;
        String txtButton = (opc == 1) ? "Editar" : "Eliminar";
        btnCelda = new Button(txtButton);
    }

    @Override
    protected void updateItem(String item, boolean empty) {
        super.updateItem(item, empty);
        if(!empty)
            this.setGraphic(btnCelda);
    }
}
