package com.hh;

import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;
import org.apache.kafka.common.PartitionInfo;

import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: lianghaohong
 * @date: 2022/6/20
 * @time: 4:26 下午
 * Copyright (C) 2021 Meituan All rights reserved
 */
public class MyPartitioner implements Partitioner {
    @Override
    public int partition(String topic, Object key, byte[] keyBytes, Object value, byte[] valueBytes, Cluster cluster) {

        // 比如说我按照key进行自定义分区
        List<PartitionInfo> partitionInfos = cluster.availablePartitionsForTopic(topic);// 获取可用的分区
        int partition = key.toString().hashCode() & partitionInfos.size();
        return partition;
    }

    @Override
    public void close() {
        // 可以不用管
    }

    @Override
    public void configure(Map<String, ?> map) {
        // 可以不用管
    }
}
