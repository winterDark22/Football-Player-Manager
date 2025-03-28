package util;

import infoClass.Club;
import infoClass.Player;

import java.io.Serializable;
import java.util.List;

public class LoginDTO implements Serializable {

    private String userName;
    private String password;
    private boolean status;

    private Club clientList;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Club getClub() {
        return clientList;
    }

    public void setClientList(Club clientList) {
        this.clientList = clientList;
    }

}
