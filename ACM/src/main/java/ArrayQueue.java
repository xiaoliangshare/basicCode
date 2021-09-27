/**
 * @description: 基于数组实现的队列，最简单的队列
 * @author: lianghaohong
 * @date: 2021/9/27
 * @time: 10:11 上午
 * Copyright (C) 2021 Meituan All rights reserved
 */
public class ArrayQueue {
    private String[] items;
    /**
     * 数组的长度
     */
    public int n;
    /**
     * 队头下标，空队列时指向0
     */
    public int head;
    /**
     * 队尾下标，空队列时指向0
     */
    public int tail;

    public ArrayQueue(int capacity) {
        items = new String[capacity];
        this.n = capacity;
    }

    /**
     * 入队操作：从队尾插入元素
     */
    public boolean enqueue(String item) {
        if (tail == n) return false; //表示队满了
        items[tail] = item;
        tail++;
        return true;
    }

    /**
     * 出队操作：从队头删除元素
     */
    public String dequeue() {
        if (head == tail) return null; //表示空队列
        return items[head++];
    }

    /**
     * 打印队列元素：遍历items数组，打印数组元素即可
     */
    public void printQueue() {
        String temp = "[";
        for (int i = 0; i < items.length; i++) {
            if (i == items.length - 1) {
                temp += items[i] + "]";
            } else {
                temp += items[i] + ",";
            }
        }
        System.out.println(temp);
    }
}
