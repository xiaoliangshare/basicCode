package StringBuffered;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
      BufferedReader extends Reader
            public BufferedReader(Reader in) ：创建一个新的缓冲输入流。
            public BufferedReader(Reader in,int size) ：创建一个指定缓冲区大小的新的缓冲输入流。

      方法:
            read()和read(char[] bytes): 和FileReader用法一样
            readLine()：一次读取一行字符串，这个非常有用，刷题经常用
*/
public class BufferedReaderDemo {
    public static void main(String[] args) throws IOException {
        //readFile();
        readFile1();
    }

    //read()和read(char[] bytes) 同样可以用，并且速度比FileReader快
    private static void readFile() throws IOException {
        BufferedReader br=new BufferedReader(new FileReader("day09_BufferIO\\src\\TestFile\\1.txt"));
        /*int read = br.read();
        System.out.println((char)read);*/

        char[] bytes=new char[1024];
        int len=0;
        while ((len=br.read(bytes))!=-1){
            System.out.println(new String(bytes,0,len));
        }
        br.close();
    }

    //readLine()
    private static void readFile1() throws IOException{
        BufferedReader br=new BufferedReader(new FileReader("day09_BufferIO\\src\\TestFile\\1.txt"));
        //BufferedReader br=new BufferedReader(new InputStreamReader(System.in)); 刷题的时候用这个
        String s;
        while ((s=br.readLine())!=null){
            System.out.println(s);
        }
        br.close();
    }
}
