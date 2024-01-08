//Name: Varneetpal Kaur
//NSID: van491
//Student number: 11282219
//Course name: CMPT 381

package com.example.varneet381asn1;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javax.net.ssl.HostnameVerifier;
import java.io.IOException;
import java.util.Arrays;

public class HelloApplication extends Application {

    int ref;

    HBox root; //main container
    VBox root1; //for the two portions of the layout
    VBox root2;

    Color currentColor;

    Circle c1; //main circle at the top


    //sliders
    ColorSlider s1;
    ColorSlider s2;
    ColorSlider s3;



    HBox h1;
    HBox h2;
    HBox h3;


    ColorPalette cpp;
    PaletteView pvv;

    Button b1;
    Button b2;

    Text t1;
    Text t2;




    //----------------
//    ListView<String> h;
//    ObservableList<String> hh;

    ListView<ColorPalette> cPalette;
    ObservableList<ColorPalette> oList;
//----------------

    @Override
    public void start(Stage stage) throws IOException {
        root = new HBox();
        root1 = new VBox();
        root2 = new VBox();

        c1 = new Circle();
        c1.setRadius(80);
        c1.setStroke(Color.BLACK);



        cpp = new ColorPalette();
        pvv = new PaletteView(cpp);



        cPalette = new ListView<>();
        oList = FXCollections.observableArrayList();
        cPalette.setItems(oList);
        cPalette.setCellFactory(listItem -> new PaletteCell());

        root2.getChildren().add(cPalette);


        //s1 = new Slider(0, 255, 50);
        s1 = new ColorSlider("Red: ");
        s1.slider.valueProperty().addListener(((observableValue, oldValue, newValue) -> setColor()));

        s2 = new ColorSlider("Green: ");
        s2.slider.valueProperty().addListener(((obervableValue, olValue, newValue) -> setColor()));

        s3 = new ColorSlider("Blue: ");
        s3.slider.valueProperty().addListener((((observableValue, oldValue, newValue) -> setColor())));

        h1 = new HBox();
        h2 = new HBox();
        h3 = new HBox();


        h1.getChildren().add(s1);
        h2.getChildren().add(s2);
        h3.getChildren().add(s3);

        b1 = new Button("Add to palette");
        b2 = new Button("Add to list");

        b1.setOnAction(this::handleAddPalette);
        //c2.setOnMouseClicked(e -> System.out.println("Add eventHandlers"));

        b2.setOnAction(this::handleAddList);

//
//        cPalette = new ListView<>();
//        oList = FXCollections.observableArrayList();

        root1.setAlignment(Pos.CENTER);

        root1.getChildren().addAll(c1, h1, h2, h3, b1, pvv, b2);
        root.getChildren().addAll(root1, root2);

        Scene scene = new Scene(root, 500, 500);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }


    public void setColor(){


        Color c = Color.rgb((int)(s1.GetValue()), (int)s2.GetValue(), (int)s3.GetValue());
        c1.setFill(c);
        currentColor = c;
        s1.colorLabel.textProperty().setValue(String.valueOf((int) s1.GetValue()));
        s2.colorLabel.textProperty().setValue(String.valueOf((int) s2.GetValue()));
        s3.colorLabel.textProperty().setValue(String.valueOf((int) s3.GetValue()));

        // CurrentPalette.addColor(c);

        // Update the Circles based on your current Palette : Hint FOR LOOP

    }

    public void handleAddList(ActionEvent e){
        System.out.println(cpp.colors[0].toString());
         oList.add(cpp);
    }
    public void handleAddPalette(ActionEvent e){


        if (ref == 0){
            pvv.c11.setFill(currentColor);
            cpp.addColor(currentColor);
            ref++;
        }

        else if (ref == 1){
            pvv.c12.setFill(currentColor);
            cpp.addColor(currentColor);
            ref++;
        }

        else {
            pvv.c13.setFill(currentColor);
            cpp.addColor(currentColor);
            ref = 0;
        }


        System.out.println(Arrays.toString(cpp.colors));

       // System.out.println((currentColor.getRed())*100+", " + (currentColor.getBlue())*100 +", "+ (currentColor.getGreen())*100);
    }

    public static void main(String[] args) {
        launch();
    }
}