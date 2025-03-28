package server;

import controller.MarketList;
import infoClass.Club;
import util.LoginDTO;
import util.NetworkUtil;

import java.io.IOException;
import java.util.HashMap;

public class ReadThreadServer implements Runnable {
    private final Thread thr;
    private final NetworkUtil networkUtil;
    public HashMap<String, Club> userMap;


    public ReadThreadServer(HashMap<String, Club> map, NetworkUtil networkUtil) {
        this.userMap = map;
        this.networkUtil = networkUtil;
        this.thr = new Thread(this);
        thr.start();
    }

    public void run() {
        try {
            while (true) {
                Object o = networkUtil.read();
                if (o != null) {
                    if (o instanceof LoginDTO) {
                        LoginDTO loginDTO = (LoginDTO) o;
                        String user = loginDTO.getUserName();
                        for (String s: userMap.keySet()){
                            if (s.equalsIgnoreCase(user)){
                                loginDTO.setStatus(loginDTO.getPassword().equals("123"));
                                loginDTO.setClientList(userMap.get(s));
                            }
                        }
                        //String password = userMap.get(loginDTO.getUserName());
                        //loginDTO.setStatus(loginDTO.getPassword().equals(password));
                        networkUtil.write(loginDTO);
                    }

                }
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                networkUtil.closeConnection();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}



