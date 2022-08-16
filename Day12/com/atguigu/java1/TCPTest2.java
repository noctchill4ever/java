package com.atguigu.java1;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/*
例2：客户端发送文件给服务端，服务端将文件保存在本地
 */
public class TCPTest2 {
    @Test
    public void client() throws IOException {
        Socket socket=new Socket(InetAddress.getByName("127.0.0.1"),9090);
        OutputStream os= socket.getOutputStream();
        FileInputStream fis=new FileInputStream("Day12/pic.jpg");
        byte[]buffer=new byte[1024];
        int len;
        while ((len=fis.read(buffer))!=-1){
            os.write(buffer,0,len);
        }
        fis.close();
        os.close();
        socket.close();
    }
    @Test
    public void server() throws IOException {
        ServerSocket ss=new ServerSocket(9090);
        Socket socket=ss.accept();
        InputStream is=socket.getInputStream();
        FileOutputStream fos=new FileOutputStream("Day12/pic1.jpg");
        byte[]buffer=new byte[1024];
        int len;
        while ((len=is.read(buffer))!=-1){
            fos.write(buffer,0,len);
        }
        fos.close();
        is.close();
        socket.close();
        ss.close();
    }
}
