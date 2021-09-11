import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @description:
 * @author: lianghaohong
 * @date: 2021/9/9
 * @time: 10:18 上午
 * Copyright (C) 2021 Meituan All rights reserved
 */
public class ArrayStackTest {
    /**
     * 添加元素
     */
    @Test
    public void testPush() {
        ArrayStack stack = new ArrayStack(3);
        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.printStack();
    }

    @Test
    public void testPop() {

    }

    @Test
    public void testBigDecimal() {
//        BigDecimal bigDecimal = new BigDecimal(BigInteger.ZERO);
//        bigDecimal = bigDecimal.add(new BigDecimal(10.123));
//        System.out.println(bigDecimal);
        BigDecimal total = new BigDecimal("0.00");
        for (int i = 0; i < 5; i++) {
            BigDecimal number = new BigDecimal("1.00");
            total = total.add(number);
        }
        System.out.println(total);
    }
}
