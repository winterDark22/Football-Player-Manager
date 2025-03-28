package controller;

import infoClass.Player;

import java.io.Serializable;

public class MarketList implements Serializable {
    private Player player;

    public MarketList(){

    }
    public void setPlayer( Player player){
        this.player = player;
    }
    public Player getPlayer(){
        return this.player;
    }
}
