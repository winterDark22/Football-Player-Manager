package infoClass;

import infoClass.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class SearchPlayer {

    public SearchPlayer(){

    }

        List<Player> resultList = new ArrayList<>();
        //resultList = byName(plname, playerList);
       // if(resultList.size() == 0)
         //   System.out.println("No such player with the given info");

    public List<Player> byName(String plName, List<Player> list){

        List<Player> byPlayerName = new ArrayList<>();

        for(Player pl: list){
            if(pl.getName().equalsIgnoreCase(plName)){
               byPlayerName.add(pl);
               break;
            }
        }
        return byPlayerName;
    }
    public List< Player> byCountry(String coutry, List<Player> list){
        List<Player> byCountry = new ArrayList<>();

        for(Player pl: list){
            if(pl.getCountry().equalsIgnoreCase(coutry)){
                byCountry.add(pl);
            }
        }
        return byCountry;
    }
    public List< Player> byPositon(String position, List<Player> list){
        List<Player> byPosition = new ArrayList<>();

        for(Player pl: list){
            if(pl.getPosition().equalsIgnoreCase(position)){
                byPosition.add(pl);
            }
        }
        return byPosition;
    }

    public List< Player>  bySalaryRange(double low, double high, List<Player> list){
        List<Player> bySalary = new ArrayList<>();

        for(Player pl: list){
            if(pl.getSalary() >= low && pl.getSalary() <= high){
                bySalary.add(pl);
            }
        }
        return bySalary;
    }

    public HashMap<String, Integer> byCountryWisePlayer(List<Player> list){
        HashMap<String, Integer> countryWiseCount = new HashMap();

        for (Player pl: list){
            boolean chk = false;
            for(String s: countryWiseCount.keySet()){
                if(s.equalsIgnoreCase(pl.getCountry())){
                    chk = true;
                    break;
                }
            }
            if(chk == true)
                countryWiseCount.put( pl.getCountry(), countryWiseCount.get(pl.getCountry())+1);
            else
                countryWiseCount.put( pl.getCountry(), 1);
        }
        return countryWiseCount;
       /* System.out.println();
        for(String s: countryWiseCount.keySet()){
            System.out.println("Country: " + s + "    Count: " + countryWiseCount.get(s));
        }
        System.out.println(); */
    }

}
