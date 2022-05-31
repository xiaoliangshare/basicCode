import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: lianghaohong
 * @date: 2022/5/30
 * @time: 7:39 下午
 * Copyright (C) 2021 Meituan All rights reserved
 */
public class ListDemo {
    public static void main(String[] args) {

        List<User> userList=null;
        userList.stream().forEach(System.out::println);

        Map<String,String> map=new HashMap<>();


        for (User user : userList) {
            map.put(user.getCode(),user.getName());
        }



    }
}
