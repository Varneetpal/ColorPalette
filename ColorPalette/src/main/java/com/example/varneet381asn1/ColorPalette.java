package com.example.varneet381asn1;


import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class ColorPalette{
    Color[] colors;
    int idCurrent;


    public ColorPalette()
    {
        idCurrent = 0;
        colors = new Color[3];
        for(int i =0; i<colors.length; i++)
        {
            colors[i] = Color.WHITE;
        }
    }

    public void addColor(Color c) {

        colors[idCurrent] = c;
        idCurrent++;

        //System.out.println(idCurrent);

        if(idCurrent>2)
        {
            idCurrent =0;
        }
    }
}