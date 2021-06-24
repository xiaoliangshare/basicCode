package ByteOutputStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

/*
    OutputStream: 是一个抽象类，表示字节输出流的所有类的超类，共有5大方法：
         public void close() ：关闭此输出流并释放与此流相关联的任何系统资源。
         public void flush() ：刷新此输出流并强制任何缓冲的输出字节被写出。
         public void write(byte[] b) ：将 b.length字节从指定的字节数组写入此输出流。
         public void write(byte[] b, int off, int len) ：从指定的字节数组写入 len字节，从偏移量 off开始输 出到此输出流。
         public abstract void write(int b)：将指定的字节输出流。

    由于OutputStream是abstract类，所以我们必须使用它的子类，主要用FileOutputStream
    FileOutputStream extends OutputStream：文件字节输出流，作用是把内存中的数据写到磁盘文件中

    构造方法：
         public FileOutputStream(File file) ：创建文件输出流以写入由指定的 File对象表示的文件。
         public FileOutputStream(String name) ： 创建文件输出流以指定的名称写入文件
         参数：写入数据的目的
               String name: 目的地是一个文件的路径
               File file：目的地是一个文件
         构造方法的作用：
               1、创建一个FileOutputStream对象
               2、会根据构造方法中传递的文件/文件路径，创建一个空的文件
               3、会把FileOutputStream对象指向创建好的文件

     写出数据的原理（内存-->磁盘）：
         java程序--->JVM--->OS--->OS调用写数据的方法--->把数据写出到文件


*/
public class OutputStreamDemo {
    public static void main(String[] args) throws IOException { //IOException
        //writeOneByte();
        //writeManyByte();
        writeString();
    }

    //一次写一个字节的方法write(int b)
    public static void writeOneByte() throws IOException {
        //1、指定你要把数据写到哪个文件,上下两句话等效
        FileOutputStream fos=new FileOutputStream("day08_IO\\src\\ByteOutputStream\\out.txt");
        //FileOutputStream fos=new FileOutputStream(new File("day08_IO\\src\\ByteOutputStream\\out.txt"));

        //2、调用write()写数据,一次只能写一个字节
        fos.write(97); //a
        fos.write(98);
        fos.write(99);
        fos.write(1278);//乱码
        //释放资源（流使用会占用一定的内存，使用完毕要把内存清空，提高资源利用率）
        fos.close();
        /*
          执行完之后out.txt文件中有一个a
          [0,127]：查询ASCII表
          其他值：查询系统默认编码表（中公系统GBK）
        */
    }

    //一次写多个字节的方法 write(byte[] b)
    public static void writeManyByte() throws IOException{
        FileOutputStream fos=new FileOutputStream("day08_IO\\src\\ByteOutputStream\\out.txt");
        byte[] bytes={65,66,67,68,69};//ABCDE
        byte[] bytes1={-65,66,67,68,69};//�BCDE
        fos.write(bytes1);
        /*
             如果第一个字节是正数，则直接查询ASCII表
             如果第一个字节是负数，则第一个字节和第二个字节会组成一个中文显示，查询GBK
        */

        /*
            write(byte[] b, int off, int len) 把字节数组的一部分写入文件中
                 int off: 数组的开始索引
                 int len: 写几个字节
         */
         fos.write(bytes,0,2);//AB
         //关闭资源
         fos.close();
    }

    //例：写入指定字符串的方法
    public static void writeString() throws IOException{
        FileOutputStream fos=new FileOutputStream("day08_IO\\src\\ByteOutputStream\\out.txt");
        //把字符串转换为字节数组
        byte[] bytes = "你好".getBytes();
        System.out.println(Arrays.toString(bytes));//[-28, -67, -96, -27, -91, -67] Arrays.toString(bytes)重写了toString()
        fos.write(bytes);
        fos.close();

    }
}
