package BS_BrowserServer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/*
         创建BS版本的TCP通信服务
             运行之后在浏览器中输入：http://127.0.0.1:8080/day10_NetWorkProgramming/src/BS_BrowserServer/web/index.html
         结果：
            GET /day10_NetWorkProgramming/src/BS_BrowserServer/web/index.html HTTP/1.1
            Host: 127.0.0.1:8080
            Connection: keep-alive
            Upgrade-Insecure-Requests: 1
            User-Agent: Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/84.0.4147.105 Safari/537.36
            Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng, ;q=0.8,application/signed-exchange;v=b3;q=0.9
            Sec-Fetch-Site: none
            Sec-Fetch-Mode: navigate
            Sec-Fetch-User: ?1
            Sec-Fetch-Dest: document
            Accept-Encoding: gzip, deflate, br
            Accept-Language: zh-CN,zh;q=0.9,en-US;q=0.8,en;q=0.7
            Cookie: olfsk=olfsk0466964668897869; hblid=2pbNNcJwkgLsdPgQ3m39N0H0KL0JEra6
*/
public class BS_TcpServer {
    public static void main(String[] args) throws IOException{
        ServerSocket server=new ServerSocket(8080);
        System.out.println("服务器开始启动...");
        //同样使用accept()获取客户端的socket对象

        while (true){
            Socket client = server.accept();
            new Thread(){
                @Override
                public void run() {
                    try{
                        //获取网络字节输入流
                        InputStream is = client.getInputStream();
                        //读取客户端的请求信息的第一行
                        BufferedReader br=new BufferedReader(new InputStreamReader(is));
                        String line = br.readLine();//GET /day10_NetWorkProgramming/src/BS_BrowserServer/web/index.html HTTP/1.1
                        String[] arr = line.split(" ");
                        String htmlpath = arr[1].substring(1);// day10_NetWorkProgramming/src/BS_BrowserServer/web/index.html
                        System.out.println(htmlpath);
                        //创建一个本地字节收入流读取服务器磁盘web项目中的index.html文件
                        BufferedInputStream bis=new BufferedInputStream(new FileInputStream(htmlpath));
                        OutputStream out = client.getOutputStream();
                        //先写入下面三行HTTP协议响应头，固定写法
                        out.write("HTTP/1.1 200 OK\r\n".getBytes());
                        out.write("Content-Type:text/html\r\n".getBytes());
                        out.write("\r\n".getBytes());
                        //再将读取到的html文件写给客户端(浏览器)
                        byte[] bytes=new byte[1024];
                        int len=0;
                        while ((len=bis.read(bytes))!=-1){
                            out.write(bytes,0,len);
                        }
                        //关闭资源
                        bis.close();
                        br.close();
                        client.close();
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                }
            }.start();
        }


        //server.close();
    }
}
