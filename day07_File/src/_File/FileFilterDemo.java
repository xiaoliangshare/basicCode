package _File;

import java.io.File;
import java.io.FileFilter;

/*
     在File类中有两个和listFiles重载的方法，方法的参数就是过滤器
     1、File[] listFiles(FileFilter filter)（推荐）
           参数 FileFilter它是一个接口,接口中只有一个方法:
                boolean accept(File pathname) ：测试pathname是否应该包含在当前File的一级目录中，符合则返回true。


     2、File[] listFiles(FilenameFilter filter)
          参数 FilenameFilter filter接口：实现此接口的类实例可以用于过滤文件名
                boolean accept(File dir, String name) ：测试指定文件是否应该包含在某一目录中
*/
public class FileFilterDemo {
    public static void main(String[] args) {
        File dir = new File("D:\\aaa");
        printDir2(dir);
    }
    public static void printDir2(File dir) {
        // 匿名内部类方式,创建过滤器子类对象
        File[] files = dir.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(".java")||pathname.isDirectory();
            }
        }
        );
        // 循环打印
        for (File file : files) {
            if (file.isFile()) {
                System.out.println("文件名:" + file.getAbsolutePath());
            } else {
                printDir2(file);
            }
        }
    }
}
