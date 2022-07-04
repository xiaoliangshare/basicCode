package com.hh;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

/**
 * @description:
 * @author: lianghaohong
 * @date: 2022/6/20
 * @time: 9:29 上午
 * Copyright (C) 2021 Meituan All rights reserved
 */
public class MyProducer {
    public static void main(String[] args) {
        // 创建kafka创建信息
        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:8080");
        // 等待所有副本节点的应答
        properties.put("acks", "all");
        // 消息发送最大尝试次数
        properties.put("retries", 0);
        // 一批消息处理大小，16K
        properties.put("batch.size", 16384);

        // 请求延时: 当生产的数据没达到16K，
        properties.put("linger.ms", 1);
        properties.put("buffer.memory", 33554432);
        // key序列化
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        // value序列化
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        KafkaProducer<String, String> producer = new KafkaProducer<>(properties);
        for (int i = 0; i < 50; i++) {
            producer.send(new ProducerRecord<String, String>("first", Integer.toString(i), "hello world-" + i));
        }

        // 关闭资源
        producer.close();
    }
}
