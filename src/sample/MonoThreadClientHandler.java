package sample;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.List;
import java.util.stream.Collectors;

public class MonoThreadClientHandler implements Runnable {
    List<Record> recordList;

    public MonoThreadClientHandler(Socket client, List arrayList) {
        MonoThreadClientHandler.clientDialog = client;
        recordList = arrayList;
    }
    private static Socket clientDialog;
    @Override
    public void run() {

        try {
            DataOutputStream out = new DataOutputStream(clientDialog.getOutputStream());
            DataInputStream in = new DataInputStream(clientDialog.getInputStream());
            System.out.println("DataInputStream created");
            System.out.println("DataOutputStream  created");
            String city = in.readUTF();
            int result = 0;
           int sumOfMinutes = recordList.stream()
                    .filter(cityName -> cityName.getCityname().equals(city))
                    .mapToInt(cityName-> cityName.getLenghtofTalk())
                    .sum();
            out.writeInt(sumOfMinutes);
            System.out.println("Closing connections & channels.");
            in.close();
            out.close();
            clientDialog.close();
            System.out.println("Closing connections & channels - DONE.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
