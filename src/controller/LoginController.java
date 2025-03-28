package controller;

import infoClass.Club;
import infoClass.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import util.LoginDTO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoginController {

    private Main main;

    @FXML
    private TextField userText;

    @FXML
    private PasswordField passwordText;

    @FXML
    private Button resetButton;

    @FXML
    private Button loginButton;

    private List<Club> clubs = new ArrayList<>();

    private boolean flag = false;

    @FXML
    void loginAction(ActionEvent event) {

        String userName = userText.getText();
        String password = passwordText.getText();
        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setUserName(userName);
        loginDTO.setPassword(password);

        try {
            main.getNetworkUtil().write(loginDTO);
        } catch (IOException e) {
            e.printStackTrace();
        }

       /* clubs = main.getClubList();
        for(Club c: clubs) {
            if (userName.equalsIgnoreCase(c.getClubName()) && password.equals("123")) {
                flag = true;
                try {
                    main.showHomePage(userName);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
        if(!flag)
            main.showAlert();
            */

    }

    @FXML
    void resetAction(ActionEvent event) {
        userText.setText(null);
        passwordText.setText(null);
    }

    void setMain(Main main) {
        this.main = main;
    }

}
