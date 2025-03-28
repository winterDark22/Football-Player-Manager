package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class elementController {

    @FXML
    private Label countryName;

    @FXML
    private Label countryCount;

    private String country;
    private int count;

    public void setElement(String country, int count){
        this.country = country;
        this.count = count;
        countryName.setText(this.country);
        countryCount.setText(String.valueOf(this.count));
    }

}

