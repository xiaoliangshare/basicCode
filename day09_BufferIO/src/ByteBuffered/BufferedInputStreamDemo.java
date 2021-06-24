package ByteBuffered;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/*
        BufferedInputStream extends InputStream:
             BufferedInputStream(InputStream in):
             BufferedInputStream(InputStream in,int size):

        总结：
            其实BufferedInputStream和BufferedOutputStream相比FileInputStream和FileOutputStream就是提高了读取速度,
            把他俩给包装了一下，加了个加速器，包括字符缓冲流也一样，其使用方式一点都没变。
*/
public class BufferedInputStreamDemo {
    public static void main(String[] args) throws IOException {
        //BufferedByteRead();
        ByteRead();

    }

    private static void ByteRead() throws IOException {
        long start=System.currentTimeMillis();
        FileInputStream fis=new FileInputStream("day09_BufferIO\\src\\TestFile\\1.txt");
        byte[] bytes=new byte[1024];
        int len=0;//记录的是读取的有效字节个数
        while ((len=fis.read(bytes))!=-1){
            System.out.println(new String(bytes,0,len));
        }
        fis.close();
        long end=System.currentTimeMillis();
        System.out.println("总共耗时："+(end-start));//5秒
    }

    private static void BufferedByteRead() throws IOException{
        long start=System.currentTimeMillis();
        BufferedInputStream bis=new BufferedInputStream(new FileInputStream("day09_BufferIO\\src\\TestFile\\1.txt"));
        byte[] bytes=new byte[1024];
        int len=0;//记录的是读取的有效字节个数
        while ((len=bis.read(bytes))!=-1){
            System.out.println(new String(bytes,0,len));
            //bos.write(bytes,0,len);
        }
        bis.close();
        long end=System.currentTimeMillis();
        System.out.println("总共耗时："+(end-start));//3秒
    }


}
