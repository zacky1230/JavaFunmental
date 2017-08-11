package bookTwo.char03.inetAddress;

import java.io.IOException;
import java.net.InetAddress;

/**
 * @author gy1zc3@gmail.com
 *         Created by zacky on 17:01.
 */
public class InetAddressTest {
    public static void main(String[] args) throws IOException{
        if(args.length > 0){
            String host = args[0];
            InetAddress[] address = InetAddress.getAllByName(host);
            for (InetAddress a : address)
                System.out.println(a);
        }else{
            InetAddress localHostAddress = InetAddress.getLocalHost();
            System.out.println(localHostAddress);
        }
    }
}
