package CS_ClientServer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
        CS版本的TCP通信的服务器端，读取客户端的数据，并向客户端写数据
        ServerSocket 类：这个类实现了服务器套接字，该对象等待通过网络的请求。
        构造方法：
                public ServerSocket(int port) ：使用该构造方法在创建ServerSocket对象时，就可以将其绑定到一个指定的端口号上，参数port就是端口号。

        每个客户端都是用Socket(String host,int port)来请求我服务器，那么多客户端来请求，我怎么知道谁请求我？
        服务器可以通过accept()来获取每个客户端的Socket对象从而区分是谁请求我。
*/
public class CS_TcpServer {
    public static void main(String[] args) throws IOException {
        //创建服务器套接字
        ServerSocket server=new ServerSocket(8888);
        //使用accept()获取客户端Socket对象
        Socket clientSocket = server.accept();
        //获取客户端的数据
        InputStream is = clientSocket.getInputStream();
        byte[] bytes=new byte[1024];
        int len=0;
        while ((len=is.read(bytes))!=-1){
            System.out.println("我是服务器，读取到客户端发来的数据为："+ new String(bytes,0,len));
        }
        //----------------------------------------------
        //获取客户端的输出流给客户端回写数据
        OutputStream os = clientSocket.getOutputStream();
        os.write("我很好，谢谢！".getBytes());


        //关闭客户端
        clientSocket.close();
        //关闭服务端
        server.close();
    }
}
