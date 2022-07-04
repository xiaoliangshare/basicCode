package com.hh;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Arrays;
import java.util.Properties;

/**
 * @description: 简单消费者
 * @author: lianghaohong
 * @date: 2022/6/20
 * @time: 5:31 下午
 * Copyright (C) 2021 Meituan All rights reserved
 */
public class MyConsumer {

    public static void main(String[] args) {
        Properties properties = new Properties();

        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:8080");
        // 开启自动提交
        properties.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, true);
        // 自动提交延时
        properties.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "1000");
        // Key,Value的反序列化
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");

        // 消费者组
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, "test_group");

        // 创建一个消费者
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(properties);
        // 订阅多个主题
        consumer.subscribe(Arrays.asList("firstTopic", "secondTopic"));
        // 如果订阅单个主题
        //consumer.subscribe(Collections.singletonList("firstTopic"));

        // 这里是records，说明一次可以消费多条数据
        while (true) {
            ConsumerRecords<String, String> consumerRecords = consumer.poll(100L);
            for (ConsumerRecord<String, String> consumerRecord : consumerRecords) {
                System.out.println(consumerRecord.key() + "---" + consumerRecord.value());
            }
        }
        //consumer.close();

    }
}
