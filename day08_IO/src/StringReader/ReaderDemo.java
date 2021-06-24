package StringReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/*
      java.io.Reader: 字符输入流，也是一个抽象类
            public void close() ：关闭此流并释放与此流相关联的任何系统资源。
            public int read() ： 从输入流读取一个字符。
            public int read(char[] cbuf) ： 从输入流中读取一些字符，并将它们存储到字符数组 cbuf中 。

      java.io.FileReader extends InputStreamReader extends Reader
            FileReader(File file) ： 创建一个新的 FileReader ，给定要读取的File对象。
            FileReader(String fileName) ： 创建一个新的 FileReader，给定要读取的文件的名称。
*/
public class ReaderDemo {
    public static void main(String[] args) throws IOException {
        FileReader fr=new FileReader("day08_IO\\src\\ByteOutputStream\\out.txt");
        //一次读取一个字符,为什么还是int，只是返回这个读到的字符的int值
        /*int len=0;
        while ((len=fr.read())!=-1){
            System.out.println((char)len);
        }*/



        //一次读取多个字符
        char[] bytes=new char[1024];
        int len=0;
        while ((len=fr.read(bytes))!=-1){
            System.out.println(Arrays.toString(bytes));
            System.out.println(new String(bytes,0,len));
        }
        //同样关闭资源
        fr.close();
    }
}
