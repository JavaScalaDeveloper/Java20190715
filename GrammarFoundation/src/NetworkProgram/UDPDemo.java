package NetworkProgram;

import org.junit.Test;

import java.io.IOException;
import java.net.*;

/*演示基于UDP的网络通信
@author 黄佳豪
@create 2019-07-30-20:05
*/
public class UDPDemo {
    //发送端
    @Test
    public void testSend() throws IOException {
        //创建DatagramSocket对象
        DatagramSocket socket = new DatagramSocket();
        //创建DatagramPacket对象，用于包装发送的数据
        byte[] buf = "I'm socket".getBytes();
        DatagramPacket packet = new DatagramPacket(buf, buf.length, Inet6Address.getLocalHost(), 6666);
        //发送
        socket.send(packet);
        socket.close();
    }

    @Test
    public void testReceive() throws IOException {
        //创建DatagramSocket套接字对象
        DatagramSocket socket = new DatagramSocket(6666);
        //创建DatagramPacket
        byte[] buf = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buf, buf.length);
        //接收数据
        socket.receive(packet);
        String data = new String(packet.getData(), 0, packet.getLength());
        System.out.println(data);
        socket.close();
    }
}
