package NetworkProgram;

import org.junit.Test;

import java.io.*;
import java.net.Inet6Address;
import java.net.ServerSocket;
import java.net.Socket;

/*
@author 黄佳豪
@create 2019-07-30-17:34
客户端发送信息，服务端接收打印信息
*/
@SuppressWarnings("all")
public class TCPDemo3 {
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
        //向客户端写入数据
        //获取写入数据的流对象
        OutputStream outputStream = socket.getOutputStream();

        //通过流对象写入数据
        outputStream.write("I am server!\n".getBytes());
        socket.shutdownOutput();
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
        outputStream.write("I'm Client!\n".getBytes());
//        ③设置写入结束标记，代表写入完毕
        socket.shutdownOutput();
        //读取数据流对象
        InputStream inputStream = socket.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        //读取数据
        String line=reader.readLine();
        //向网络中客户端写入数据
        OutputStream outputStream1 = socket.getOutputStream();
        byte[] b = new byte[1024];
        int len;
        while ((len = inputStream.read(b)) != -1) {
            System.out.println(new String(b, 0, len));
        }
        inputStream.close();
        outputStream.close();
        socket.close();
    }
}
