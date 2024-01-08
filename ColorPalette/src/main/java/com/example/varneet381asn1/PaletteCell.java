package com.example.varneet381asn1;//package com.example.prac;

import javafx.scene.control.ListCell;

public class PaletteCell extends ListCell<ColorPalette>  {


    public void updateItem(ColorPalette item, boolean empty) {
        super.updateItem(item, empty);
        PaletteView pv = new PaletteView(item);
        setGraphic(pv);
    }
}
