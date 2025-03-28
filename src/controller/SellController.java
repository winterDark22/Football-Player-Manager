package controller;

import infoClass.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class SellController {

    @FXML
    private Label nameLabel;

    @FXML
    private Label ageLabel;

    @FXML
    private Label countryLabel;

    @FXML
    private Label heightLabel;

    @FXML
    private Label clubLabel;

    @FXML
    private Label numberLabel;

    @FXML
    private Label positionLabel;

    @FXML
    private Label salaryLabel;

    @FXML
    private Button sellButton;

    private Player player;
    private Main main;

    @FXML
    void sellAction(ActionEvent event) {
        /*9MarketList marketList = new MarketList();
        marketList.setPlayer(this.player);

        try{
            main.getNetworkUtil().write(marketList);
        } catch (Exception e){
            e.printStackTrace();
        } */
      //  main.setMarketList(this.player);
    }


    public void setData(Player player) {
        this.player = player;
        nameLabel.setText(this.player.getName());
        ageLabel.setText(String.valueOf(this.player.getAge()));
        countryLabel.setText(this.player.getCountry());
        heightLabel.setText(String.valueOf(this.player.getHeight()));
        clubLabel.setText(this.player.getClub());
        numberLabel.setText(String.valueOf(this.player.getNumber()));
        positionLabel.setText(String.valueOf(this.player.getPosition()));
        salaryLabel.setText(String.valueOf(this.player.getSalary()));
    }

    void setMain(Main main) {
        this.main = main;
    }

}
