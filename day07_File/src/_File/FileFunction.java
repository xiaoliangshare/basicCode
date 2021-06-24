package _File;/*
    File类常用的方法：
        1、获取功能的方法
            public String getAbsolutePath() ：返回此File的绝对路径名字符串。
            public String getPath() ：将此File转换为路径名字符串。
            public String getName() ：返回由此File表示的文件或目录的名称。==同时也是把File类型转换为String类型
            public long length() ：返回由此File表示的文件的长度。

        2、判断功能的方法
            public boolean exists() ：此File表示的文件或目录是否实际存在。
            public boolean isDirectory() ：此File表示的是否为目录。
            public boolean isFile() ：此File表示的是否为文件。

        3、创建删除功能的方法
            public boolean createNewFile() ：当且仅当具有该名称的文件尚不存在时，创建一个新的空文件。
            public boolean delete() ：删除由此File表示的文件或目录。
            public boolean mkdir() ：创建由此File表示的目录。
            public boolean mkdirs() ：创建由此File表示的目录，包括任何必需但不存在的父目录。

       4、目录的遍历
           public String[] list() ：返回一个String数组，表示该File目录中的所有下一级子文件或目录。
           public File[] listFiles() ：返回一个File数组，表示该File目录中的所有下一级子文件或目录。



*/

import java.io.File;
import java.io.IOException;

public class FileFunction {
    public static void main(String[] args) throws IOException {
        //getFunction();
        //judge();
        //creatAndDeleteFile();
        traversFile();
    }

    //获取功能
    public static void getFunction(){
        File f = new File("E:\\basicCode\\day07_File\\src\\_File.FileDemo.java");
        System.out.println("文件绝对路径:"+f.getAbsolutePath());
        System.out.println("文件构造路径:"+f.getPath());
        System.out.println("文件名称:"+f.getName());
        System.out.println("文件长度:"+f.length()+"字节");
        File f2 = new File("E:\\basicCode\\day07_File\\src");
        System.out.println("目录绝对路径:"+f2.getAbsolutePath());
        System.out.println("目录构造路径:"+f2.getPath());
        System.out.println("目录名称:"+f2.getName());
        System.out.println("目录长度:"+f2.length());
    }

    //判断功能的方法
    public static void judge(){
        File file=new File("E:\\basicCode\\day07_File\\src\\_File.FileDemo.java");
        System.out.println(file.isFile());     //true
        System.out.println(file.isDirectory());//false
        System.out.println(file.exists());     //true
        File file1=new File("E:\\basicCode\\day07_File\\src");
        System.out.println(file1.isFile());     //false
        System.out.println(file1.isDirectory());//true
        System.out.println(file1.exists());     //true

        /*
            注意：isFile()和isDirectory()这两个方法是互斥的，使用的前提下路径必须是存在的，否则都返回false
            一般使用套路如下：
        */
        if (file1.exists()){
            System.out.println(file1.isFile());     //false
            System.out.println(file1.isDirectory());//true
        }
    }


    //创建删除功能的方法
    public static void creatAndDeleteFile() throws IOException {
         /*
            我们要在 "E:\basicCode\day07_File" 目录下创建1.txt这个文件
            注意：
                 1、此方法只能创建文件，不能创建文件夹
                 2、创建文件的路径必须存在，否则会抛出异常
         */
        //绝对路径，创建成功返回true
        File file=new File("E:\\basicCode\\day07_File\\1.txt");
        boolean b1 = file.createNewFile();
        System.out.println(b1);
        //相对路径(推荐)
        File file1=new File("day07_File\\3.txt");
        System.out.println(file1.createNewFile());
        //路径不存在
        //_File file2=new _File("day07_Fil\\3.txt");//IOException: 系统找不到指定的路径。因为day07_Fil写错了
        //System.out.println(file2.createNewFile());
        //---------------------------------------------
        //创建文件夹
        File file3=new File("day07_File\\src\\Demo");
        System.out.println(file3.mkdir());
        //创建多级文件夹(推荐用mkdirs(),单级和多级都可以创建)
        File file4=new File("day07_File\\src\\11\\22\\33");
        System.out.println(file4.mkdirs());
        //---------------------------------------------
        /*
              删除文件或者目录：delete()是直接删除磁盘上的文件/目录，不走回收站，删除需要谨慎
                  true: 文件/目录删除成功
                  false：文件夹中有内容/构造方法中路径不存在
        */
        File file5=new File("day07_File\\src\\Demo");
        System.out.println(file5.delete());
    }


    //遍历一个目录中的所有下一级文件和目录
    public static void traversFile(){
        File file=new File("day07_File\\src");
        String[] arr = file.list();
        for(String fileName:arr){
            System.out.println(fileName); //11  Demo  _File  Path
        }

        File file1=new File("day07_File\\src");
        File[] files = file1.listFiles();
        for(File f:files){
            System.out.println(f);
        }
        /*
        listFiles()只会遍历指定目录下面的一级文件和目录，没有子目录下的（文件/目录）
            day07_File\src\11
            day07_File\src\Demo
            day07_File\src\Path
            day07_File\src\_File

         解决办法：见Practice案例
                我们获取到下面的一级文件/目录时，判断一下
                if(f.isDirectory()){
                    getAllFile(f);
                }else{
                    System.out.println(f);
                }

        */

    }
}
