package StringWriter;

import java.io.FileWriter;
import java.io.IOException;

/*
        java.io.Writer:
                void write(int c) 写入单个字符。
                void write(char[] cbuf) 写入字符数组。
                abstract void write(char[] cbuf, int off, int len) 写入字符数组的某一部分,off数组的开始索引,len 写的字符个数。
                void write(String str) 写入字符串。
                void write(String str, int off, int len) 写入字符串的某一部分,off字符串的开始索引,len写的字符个数。
                void flush() 刷新该流的缓冲。
                void close() 关闭此流，但要先刷新它。
        java.io.FileWriter extends OutputStreamWriter extends Writer:是写出字符到文件的便利类。构造时使用系统默认的字符编码和默认字节缓冲区。
                构造方法：
                FileWriter(File file) ： 创建一个新的 FileWriter，给定要读取的File对象。
                FileWriter(String fileName) ： 创建一个新的 FileWriter，给定要读取的文件的名称。

       小贴士：
             字符流，只能操作文本文件，不能操作图片，视频等非文本文件。
             当我们单纯读或者写文本文件时使用字符流, 其他情况使用字节流。
*/
public class WriterDemo {
    public static void main(String[] args) throws IOException {
        //writerFile();
        //writerFile1();
        //writerFile2();
    }

    //写单个字节byte: write(int c)，单个字符char: write(int c)
    public static void writerFile()throws IOException{
        FileWriter fw=new FileWriter("day08_IO\\src\\StringWriter\\out.txt",true);
        fw.write(97); // 写出第1个字符
        fw.write('b'); // 写出第2个字符
        fw.write('C'); // 写出第3个字符
        fw.write(30000); // 写出第4个字符，中文编码表中30000对应一个汉字。
        /*
        【注意】关闭资源时,与FileOutputStream不同。 如果不关闭,数据只是保存到缓冲区，并未保存到文件。
                因为内置缓冲区的原因，如果不关闭输出流，无法写出字符到文件中。但是关闭的流对象，是无法继续写出数据的。
                如果我们既想写出数据，又想继续使用流，就需要 flush 方法了。
        */
        fw.flush();
        //即便是flush方法写出了数据，操作的最后还是要调用close方法，释放系统资源。
        fw.close();
    }



    //写字符数组char[]: write(char[] cbuf)
    public static void writerFile1()throws IOException{
        FileWriter fw=new FileWriter("day08_IO\\src\\StringWriter\\out.txt",true);
        // 字符串转换为字节数组
        char[] chars = "黑马程序员".toCharArray();
        // 写出字符数组
        fw.write(chars); // 黑马程序员
        // 写出从索引2开始，2个字节。索引2是'程'，两个字节，也就是'程序'。
        fw.write(chars,2,2); // 程序
        // 关闭资源
        fw.close();
    }


    //写字符串String： write(String str) 推荐★★★★★
    public static void writerFile2()throws IOException{
        FileWriter fw=new FileWriter("day08_IO\\src\\StringWriter\\out.txt",true);
        // 字符串
        String msg = "黑马程序员";
        // 写出字符数组
        fw.write(msg); //黑马程序员
        // 写出从索引2开始，2个字节。索引2是'程'，两个字节，也就是'程序'。
        fw.write(msg,2,2); // 程序
        // 关闭资源
        fw.close();
    }
}
