package NetworkProgram;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Inet6Address;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/*
@author 黄佳豪
@create 2019-07-30-17:34
客户端发送信息，服务端接收打印信息
*/
public class TCPDemo1 {
    @Test
    public void testServer() throws IOException {
        //创建服务端套接字对象
        ServerSocket ss = new ServerSocket(8888);
        //接收客户端的连接请求
        Socket socket = ss.accept();
        //读写数据
        //①获取读取数据流对象
        InputStream inputStream = socket.getInputStream();
        //②通过流对象读取数据
        byte[] b = new byte[1024];
        int len;
        while ((len = inputStream.read(b)) != -1) {
            System.out.println(new String(b, 0, len));
        }
        //关闭资阳
        inputStream.close();
        socket.close();
    }

    @Test
    public void testClient() throws IOException {
        //创建客户端套接字对象，并制定服务端的ip和端口号，发送连接请求
        Socket socket = new Socket(Inet6Address.getLocalHost(), 8888);
//读写数据，向服务端发送数据
        //①获取写入数据的流对象
        OutputStream outputStream = socket.getOutputStream();
//②通过outputStream
        outputStream.write("你好".getBytes());
        outputStream.close();
        socket.close();
    }
}
