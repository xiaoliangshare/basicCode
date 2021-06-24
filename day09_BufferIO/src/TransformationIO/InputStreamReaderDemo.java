package TransformationIO;

/*
      转换流 java.io.InputStreamReader extends Reader，说明它是个字符流，是从字节流到字符流的桥梁。
      它读取字节，并使用指定的字符集将其解码为字符。它的字符集可以由名称指定，也可以接受平台的默认字符集。
      1个中文
            GBK：占用2个字节
            UTF-8：占用3个字节, FireReader 只能默认读取UTF-8格式的编码,所以它一次能读3个字节，如果它去读
                   GBK文件，则相当于它一次读了（1+1/3=4/3）个字，肯定就乱码了。
      注意：
           从windows创建的文件，如果在IDEA再写内容，则你再在windows打开，原本windows上写的文字就又乱码了
           而且你再用InputStreamReader读也乱码，所以两边都乱码，解决方式是直接用IDEA来写 or 在windows写。
*/
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputStreamReaderDemo {
    public static void main(String[] args) throws IOException{
        readGBK();
        //readGBK1();
    }
    //用FileReader去读取windows上创建的GBK格式文件
    public static void readGBK() throws IOException{
        FileReader fr=new FileReader("day09_BufferIO\\src\\TestFile\\我是GBK文本.txt");
        char[] bytes=new char[1024];
        int len=0;//一次读取的有效字符个数
        while ((len=fr.read(bytes))!=-1){
            System.out.println(new String(bytes,0,len));
        }
        fr.close();
        /*
        结果：
            ����GBK��ʽ���ı�
        原因：
            "我是GBK文本.txt"是我在windows创建的，不是我们IDEA生成的文件，windows默认是GBK格式的编码。
             FileReader默认读取的是UTF-8格式的文件，所以我们用IDEA一打开 or 用FileReader去读取就看到一串乱码。
        */
    }

    //解决读取windows上创建的GBK格式文件乱码问题，采用转换流InputStreamReader
    private static void readGBK1() throws IOException {
        InputStreamReader isr=new InputStreamReader(
                new FileInputStream("day09_BufferIO\\src\\TestFile\\我是GBK文本.txt"),"GBK");
        char[] bytes=new char[1024];
        int len=0;//一次读取的有效字符个数
        while ((len=isr.read(bytes))!=-1){
            System.out.println(new String(bytes,0,len));
        }
        isr.close();
    }

}
