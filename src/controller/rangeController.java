package controller;

import infoClass.Club;
import infoClass.Player;
import infoClass.SearchPlayer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class rangeController {

    @FXML
    private TextField low;

    @FXML
    private TextField high;

    @FXML
    private Button submitButton;

    @FXML
    private Label warningText;

    @FXML
    private GridPane grid;

    @FXML
    private Button clearButton;

    @FXML
    private Button homeButton;

    private Main main;

    private double lowSalary;
    private double highSalary;

    private List<Player> players = new ArrayList<>();
    private List<Player> srPlayer = new ArrayList<>();

    private SearchPlayer search = new SearchPlayer();
    private String clubName;

    private void Data(List<Player> players){
        int column = 1;
        int row = 1;

        try {
            for(Player pl: players) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("../views/player.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                PlayerController playerController = fxmlLoader.getController();
                playerController.setData(pl);

                if(column == 2){
                    column = 1;
                    row++;
                }
                grid.add(anchorPane, column++, row);
                GridPane.setMargin(anchorPane,new Insets(10,15,10,60));

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void clearAciton(ActionEvent event) {
        low.clear();
        high.clear();
        grid.getChildren().clear();
        warningText.setText(" ");
    }

    @FXML
    void submitAction(ActionEvent event) {
        String lowS = low.getText();
        String highS = high.getText();
        try{
            lowSalary = Double.parseDouble(lowS);
            highSalary = Double.parseDouble(highS);
            srPlayer = search.bySalaryRange(lowSalary, highSalary,players);
            grid.getChildren().clear();
            warningText.setText(" ");
            if(!srPlayer.isEmpty()){
                Data(srPlayer);
            }
            else
                warningText.setText("No player to show!");

        }
        catch (Exception e){
            warningText.setText("Salary should be double type!");
        }
    }

    @FXML
    void homeAction(ActionEvent event) {
        try {
            main.showHomePage(clubName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void init(List<Player> list) {
        players = list;
        clubName = players.get(0).getClub();
    }
    void setMain(Main main) {
        this.main = main;
    }


}


