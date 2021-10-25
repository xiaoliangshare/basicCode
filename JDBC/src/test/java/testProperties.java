import org.junit.Test;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

/**
 * @description:
 * @author: lianghaohong
 * @date: 2021/10/25
 * @time: 10:36 上午
 * Copyright (C) 2021 Meituan All rights reserved
 */
public class testProperties {
    @Test
    public void testPro() throws IOException {
        Properties properties = new Properties();
//        InputStream resourceAsStream = testProperties.class.getClassLoader().getResourceAsStream("jdbc.properties");
//        properties.load(resourceAsStream);

        URL resource = testProperties.class.getClassLoader().getResource("jdbc.properties");
        String path = resource.getPath();
        properties.load(new FileReader(path));

        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        System.out.println("url:" + url + ",user:" + user);


    }
}
