package com.example.varneet381asn1;

import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PaletteView extends Pane {


    Circle c11;
    Circle c12;
    Circle c13;
    ColorPalette myColorPallete;


    public PaletteView(ColorPalette cp){
        HBox root = new HBox();
        c11 = new Circle(40);
        c12 = new Circle(40);
        c13 = new Circle(40);

        if (cp == null){
            myColorPallete = new ColorPalette();
        }else{
            myColorPallete =cp;
        }

        c11.setFill(myColorPallete.colors[0]);
        c12.setFill(myColorPallete.colors[1]);
        c13.setFill(myColorPallete.colors[2]);
        c11.setStroke(Color.BLACK);
        c12.setStroke(Color.BLACK);
        c13.setStroke(Color.BLACK);
        root.getChildren().addAll(c11, c12, c13);
        this.getChildren().add(root);

    }
}
