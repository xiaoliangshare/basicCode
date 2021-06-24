package StringReader;

import java.io.FileInputStream;
import java.io.IOException;

/*
      使用字节流读取中文文件
      1个中文
            GBK：占用2个字节
            UTF-8：占用3个字节
            Windows系统的中文编码默认是GBK编码表。 idea中是UTF-8
            但是fis.read()一次只能读取一个字节，意思是只能读取1/3个中文，自然就乱码了
            解决：
                 1、采用fis.read(byte[] bytes)，其中new byte[buffer]，buffer>=2 or 3, 看编码格式
                 2、采用字符流FileReader
*/
public class ByteInputLimition {
    public static void main(String[] args) throws IOException {
        FileInputStream fis=new FileInputStream("day08_IO\\src\\ByteOutputStream\\out.txt");
        //采用一次读取一个字节
        byte[] bytes=new byte[1024];
        int len=0;
        while ((len=fis.read(bytes))!=-1){
            System.out.print(new String(bytes,0,len));//228 189 160 229 165 189 ä½ å¥½
        }
        fis.close();
    }
}
