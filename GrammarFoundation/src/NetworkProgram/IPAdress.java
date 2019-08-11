package NetworkProgram;

import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

/*
@author 黄佳豪
@create 2019-07-30-17:23
*/
public class IPAdress {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress ip1 = Inet6Address.getLocalHost();
        System.out.println(ip1);
        InetAddress[] baidus = Inet6Address.getAllByName("localhost");
        for (InetAddress inetAddress : baidus) {
            System.out.println(inetAddress);
        }
    }
}
