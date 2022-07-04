package com.hh;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

/**
 * @description:
 * @author: lianghaohong
 * @date: 2022/6/20
 * @time: 4:47 下午
 * Copyright (C) 2021 Meituan All rights reserved
 */
public class PartitionProducer {
    public static void main(String[] args) {
        Properties properties = new Properties();

        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:8080");
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        // 对自定义的分区类进行关联
        properties.put(ProducerConfig.PARTITIONER_CLASS_CONFIG,"com.hh.MyPartitioner");


        // 创建生产者
        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(properties);

        for (int i = 0; i < 100; i++) {
            producer.send(new ProducerRecord<>("first", "具体数据是String类型"), (recordMetadata, e) -> {
                // e==null 说明发送成功，而且可以通过回调函数来查看是否都发到一个分区上了
                if (e == null) {
                    System.out.println("该消息生产到哪个分区：" + recordMetadata.partition() + "该消息生产到哪的offset" + recordMetadata.offset());
                } else {
                    e.printStackTrace();
                }
            });
        }
    }
}
