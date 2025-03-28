package controller;

import infoClass.Club;
import infoClass.Player;
import util.NetworkUtil;
import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main extends Application {

    private Stage stage;

    private NetworkUtil networkUtil;

    private Club club;

    public NetworkUtil getNetworkUtil() {
        return networkUtil;
    }
    public void setClub(Club club){
        this.club = club;
    }

    public Stage getStage() {
        return stage;
    }

    private List<Player> marketList = new ArrayList();
    //public static List<Club> clubList = new ArrayList();

    @Override
    public void start(Stage primaryStage) throws Exception{
        stage = primaryStage;
        connectToServer();
        showLoginPage();

    }
    private void connectToServer() throws IOException {
        String serverAddress = "127.0.0.1";
        int serverPort = 55555;
        networkUtil = new NetworkUtil(serverAddress, serverPort);
        new ReadThread(this);
    }
    public void showLoginPage() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../views/login.fxml"));
        Parent root = loader.load();

        LoginController controller = loader.getController();
        controller.setMain(this);

        stage.setTitle("Login");
        stage.setScene(new Scene(root, 600, 400));
        stage.show();

    }

    public void showHomePage(String userName) throws Exception {

       // Club club = new Club();

       /* for(Club cl: clubList){
            if(cl.getClubName().equalsIgnoreCase(userName)){
                System.out.println(cl.getClubName()); //test
                club = cl;
            }
        } */

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../views/home.fxml"));
        Parent root = loader.load();

        // Loading the controller
        HomeController controller = loader.getController();
        controller.init(userName,club);
        controller.setMain(this);

        // Set the primary stage
        stage.setTitle("Home");
        stage.setScene(new Scene(root, 760, 600));
        stage.show();
    }

    public void showRangePage(List<Player>list) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../views/range.fxml"));
        Parent root = loader.load();

        rangeController rangeController = loader.getController();
        rangeController.init(list);
        rangeController.setMain(this);

        stage.setTitle("Range");
        stage.setScene(new Scene(root, 548, 570));
        stage.show();

    }

    public void marketPage(List<Player>list) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../views/market.fxml"));
        Parent root = loader.load();

        MarketController marketController = loader.getController();
        marketController.init(list);
        marketController.setMain(this);

        stage.setTitle("Market");
        stage.setScene(new Scene(root, 780, 600));
        stage.show();

    }

    public void showAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Incorrect Credentials");
        alert.setHeaderText("Incorrect Credentials");
        alert.setContentText("The username and password you provided is not correct.");
        alert.showAndWait();
    }
    public List<Player> getBuyList(){
        return marketList;
    }

    public void setMarketList(Player player){
        System.out.println("NOt working");
        marketList.add(player);
    }

    public static void main(String[] args) {

      /*  try {
            playerList = FileOperation.readFromFile();
        } catch (Exception e) {
            e.printStackTrace();
        }

        for(Player p: playerList){
            boolean idx = false;
            for(int i = 0; i < clubList.size(); i++){
                Club c = clubList.get(i);
                if(c.getClubName().equalsIgnoreCase(p.getClub())){
                    c.addPlayer(p);
                    idx = true;
                    break;
                }
            }
            if(!idx){
                Club cl = new Club();
                cl.addPlayer(p);
                clubList.add(cl);
            }
        } */

        launch(args);
    }
}
