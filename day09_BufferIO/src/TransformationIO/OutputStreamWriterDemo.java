package TransformationIO;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/*
      OutputStreamWriter extends Writer: 它也是一个字符流，字符流到字节流的桥梁，可以写入指定编码格式的文件
      构造方法：
          OutputStreamWriter(OutputStream in) : 创建一个使用默认字符集的字符流，不指定就默认UTF-8。
          OutputStreamWriter(OutputStream in, String charsetName) : 创建一个指定字符集的字符流。
*/
public class OutputStreamWriterDemo {
    public static void main(String[] args) throws IOException{
        OutputStreamWriter osw=new OutputStreamWriter(
                new FileOutputStream("day09_BufferIO\\src\\TestFile\\写出GBK文本.txt"),"GBK");
        osw.write("你好");
        osw.close();
    }
}
