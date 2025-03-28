package controller;


import infoClass.Club;
import infoClass.Player;
import infoClass.SearchPlayer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class HomeController {

    private Main main;

    @FXML
    private Button searchButton;

    @FXML
    private Label clubName;

    @FXML
    private Label error;


    @FXML
    private Button searchName;

    @FXML
    private Button salaryRange;

    @FXML
    private Button searchPosition;

    @FXML
    private Button searchCountry;

    @FXML
    private Button maxAge;

    @FXML
    private Button maxHeight;

    @FXML
    private Button maxSalary;

    @FXML
    private Button allPlayers;

    @FXML
    private Button playerCount;

    @FXML
    private Button home;

    @FXML
    private Button market;

    @FXML
    private Button logout;

    @FXML
    private Label nameLabel;

    @FXML
    private Label salaryLabel;

    @FXML
    private ScrollPane scroll;

    @FXML
    private TextField searchText;

    @FXML
    private GridPane grid;

    @FXML
    private Label warn;


    private String clName;
    private String option = "";

    private List<Player> players = new ArrayList<>();
    private List<Player> srPlayer = new ArrayList<>();

    private Club club;

    private SearchPlayer search = new SearchPlayer();


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
                GridPane.setMargin(anchorPane,new Insets(10,15,10,15));

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void init(String msg, Club club) {
        System.out.println("INIt");
        clName = msg;
        nameLabel.setText(clName.toUpperCase(Locale.ROOT));
        salaryLabel.setText(String.valueOf(club.getTotalSalary()));
        this.club = club;
        players = club.getPlayers();
        Data(players);
    }

    @FXML
    void homeAction(ActionEvent event) {
        try {
            main.showLoginPage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

   @FXML
    void logoutAction(ActionEvent event) {
        try {
            main.showLoginPage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void allPlayersAction(ActionEvent event) {
        grid.getChildren().clear();
        searchText.clear();
        warn.setText(" ");
        Data(players);
    }

    @FXML
    void maxAgeAction(ActionEvent event) {
        grid.getChildren().clear();
        searchText.clear();
        srPlayer = club.mxAge();
        warn.setText(" ");
        Data(srPlayer);

    }

    @FXML
    void maxHeightAction(ActionEvent event) {
        srPlayer = club.mxHeight();
        grid.getChildren().clear();
        searchText.clear();
        warn.setText(" ");
        Data(srPlayer);
    }

    @FXML
    void maxSalaryAction(ActionEvent event) {
        srPlayer = club.mxSalary();
        grid.getChildren().clear();
        searchText.clear();
        warn.setText(" ");
        Data(srPlayer);
    }

    @FXML
    void playerCountAction(ActionEvent event) {
        HashMap<String, Integer> maps = new HashMap<>();
        searchText.clear();
        warn.setText(" ");
        maps = search.byCountryWisePlayer(players);
        grid.getChildren().clear();
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("../views/count.fxml"));
            AnchorPane anchorPane = fxmlLoader.load();

            countController countcontroller = fxmlLoader.getController();
            countcontroller.setGridpane(maps);

            grid.add(anchorPane, 1, 1);
            GridPane.setMargin(anchorPane,new Insets(10));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML
    public void searchButtonAction(ActionEvent actionEvent) {

        if(option.equalsIgnoreCase("byname")){
            String name = searchText.getText();
            srPlayer = search.byName(name, players);
            grid.getChildren().clear();
            warn.setText(" ");
            if(!srPlayer.isEmpty()){
                Data(srPlayer);
            }
            else
                warn.setText("No player to show!");
        }
        else if(option.equalsIgnoreCase("bycountry")){
            String name = searchText.getText();
            srPlayer = search.byCountry(name, players);
            grid.getChildren().clear();
            warn.setText(" ");
            if(!srPlayer.isEmpty()){
                Data(srPlayer);
            }
            else
                warn.setText("No player to show!");
        }
        else if(option.equalsIgnoreCase("byposition")){
            String name = searchText.getText();
            srPlayer = search.byPositon(name, players);
            grid.getChildren().clear();
            warn.setText(" ");
            if(!srPlayer.isEmpty()){
                Data(srPlayer);
            }
            else
                warn.setText("No player to show!");
        }
    }

    @FXML
    void searchNameAction(ActionEvent event) {
        searchText.clear();
        option = "byname";
    }
    @FXML
    void searchCountryAction(ActionEvent event) {
        searchText.clear();
        option = "bycountry";
    }
    @FXML
    void searchPositionAction(ActionEvent event) {
        searchText.clear();
        option = "byposition";
    }

    @FXML
    void salaryRangeAction(ActionEvent event) {
        try {
            main.showRangePage(players);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    @FXML
    void marketAction(ActionEvent event) {
        main.setMarketList(players.get(0));
        main.setMarketList(players.get(1));
        try {
            main.marketPage(players);
        }catch (Exception e){
            System.out.println(e);
        }
    }
    void setMain(Main main) {
        this.main = main;
    }

}
