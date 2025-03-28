package infoClass;

import infoClass.Player;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Club implements Serializable {
    private String clubName;
    private double maxSalary;
    private int maxAge;
    private double maxHeight;
    private double totalSalary;
    //private Player[] players;
    private List<Player> players = new ArrayList<>();
    private int count;

    public Club(){
        this.clubName = "";
        //this.players = new Player[7];
        this.maxSalary = -1;
        this.maxAge = -1;
        this.maxHeight = -1;
        this.totalSalary = 0;
        this.count = 0;
    }
    public void setClubName(String name){
        this.clubName = name;
    }
    public void setMaxSalary(double maxSalary){
        this.maxSalary = maxSalary;
    }
    public void setMaxAge(int maxAge ){
        this.maxAge = maxAge;
    }
    public void setMaxHeight(double maxHeight){
        this.maxHeight = maxHeight;
    }
    public void setTotalSalary(double totalSalary){
        this.totalSalary = totalSalary;
    }
    public String getClubName(){
        return this.clubName;
    }
    public double getMaxSalary(){
        return this.maxSalary;
    }
    public int getMaxAge(){
        return this.maxAge;
    }
    public double getMaxHeight(){
        return this.maxHeight;
    }
    public double getTotalSalary(){
        return this.totalSalary;
    }
    public int getCount(){
        return this.count;
    }
    public void addPlayer(Player p){
        players.add(p);
        count++;
        this.clubName = p.getClub();
        updateInfo(p);
    }
    public void updateInfo(Player p){
        this.totalSalary += p.getSalary();
        this.maxSalary = Math.max(this.maxSalary, p.getSalary());
        this.maxAge = Math.max(this.maxAge, p.getAge());
        this.maxHeight = Math.max(this.maxHeight, p.getHeight());
    }
    public List<Player> mxSalary(){
        List<Player> mxSalaryPlayers = new ArrayList<>();
        for(Player pl: players){
            if(pl.getSalary() == maxSalary){
                mxSalaryPlayers.add(pl);
            }
        }
        return mxSalaryPlayers;
    }

    public List<Player> mxAge(){
        List<Player> mxAgePlayers = new ArrayList<>();
        for(Player pl: players){
            if(pl.getAge() == maxAge){
                mxAgePlayers.add(pl);
            }
        }
        return mxAgePlayers;
    }

    public List<Player> mxHeight(){
        List<Player> mxHeightPlayers = new ArrayList<>();
        for(Player pl: players){
            if(pl.getHeight() == maxHeight){
                mxHeightPlayers.add(pl);
            }
        }
        return mxHeightPlayers;
    }

    public double yearlySalary(){
        double yearly = totalSalary * 52;
        return yearly;
    }

    /*public boolean isUniqueID(Player newPl){
        for(Player pl: players){
            if(newPl.getNumber() == pl.getNumber())
                return false;
        }
        return true;
    } */

    public List<Player>  getPlayers(){
        return players;
    }
}
