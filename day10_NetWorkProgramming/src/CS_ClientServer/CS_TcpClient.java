package CS_ClientServer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/*

        CS版本的TCP通信客户端: 向服务器发送连接请求,给服务器发送数据,读取服务器回写的数据
        表示客户端的类java.net.Socket,此类实现客户端套接字（IP地址，端口号），socket就是套接字的意思

        构造方法：
                Socket(String host,int port): host表示服务器主机名称/服务器IP地址，port表示服务器端口号
        成员方法：
                OutputStream getOutputStream() 获取网络字节输出流，用法和我们前面学到的最基本的字节流一样
                InputStream getInputStream() 获取网络字节输入流
                void close() 关闭套接字
                服务器没有自己的输入/出流，它通过调用accept()来获取客户端的Socket对象，从而获取客户端的输入/出流
*/
public class CS_TcpClient {
    public static void main(String[] args) throws IOException {
        //当我们创建客户端socket对象的时候，就会去请求服务器经过3次握手建立连接通路
        Socket client=new Socket("127.0.0.1",8888);//6666随便写，只要没被占用就ok
        //获取网络字节输出流 向服务器写数据
        OutputStream os = client.getOutputStream();
        os.write("服务器，你好吗？".getBytes());
        client.shutdownOutput();
        //---------------------------------------
        //接收服务器发送过来的数据
        InputStream is = client.getInputStream();
        byte[] bytes=new byte[1024];
        int len=0;
        while ((len=is.read(bytes))!=-1){
            System.out.println("我是客户端，接收到服务器发来的数据为："+ new String(bytes,0,len));
        }

        //is.close();
        //os.close();//其实可以不用，直接用下面的client.close()就可以
        client.close();
    }
}
/*
     先运行TcpServer，再运行TcpClient,不知道为啥客户端接收不到服务器发过来的数据
*/