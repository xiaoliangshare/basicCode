package ByteOutputStream;

import java.io.FileOutputStream;
import java.io.IOException;

/*
     追加写和写换行：
         构造方法：
         public FileOutputStream(File file,boolean append) ：创建文件输出流以写入由指定的 File对象表示的文件。
         public FileOutputStream(String name,boolean append) ： 创建文件输出流以指定的名称写入文件
         参数：
              String name,File file: 写入数据的目的地
              boolean append：追加写开关，默认为false，每次执行创建一个新的同名文件覆盖原文件，true表示继续在文件的末尾追加数据

      换行格式：
          windows: \r\n
          linux: /n
          mac: /r

*/
public class OutputStreamDemo1 {
    public static void main(String[] args) throws IOException {
        appendWrite();
    }
    //追加写
    public static void appendWrite() throws IOException{
        FileOutputStream fos =new FileOutputStream("day08_IO/src/ByteOutputStream/out1.txt",true);

        String s="你好，浩宏";
        byte[] bytes = s.getBytes();
        for (int i = 0; i < 5; i++) {
            fos.write(bytes);
            fos.write("\r\n".getBytes());//换行写，每写完一次换行
        }
        fos.close();
    }
}
