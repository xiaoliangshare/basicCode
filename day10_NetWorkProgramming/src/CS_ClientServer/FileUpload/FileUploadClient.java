package CS_ClientServer.FileUpload;

import java.io.*;
import java.net.Socket;
/*

*/
public class FileUploadClient {
    public static void main(String[] args) throws IOException{
        //先要读取客户端本地磁盘
        BufferedInputStream bis=new BufferedInputStream(
                new FileInputStream("day10_NetWorkProgramming\\src\\CS_ClientServer.FileUpload\\ClientDisk\\testClient.jpg"));
        //FileInputStream fis=new FileInputStream("day10_NetWorkProgramming\\src\\CS_ClientServer.FileUpload\\ClientDisk\\testClient.jpg");
        Socket client=new Socket("localhost",6666);
        OutputStream out = client.getOutputStream();
        byte[] bytes=new byte[1024];
        int len=0;
        while ((len=bis.read(bytes))!=-1){
            /*
              将读取到的文件写给服务器
                  bis.read(bytes)读取本地文件，结束标记是读取到-1结束，但是并不会把-1写给服务器，
                  所以服务器那边在读取客户端发给服务器端的数据时那个while循环一直在运行，因为它读不到-1
            */
            out.write(bytes,0,len);
        }
        /*
             解决上述问题： 就是客户端上传完文件之后，给服务器写一个结束标记就完了，这句话一定要写★★★★★
        */
        client.shutdownOutput();


        //上传完成之后接受服务器端的反馈
        InputStream in = client.getInputStream();
        byte[] msgFromServer=new byte[1024];
        //因为服务器端阻塞了，并没有回写数据给我，所以我这里压根就读取不到数据，因此我的read()也阻塞了，服务也不会停
        int read = in.read(msgFromServer);
        System.out.println(new String(msgFromServer,0,read));

        client.close();
        bis.close();

    }
}
