package NetworkProgram;

import org.junit.Test;

import javax.naming.ldap.SortKey;
import java.io.*;
import java.net.Inet6Address;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/*
@author 黄佳豪
@create 2019-07-30-19:14
客户端向服务器发一张图片，服务器接收并保存到本地
*/
public class TCPDemo4 {
    @Test
    public void testServer() throws IOException {
        //窗口按服务端套接字对象
        ServerSocket ss = new ServerSocket(9999);
        //接收连接 请求
        Socket socket = ss.accept();
        //穿件读取流对象
        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("src\\copy.jpg"));
        //读取数据
        byte[] b = new byte[1024];
        int len;
        while ((len = bis.read()) != -1) {
            bos.write(b,0,len);
        }
        //向客户端发送数据
        //创建写入流对象
        PrintStream printer = new PrintStream(socket.getOutputStream());
        //写入
        printer.println("照片不错");
        printer.close();
        bos.close();
        bis.close();
    }

    /**
     * 客户端
     *
     */
    @Test
    public void testClient() throws IOException {
        Socket socket = new Socket(Inet6Address.getLocalHost(), 9999);
        //将本地图片读取并写入到网络中
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("D:\\Workspaces\\Java20190715\\GrammarFoundation\\src\\IOStream\\File\\cherry.jpg"));
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        //边读边写
        byte[] b = new byte[1024];
        int len;
        while ((len = bis.read(b)) != -1) {
            bos.write(b,0,len);
        }
//        socket.shutdownOutput();
        //读取服务端发来的文本
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        System.out.println(reader.readLine());
        reader.close();bos.close();bis.close();socket.close();
    }
}
