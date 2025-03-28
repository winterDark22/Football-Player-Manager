package server;

import infoClass.Club;
import infoClass.FileOperation;
import infoClass.Player;
import util.NetworkUtil;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Server {

    private ServerSocket serverSocket;
    public HashMap<String, Club> userMap;

    public List<Player> playerList = new ArrayList();
    public  List<Club> clubList = new ArrayList();

    Server() {
        try {
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
        }

        userMap = new HashMap<>();

        for(Club cl: clubList){
            userMap.put(cl.getClubName(), cl);
        }
        try {
            serverSocket = new ServerSocket(55555);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                serve(clientSocket);
            }
        } catch (Exception e) {
            System.out.println("Server starts:" + e);
        }
    }

    public void serve(Socket clientSocket) throws IOException {
        NetworkUtil networkUtil = new NetworkUtil(clientSocket);
        new ReadThreadServer(userMap, networkUtil);
    }

    public static void main(String[] args) {
        new Server();
    }
}
