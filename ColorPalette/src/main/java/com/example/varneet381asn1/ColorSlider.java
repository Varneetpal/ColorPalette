package com.example.varneet381asn1;

import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class ColorSlider extends Pane {
    Slider slider;
    Label colorLabel;

    public ColorSlider(String title){

        HBox root = new HBox();
        Label nLabel = new Label(title);
        slider = new Slider(0, 255, 50);
        colorLabel = new Label("50");
        root.getChildren().addAll(nLabel, slider, colorLabel);
        this.getChildren().add(root);

    }

    public double  GetValue(){
        return slider.getValue();
    }

    public void setValue(int val){
        colorLabel.setText("Value: " + val);
    }

}
