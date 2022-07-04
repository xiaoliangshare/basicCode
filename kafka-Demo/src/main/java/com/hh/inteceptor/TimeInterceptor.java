package com.hh.inteceptor;

import org.apache.kafka.clients.producer.ProducerInterceptor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Map;

/**
 * @description: 在消息体前面加时间戳
 * @author: lianghaohong
 * @date: 2022/6/27
 * @time: 8:42 上午
 * Copyright (C) 2021 Meituan All rights reserved
 */
public class TimeInterceptor implements ProducerInterceptor<String, String> {

    @Override
    public void configure(Map<String, ?> map) {

    }

    @Override
    public ProducerRecord<String, String> onSend(ProducerRecord<String, String> producerRecord) {
        // 取出数据
        String value = producerRecord.value();

        // 因为value不可改，只能新创建一个producer
        ProducerRecord<String, String> record = new ProducerRecord<>(producerRecord.topic(), producerRecord.partition(), producerRecord.key(),
                System.currentTimeMillis() + "-" + value);
        return record;
    }

    @Override
    public void onAcknowledgement(RecordMetadata recordMetadata, Exception e) {

    }

    @Override
    public void close() {

    }


}
