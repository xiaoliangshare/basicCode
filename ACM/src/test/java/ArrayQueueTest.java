import org.junit.Test;

/**
 * @description:
 * @author: lianghaohong
 * @date: 2021/9/27
 * @time: 10:24 上午
 * Copyright (C) 2021 Meituan All rights reserved
 */
public class ArrayQueueTest {
    @Test
    public void testEnqueue() {
        ArrayQueue arrayQueue = new ArrayQueue(10);
        arrayQueue.enqueue("LHH");
        arrayQueue.enqueue("LHH1");
        arrayQueue.enqueue("LHH2");
        arrayQueue.enqueue("LHH3");
        arrayQueue.printQueue();
        String dequeue = arrayQueue.dequeue();
        System.out.println(dequeue);
        System.out.println("队列的头指针为：" + arrayQueue.head);
        System.out.println("队列的尾指针为：" + arrayQueue.tail);
    }
}
