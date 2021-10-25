import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

/**
 * @description:
 * @author: lianghaohong
 * @date: 2021/10/25
 * @time: 10:42 上午
 * Copyright (C) 2021 Meituan All rights reserved
 */
public class PropertiesDemo {
    public static void main(String[] args) {
        Properties properties = new Properties();


        try {
            InputStream resourceAsStream = PropertiesDemo.class.getClassLoader().getResourceAsStream("jdbc.properties");
            properties.load(resourceAsStream);

//            URL resource = PropertiesDemo.class.getClassLoader().getResource("jdbc.properties");
//            String path = resource.getPath();
//            properties.load(new FileReader(path));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        System.out.println("url:" + url + ",user:" + user);

    }
}
/**
 * xxx.class.getClassLoader().getResourceAsStream(“constant.properties”);和xxx.class.getResourceAsStream("/config/constant.properties");都能读取到配置文件。不同的是，
 * xxx.class.getClassLoader().getResourceAsStream(“constant.properties”);这种读取方式需要把配置文件放到src的根目录下，getClassLoader()会读取bin的根目录，然后寻找constant.properties配置文件，如果没有在根目录下找到，就会报错。
 * 而xxx.class.getResourceAsStream("/config/constant.properties");这种读取方式就可以更自由一些了，它可以加载bin目录下一些复杂一点的目录下的配置文件，比如/config/constant.properties
 */