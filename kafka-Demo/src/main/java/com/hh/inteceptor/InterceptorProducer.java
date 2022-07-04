package com.hh.inteceptor;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

/**
 * @description:
 * @author: lianghaohong
 * @date: 2022/6/27
 * @time: 8:56 上午
 * Copyright (C) 2021 Meituan All rights reserved
 */
public class InterceptorProducer {
    public static void main(String[] args) {
        Properties properties = new Properties();

        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:8080");
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");

        // 添加拦截器
        List<String> list = new ArrayList<>();
        list.add("com.hh.inteceptor.TimeInterceptor");
        list.add("com.hh.inteceptor.CounterInterceptor");
        properties.put(ProducerConfig.INTERCEPTOR_CLASSES_CONFIG, list);

        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(properties);

        for (int i = 0; i < 100; i++) {
            producer.send(new ProducerRecord<>("first", "具体数据是String类型"), (recordMetadata, e) -> {
                // e==null 说明发送成功
                if (e == null) {
                    System.out.println("该消息生产到哪个分区：" + recordMetadata.partition() + "该消息生产到哪的offset" + recordMetadata.offset());
                } else {
                    e.printStackTrace();
                }
            });
        }

        // 必须要关闭，否则计数器结果不会打印
        producer.close();
    }
}
