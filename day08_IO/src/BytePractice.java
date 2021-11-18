import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
       字节流练习：图片复制。
           原理就是一读一写，不仅仅是图片，所有类型的文件都可以用字节流来做
*/
public class BytePractice {
    public static void main(String[] args) throws IOException {
        //先要读取这张图片
        FileInputStream fis =new FileInputStream("E:\\1.jpg");
        FileOutputStream fos=new FileOutputStream("day08_IO\\test.jpg");
        byte[] bytes=new byte[1024];
        int len;//记录一次读取有效字节的个数
        while ((len=fis.read(bytes))!=-1){
            fos.write(bytes, 0 , len);
        }
        //流的关闭原则：先开后关，后开先关。
        fos.close();
        fis.close();
    }
}
/*
       记：以后用字节流读写的操作有两套组合
       注：字节数组就是一个byte数组，其元素取值是[-128，127]的数字

       1、读一个字节写一个字节（速度慢，不推荐）
            int len=0; //这个len是用来记录当前读到的字节数据
            while((len=fis.read())!=-1){
                 fos.write(len);
                 System.out.println((char)len);
            }
       2、使用数组缓冲区读写（推荐★★★★★）
           int len=0; //这个len是表示当前读取到的有效字节个数
           byte[] bytes=new byte[1024];
           while((len=fis.read(bytes))!=-1){
                fos.write(bytes,0,len);
                System.out.println(new String(bytes,0,len));//字节数组-->字符串
           }


       记：2个读方法，3个写方法
          public abstract int read() ： 读取文件中的一个字节并返回，读取到文件末尾返回-1
          public int read(byte[] b) ： 从输入流中读取一些字节数，并将它们存储到字节数组b中
          public void write(byte[] b) ：将 b.length字节从指定的字节数组写入此输出流。
          public void write(byte[] b, int off, int len) ：从指定的字节数组写入 len字节，从偏移量 off开始输 出到此输出流。
          public abstract void write(int b)：将指定的字节输出流。

         读写都有用read(byte[] b)和 write(byte[] b, int off, int len) 组合，即上述方法2
         单独写"xxx"字符串用 byte[] bytes="xxx".getBytes()和 fos.write(bytes)组合



*/