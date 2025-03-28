package controller;

import infoClass.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MarketController {

    private Main main;
    private String clubName;
    private List<Player> sellPlayers = new ArrayList<>();
    private List<Player> buyPlayers = new ArrayList<>();


    @FXML
    private Button homeButton;

    @FXML
    private GridPane buyGrid;

    @FXML
    private GridPane sellGrid;

    private void Sell(List<Player> players){
        int column = 1;
        int row = 1;

        try {
            for(Player pl: players) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("../views/sell.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                SellController sellController = fxmlLoader.getController();
                sellController.setData(pl);
                sellController.setMain(this.main);

                if(column == 2){
                    column = 1;
                    row++;
                }
                sellGrid.add(anchorPane, column++, row);
                GridPane.setMargin(anchorPane,new Insets(6,2,10,2));

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void Buy(List<Player> players){
        int column = 1;
        int row = 1;

        try {
            for(Player pl: players) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("../views/buy.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                BuyController buyController = fxmlLoader.getController();
                buyController.setData(pl);

                if(column == 2){
                    column = 1;
                    row++;
                }
                buyGrid.add(anchorPane, column++, row);
                GridPane.setMargin(anchorPane,new Insets(1,0,5,0));

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void init(List<Player> list) {
        sellPlayers = list;
        clubName = sellPlayers.get(0).getClub();
        Sell(sellPlayers);

      /*  System.out.println("Problem -- 1");
        main.showAlert();
        System.out.println("Problem -- 2");
        buyPlayers = main.getBuyList();
        System.out.println("Problem -- 3"); */

    }
    @FXML
    void homeAction(ActionEvent event) {
        try {
            main.showHomePage(clubName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void setMain(Main main) {
        this.main = main;
    }
}
