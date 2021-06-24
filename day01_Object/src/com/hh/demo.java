package com.hh;

import java.io.*;
import java.net.Socket;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: lianghaohong
 * @date: 2021/4/20
 * @time: 11:33 上午
 * Copyright (C) 2021 Meituan All rights reserved
 */
public class demo {
    //给定一个目录，递归打印里面的文件
    public static  void getAllFiles(File dir){
//        System.out.println(dir);//先输出一下当前遍历的目录
//        File[] files = dir.listFiles();
//        for(File f:files){
//            if (f.isDirectory()){//是目录接着递归
//                getAllFiles(f);
//            }else{//不是目录直接打印
//                System.out.println(f);
//            }
//        }
        System.out.println(dir);
        File[] files = dir.listFiles();
        for (File file:files){
            if (file.isDirectory()){
                getAllFiles(file);//说明还是目录
            }else{
                System.out.println();
            }
        }


    }


    //上传文件到服务器
    public static void uploadFileClient() throws IOException {
        //先读区本地文件
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("/xxx"));

        Socket client=new Socket("localhost",2222);
        OutputStream os = client.getOutputStream();
        int len=0;
        byte[] bytes=new byte[1024];
        while ((bis.read())!=-1){
            os.write(bytes,0,len);
        }
        client.shutdownOutput();//这句话一定要记得关闭


        //获取服务器返回的数据
        InputStream in = client.getInputStream();

    }

    public static void main(String[] args) throws IOException {

        System.out.println(IDs.values());//枚举数组
        //把枚举数组转化为
        Map<Integer,String> kvMap = Arrays.stream(IDs.values()).collect(Collectors.toMap(IDs::getCode, IDs::getName));
        System.out.println(kvMap);
    }
}
