import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

/**
 * @description: 使用jsoup解析Xml文件，快速入门
 * @author: lianghaohong
 * @date: 2021/11/3
 * @time: 6:14 下午
 * Copyright (C) 2021 Meituan All rights reserved
 */
public class XmlDemo {
    public static void main(String[] args) throws IOException {
        //我们只讲解服务端常用的解析Xml文档，常用Dom方式
        // 1、获取需要解析的xml文档路径
        String path = XmlDemo.class.getClassLoader().getResource("XmlDemo.xml").getPath();
        //2、将该文档加载进内存，获取dom树
        Document document = Jsoup.parse(new File(path), "utf-8");

        //3、根据标签名称获取元素对象 Elements对象, Elements extends ArrayList<Element>，可以把它看作是一个List<Element>的集合来使用
        Elements names = document.getElementsByTag("name");
        System.out.println(names.size()); // 有2个

        //获取第一个name对象的文本
        System.out.println(names.get(0).text());
        Element name1 = names.get(1);
        System.out.println(name1.text());
        Elements name = name1.getElementsByTag("name"); //Element同样有这个方法
        System.out.println("---------------------------------");
        String id = name.get(0).attr("id");
        System.out.println(id+"---");
        System.out.println(name);

        System.out.println(names);
        System.out.println(document.getElementById("id"));
    }
}
