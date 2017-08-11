package bookTwo.char03.threaded;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author gy1zc3@gmail.com
 *         Created by zacky on 21:21.
 */
public class ThreadedEchoServer {
    public static void main(String[] args) {
        try{
            int i = 1;
            ServerSocket s = new ServerSocket(8189);
            while (true){
                Socket incoming = s.accept();
                System.out.println("Spawning " + i);
                Runnable r = new ThreadedEchoHandler(incoming);
                Thread t = new Thread(r);
                t.start();
                i++;
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}

class ThreadedEchoHandler implements Runnable{
    private Socket incoming;

    public ThreadedEchoHandler(Socket i){
        incoming = i;
    }

    @Override
    public void run() {
        try{
            try{
                InputStream inputStream = incoming.getInputStream();
                OutputStream outputStream = incoming.getOutputStream();

                Scanner in = new Scanner(inputStream);
                PrintWriter out = new PrintWriter(outputStream, true);

                out.println("Hello!Enter BYE to exit.");
                boolean done = false;
                while (!done && in.hasNextLine()){
                    String line = in.nextLine();
                    out.println("Echo:" + line);
                    if(line.trim().equals("BYE"))
                        done = true;
                }
            }
            finally {
                incoming.close();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
