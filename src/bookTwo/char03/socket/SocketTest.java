package bookTwo.char03.socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author gy1zc3@gmail.com
 *         Created by zacky on 16:46.
 */
public class SocketTest {
    public static void main(String[] args) throws IOException{
        try(Socket s = new Socket("120.52.12.202",8880)){
            InputStream inputStream = s.getInputStream();
            Scanner in = new Scanner(inputStream);

            while (in.hasNextLine()){
                String line = in.nextLine();
                System.out.println(line);
            }
        }
    }
}
