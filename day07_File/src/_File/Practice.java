package _File;

import java.io.File;

/*
     递归遍历指定目录下的所有文件(包括子目录下面的文件，相当于遍历到最底层的文件)
*/
public class Practice {
    public static void main(String[] args) {
        File dir=new File("day07_File\\src");
        //getAllFile(dir);
        searchFile(dir);
    }

    //对给定目录进行遍历
    public static void getAllFile(File dir){
        System.out.println(dir);//打印被遍历的目录名称
        File[] files = dir.listFiles();
        for(File file:files){
            if (file.isDirectory()){ //如果是目录
                getAllFile(file);//递归调用
            }else{
                System.out.println(file); //如果是文件直接输出
            }
            /*  day07_File\src
                day07_File\src\11
                day07_File\src\11\22
                day07_File\src\11\22\33
                day07_File\src\Demo
                day07_File\src\Demo\111
                day07_File\src\Path
                day07_File\src\Path\pathDemo.java
                day07_File\src\_File
                day07_File\src\_File\FileDemo.java
                day07_File\src\_File\FileFunction.java
                day07_File\src\_File\Practice.java
                day07_File\src\_File\Recurison.java*/
        }
    }
    //搜索 day07_File\src 目录中的 .java 文件
    public static void searchFile(File dir){
        File[] files = dir.listFiles();
        for(File file:files){
            if (file.isDirectory()){
                searchFile(file);
            }else{
                //打印只有.java结尾的文件
                String fileName = file.getName();//File类型转换为String类型还可以用： String fileStr=file.toString()
                if (fileName.toLowerCase().endsWith(".txt"))//防止以 .TXT大写的文件
                    System.out.println(file);
            }
        }
    }


}
