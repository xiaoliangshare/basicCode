package redisDemo;

//import org.springframework.data.redis.connection.jedis.JedisConnection;

import redis.clients.jedis.Jedis;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @description:
 * @author: lianghaohong
 * @date: 2021/12/20
 * @time: 7:38 下午
 * Copyright (C) 2021 Meituan All rights reserved
 */
public class RedisDemo {
    public static void main(String[] args) {
        //连接本地的 Redis 服务
        //Jedis jedis = new Jedis("localhost");
        //JedisConnection jedisConnection = new JedisConnection(jedis);
        //查看服务是否运行
        //System.out.println("服务器正在运行: "+jedis.ping());

        // 添加String类型的数据
        //jedis.set("username", "lhh");
        // 获取存储的数据并输出
        //System.out.println("redis 存储的字符串为: "+ jedis.get("username"));

        Map<String, String> map = new HashMap<>();
//        map.put("A", "11");
//        map.put("B", null);
//        map.put("C", null);
//        System.out.println(map);
//        System.out.println("B:" + map.get("B"));
//        System.out.println("C:" + map.get("C"));
//
//        //
//        System.out.println(Objects.equals(map.get("D"), "11"));
//        System.out.println(map.get("D"));

        System.out.println(new BigDecimal(1.235));
        System.out.println(new BigDecimal("1.235"));



    }
}
