package _File;

import java.io.File;

/*
         java.io.File类：
              "文件" 和 "目录" 路径名的抽象表示,主要用于文件和目录的创建、查找和删除等操作。
              java把电脑中的文件和文件夹(目录)封装为了一个File类，我们可以使用File类对文件和文件夹进行操作

         1、我们可以使用File类的方法
              创建一个文件/目录
              删除一个文件/目录
              获取一个文件/目录
              判断一个文件/目录是否存在
              对目录进行遍历
              获取文件的大小

         2、重点记住三个单词：
              file：文件
              directory：目录
              path：路径


         3、File类的构造方法：
                 public _File(String pathname) ：通过将给定的路径名字符串转换为抽象路径名来创建新的 File实例。
                 public _File(String parent, String child) ：从父路径名字符串和子路径名字符串创建新的 File实例。
                 public _File(_File parent, String child) ：从父抽象路径名和子路径名字符串创建新的 File实例。


*/
public class FileDemo {
    public static void main(String[] args) {
        //FileSeparator();
        //FileConstractor();
        FileConstractor2();
        FileConstractor3();
    }

    /*
             注意：以后开发中路径不能写死了
                   C:\develop\a\a.txt   windows
                   C:/develop/a/a.txt   Linux
                   例："C:"+File.separator+"develop"+File.separator+"a"+File.separator+"a.txt"
    */
    public static void FileSeparator(){
        //路径分隔符 windows是分号;    Linux下是冒号:
        System.out.println(File.pathSeparator);
        //文件名称分隔符  windows是反斜杠\   Linux是正斜杠/
        System.out.println(File.separator);
    }


    /*
        1、File(String pathname):----------用的最多
           String pathname：路径名称
               路径可以是以文件结尾，也可以是以目录结尾
               路径可以是相对路径(推荐)，也可以是绝对路径
               路径可以存在，也可以不存在
    */
    public static void FileConstractor(){
        File file=new File("E:\\basicCode\\day07_File\\srcFileDemo.java");//以文件结尾
        File file2=new File("E:\\basicCode\\day07_File");//以目录结尾
        File file3=new File("srcFileDemo.java");//相对路径
        File file4=new File("a.txt");//假路径
        //原样输出
        System.out.println(file);
        System.out.println(file2);
        System.out.println(file3);
        System.out.println(file4);
    }

    /*
        2、public File(String parent, String child)：
           参数：把路径分成了两部分
               String parent： 父路径
               String child： 子路径
           好处：
               父路径和子路径可以单独书写，且都可以变化
    */
    public static void FileConstractor2(){
        File file=new File("C:\\","c.txt");
        System.out.println(file);//C:\c.txt
    }

    /*
        3、public File(File parent, String child)：
           参数：把路径分成了两部分
               File parent： 父路径
               String child： 子路径
           好处：
               父路径和子路径可以单独书写，且都可以变化
               父路径是File类型，可以使用File的方法对路径进行一些操作，再使用路径创建对象
    */
    public static void FileConstractor3(){
        File parent=new File("C:\\");
        File file=new File(parent,"c.txt");
        System.out.println(file);//C:\c.txt
    }
}
