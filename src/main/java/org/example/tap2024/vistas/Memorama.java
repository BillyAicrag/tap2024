package org.example.tap2024.vistas;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class Memorama extends Stage {

    private Scene escena;
    public Memorama(){
        this.setTitle("Memorama");
        this.setScene(new Scene(new Button("Da click")));
        this.show();
    }

    private void CrearUI(){
        escena = new Scene(new Button("Da click"));

    }

    private void RevolverCartas() {
        String[] arImagenes = {"memorama1.jpg,memorama2.jpg,memorama3.jpg,memorama4.jpg,memorama5.jpg,memorama6.jpg,memorama7.jpg,memorama8.jpg,memorama9.jpg,memorama10.jpg"};
        Button[][] arBtnCartas = new Button[2][10];

        ImageView imvCarta;
        int posx = 0;
        int posy = 0;
        int cont = 0;
        for(int i = 0; i < arImagenes.length; ) {
            posx = (int) (Math.random() * 2);
            posy = (int) (Math.random() * 10);
            if (arBtnCartas[posx][posy] == null) {
                arBtnCartas[posx][posy] = new Button();
                imvCarta = new ImageView(getClass().getResource("/images/" + arImagenes[i]).toString());
                imvCarta.setFitHeight(150);
                imvCarta.setFitWidth(100);
                arBtnCartas[posx][posy].setGraphic(imvCarta);
                arBtnCartas[posx][posy].setPrefSize(100, 150);
                //gdpJuego.add(arBtnCartas[posx][posy].posy,posx);
                cont++;
                if (cont == 2) {
                    i++;
                    cont = 0;
                }
            }
        }
    }
}
