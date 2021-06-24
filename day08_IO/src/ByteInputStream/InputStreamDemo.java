package ByteInputStream;

import java.io.FileInputStream;
import java.io.IOException;

/*
      java.io.InputStream: 字节输入流，可以读取字节信息到内存中
          public void close() ：关闭此输入流并释放与此流相关联的任何系统资源。
          public abstract int read() ： 读取文件中的一个字节并返回，读取到文件末尾返回-1
          public int read(byte[] b) ： 从输入流中读取一些字节数，并将它们存储到字节数组b中

     java.io.FileInputStream extends InputStream
     构造方法
          FileInputStream(File file) ： 通过打开与实际文件的连接来创建一个 FileInputStream ，该文件由文件系 统中的 File对象 file命名。
          FileInputStream(String name) ： 通过打开与实际文件的连接来创建一个 FileInputStream ，该文件由文件 系统中的路径名 name命名。

     String类的构造方法：
          String(byte[] bytes): 将字节数组转化为字符串
          String(byte[] bytes,int offset,int length): 将字节数组的一部分转化为字符串，offset：数组的开始索引，length：转换的字节个数

*/
public class InputStreamDemo {
    public static void main(String[] args) throws IOException{
        //getFile();
        //readFile1();
        readFile2();
    }

    public static void readFile() throws IOException{
        //指定你要读取哪个文件
        FileInputStream fis=new FileInputStream("day08_IO\\src\\ByteOutputStream\\out.txt");

        //读取文件read()，内容为abc，一次读一个字节
        int read = fis.read();
        System.out.println(read);//97
        System.out.println(fis.read());//98
        System.out.println(fis.read());//99
        System.out.println(fis.read());//-1
        System.out.println(fis.read());//-1
        //关闭资源
        fis.close();
    }

    /*
              发现readFile()读取文件是一个重复的过程，可以使用循环来优化
              不知道文件中有多少字节用while循环，结束条件为读取到-1
              这里read()还是一次读一个字节
    */
    public static void readFile1() throws IOException{
        FileInputStream fis=new FileInputStream("day08_IO\\src\\ByteOutputStream\\out.txt");
        int len=0; //记录读取到的字节数据
        while ((len=fis.read())!=-1){
            System.out.println((char)len);//abc
        }
        fis.close();
    }

    //read(byte[] b) 一次读取多个字节(推荐以后都用这个)
    public static void readFile2() throws IOException{
        FileInputStream fis=new FileInputStream("day08_IO\\src\\ByteOutputStream\\out.txt");
        byte[] bytes=new byte[1024];//一次读取1kb
        fis.skip(10);//跳过前面n个字节
        int len=0;//记录每次读取的有效字节【个数】
        while ((len=fis.read(bytes))!=-1){
            System.out.println(new String(bytes,0,len));//字节数组-->字符串
        }
        fis.close();
    }
}
