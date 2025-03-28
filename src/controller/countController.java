package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.util.HashMap;

public class countController {
    @FXML
    private GridPane gridpane;

    public void setGridpane(HashMap<String, Integer> map) {
        int column = 1;
        int row = 1;
        try {
            for (String s : map.keySet()) {

                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("../views/countElement.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();
                elementController elementcontroller = fxmlLoader.getController();
                elementcontroller.setElement(s,map.get(s));
                if(column == 2){
                    column = 1;
                    row++;
                }
                gridpane.add(anchorPane, column++, row);
                GridPane.setMargin(anchorPane,new Insets(5));
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
