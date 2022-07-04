package com.hh.inteceptor;

import org.apache.kafka.clients.producer.ProducerInterceptor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Map;

/**
 * @description: 计数拦截器：统计发送成功条数，失败条数
 * (其实这块可以写到TimeInterceptor一起，只是为了解偶便于理解才分开写)
 * @author: lianghaohong
 * @date: 2022/6/27
 * @time: 8:50 上午
 * Copyright (C) 2021 Meituan All rights reserved
 */
public class CounterInterceptor implements ProducerInterceptor<String, String> {

    private Integer successCount;
    private Integer errorCount;

    @Override
    public ProducerRecord<String, String> onSend(ProducerRecord<String, String> producerRecord) {
        // 这块必须返回
        return producerRecord;
    }

    @Override
    public void onAcknowledgement(RecordMetadata recordMetadata, Exception e) {
        if (recordMetadata != null) {
            successCount++;
        } else {
            errorCount++;
        }
    }

    @Override
    public void close() {
        System.out.println("successCount:" + successCount + "，errorCount:" + errorCount);
    }

    @Override
    public void configure(Map<String, ?> map) {

    }
}
