package infoClass;

import infoClass.Player;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class FileOperation {
    private static final String INPUT_FILE_NAME = "players.txt";
    private static final String OUTPUT_FILE_NAME = "players.txt";

    public static List<Player> readFromFile() throws Exception{
        List<Player> playerList = new ArrayList();
        BufferedReader br = new BufferedReader(new FileReader(INPUT_FILE_NAME));
        while (true) {
            String line = br.readLine();
            if (line == null) break;
            String[] tokens = line.split(",");
            Player pl = new Player();
            pl.setName(tokens[0]);
            pl.setCountry(tokens[1]);
            pl.setAge(Integer.parseInt(tokens[2]));
            pl.setHeight(Double.parseDouble(tokens[3]));
            pl.setClub(tokens[4]);
            pl.setPosition(tokens[5]);
            pl.setNumber(Integer.parseInt(tokens[6]));
            pl.setSalary(Double.parseDouble(tokens[7]));
            playerList.add(pl);
        }
        br.close();
        return playerList;
    }
    public static void writeToFile(List<Player> playerList) throws Exception {
        BufferedWriter bw = new BufferedWriter(new FileWriter(OUTPUT_FILE_NAME));
        for(Player pl: playerList) {
            bw.write(pl.getName() + "," + pl.getCountry() + "," + pl.getAge() + "," + pl.getHeight() +
                    "," + pl.getClub() + "," + pl.getPosition() + "," + pl.getNumber() + "," + pl.getSalary());
            bw.write("\n");
        }
        bw.close();
    }
}
