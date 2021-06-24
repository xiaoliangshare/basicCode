package CS_ClientServer.FileUpload;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/*
      客户端将文件上传到服务器，服务器将文件保存在服务器的文件上
*/
public class FileUploadServer {
    public static void main(String[] args) throws IOException {
        System.out.println("服务器开始启动......");
        ServerSocket server=new ServerSocket(6666);
        /*
               我么可以让服务器一直处于监听状态：即死循环accept(),并且不用关闭server对象
        */
        while (true){
            Socket client = server.accept();
            /*
                 多线程思维：我们可以使用多线程技术提高线程效率，这里已经能获取到不同的client对象，
                 再针对每个client_i做上传任务
                 Socket client_1 = server.accept();
                 Socket client_2 = server.accept();
                 Socket client_3 = server.accept();
                         ......
                 Socket client_n = server.accept();
                 只要有一个客户端上传文件，就开启一个线程完成上传任务。多线程的优势就是在处理"多"上
            */
            new Thread(
                    new Runnable() {
                        @Override
                        public void run() {//run()里面完成文件上传的代码
                            //由于run()没有抛出异常，所以我们要用try-catch处理
                            try{
                                InputStream is = client.getInputStream();
                                //将从客户端读取到的文件写到服务器磁盘上
                                File file=new File("day10_NetWorkProgramming\\src\\CS_ClientServer.FileUpload\\ServerDisk");
                                if (!file.exists()){//如果不存在上述目录我就创建一个
                                    file.mkdirs();
                                }
                                //自定义文件命名规则，防止同名文件被覆盖：上传时间+随机数.jpg
                                SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd_HHmmss");
                                String uploadTime = sdf.format(new Date());
                                String filename=file.toString()+"\\"+uploadTime+"_"+new Random().nextInt(999)+".jpg";
                                BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream(filename));
                                //FileOutputStream fos=new FileOutputStream("day10_NetWorkProgramming\\src\\CS_ClientServer.FileUpload\\ServerDisk\\testServer.jpg");
                                byte[] bytes=new byte[1024];
                                int len=0;
                                while ((len=is.read(bytes))!=-1){
                                /*
                                   我现在读到了客户端传来的文件，我得把它写到服务器磁盘，这个while一直在循环，因为客户端不会把-1结束标记给我
                                   因此进入了阻塞状态，下面的 out.write("上传成功".getBytes());根本就不会执行，因为我一直在这里循环，说以服务也不会停止。
                                */
                                    bos.write(bytes,0,len);
                                }
                                //写完之后服务器告诉一下客户端上传成功
                                OutputStream out = client.getOutputStream();
                                out.write("上传成功".getBytes());//直接协写回的是字节数据
                                bos.close();
                                client.close();
                            }catch (IOException e){
                                e.printStackTrace();
                            }
                        }
                    }
            ).start();
        }
        //server.close();
    }
}
/*
     ()->{
        ...
     }
*/