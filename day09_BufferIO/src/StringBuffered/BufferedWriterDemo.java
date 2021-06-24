package StringBuffered;
/*
      BufferedWriter extends Writer: 就是比FileWriter速度快了，用法没区别
          构造方法：
                    BufferedWriter(Writer out): 创建一个默认大小输出缓冲区的缓冲字符输出流
                    BufferedWriter(Writer out,int size): 创建指定大小的字符输出流
*/
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterDemo {
    public static void main(String[] args) throws IOException{
        BufferedWriter bw=new BufferedWriter(new FileWriter("day09_BufferIO\\src\\TestFile\\2.txt"));
        for (int i = 0; i < 5; i++) {
            bw.write("hello World");
            //BufferedWriter特有的换行方法
            bw.newLine();
        }
        bw.close();
    }
}
/*
     总结：
         字符输出流的FileWriter和BufferedWriter都采用直接写字符串的形式，并且BufferedWriter速度快！
*/