package Basic;

import java.net.*;

public class NetTest {
    public static void main(String[] args) {
        InetAddress host = null;
        try {
            host = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        String ip =host.getHostAddress();
        while (true) {
            System.out.println('1');
        }
    }
}
