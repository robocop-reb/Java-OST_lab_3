package sample;

import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class ServerOst {
    static ExecutorService executeS = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {
        List<Record> recordList = new ArrayList<>();
        recordList.add(new Record("12.02.20","Minsk",23,12,"123456"));
        recordList.add(new Record("13.02.20","Minsk",27,12,"12456"));

        try (ServerSocket server = new ServerSocket(3345);
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))
        ) {
            System.out.println("Server socket created, command console reader for listen to server commands");
            while (!server.isClosed()) {
            if(br.ready()){
                System.out.println("Main Server found any messages in channel, let's look at them.");
                String serverCommand = br.readLine();
                if (serverCommand.equalsIgnoreCase("quit")) {
                    System.out.println("Main Server initiate exiting...");
                    server.close();
                    break;
                }
            }
                Socket client = server.accept();
                executeS.execute(new MonoThreadClientHandler(client,recordList));
                System.out.print("Connection accepted.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}