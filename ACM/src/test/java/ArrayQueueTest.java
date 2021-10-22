import org.junit.Test;

import java.math.BigDecimal;

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

    @Test
    public void testBigDecimal(){
        BigDecimal bigDecimal = new BigDecimal(1.12345678);
        BigDecimal multiply = bigDecimal.multiply(new BigDecimal(-1)).setScale(2, BigDecimal.ROUND_HALF_UP);
        System.out.println(multiply);
    }


    @Test
    public void testCompairToTime(){
        String operateTime="2021-07-01 20:26:44";
        String beginDateStr="2021-07-01";
        System.out.println(operateTime.compareTo(beginDateStr));
    }
}
