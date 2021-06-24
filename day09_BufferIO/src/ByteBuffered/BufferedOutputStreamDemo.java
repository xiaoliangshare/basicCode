package ByteBuffered;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
      缓冲流,也叫高效流，是对4个基本的 FileXxx 流的增强，所以也是4个流，按照数据类型分类：
            字节缓冲流： BufferedInputStream ， BufferedOutputStream
            字符缓冲流： BufferedReader ， BufferedWriter

      BufferedOutputStream extends OutputStream:
            构造函数：
                    BufferedOutputStream(OutputStream out): 不指定大小就是默认缓冲区大小8192
                    BufferedOutputStream(OutputStream out,int size): int size 指定缓冲区大小
*/
public class BufferedOutputStreamDemo {
    public static void main(String[] args) throws IOException{
        BufferedOutputStream bos=new BufferedOutputStream(
                new FileOutputStream("day09_BufferIO\\src\\TestFile\\1.txt",true),1024*1024);
        for (int i = 0; i < 5; i++) {
            bos.write("你好，LHH".getBytes());
            bos.write("\r\n".getBytes());
        }
        bos.flush();//它和字符输出流Writer一样需要刷新
        bos.close();//close()会调用flush()方法,反正你用完之后记得关闭就行
    }
}
