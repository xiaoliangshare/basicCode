/**
 * @description: 循环队列：解决了简单队列的数据搬移操作，关键点就是队列的判满、判空操作
 * 简单队列判空：head==tail，判满：tail=n
 * 循环队列判空：head=tail，判满：（tail+1）% n = head
 * @author: lianghaohong
 * @date: 2021/9/27
 * @time: 11:22 上午
 * Copyright (C) 2021 Meituan All rights reserved
 */
public class CircularQueue {
    public String[] items;
    public int n;
    public int head;
    public int tail;

    public CircularQueue(int capacity) {
        items = new String[capacity];
        n = capacity;
    }

    /**
     * 入队操作
     */
    public boolean enqueue(String item) {
        if ((tail + 1) % n == head) return false; //说明队列满了
        items[tail] = item;
        tail = (tail + 1) % n;
        return true;
    }

    /**
     * 出队操作
     */
    public String dequeue() {
        if (head == tail) return null; // 队列为空
        String ret = items[head];
        head = (head + 1) % n;
        return ret;
    }

}
