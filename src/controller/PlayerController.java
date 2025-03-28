package controller;

import infoClass.Player;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class PlayerController {
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

    private Player player;

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

}
