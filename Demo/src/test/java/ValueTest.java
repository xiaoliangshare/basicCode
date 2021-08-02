import junit.framework.TestCase;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/**
 * @description:
 * @author: lianghaohong
 * @date: 2021/7/14
 * @time: 9:55 上午
 * Copyright (C) 2021 Meituan All rights reserved
 */
public class ValueTest extends TestCase {
    /**
     * 测试普通类中的泛型方法
     */
    @Test
    public void testgetValue(){
        Value value = new Value();
        List<Integer> value1 = value.getValue(100);
        System.out.println(value1);
    }

    @Test
    public void testLocalDate(){
//        LocalDate now = LocalDate.now();
//        System.out.println(now);
        BigDecimal bigDecimal = new BigDecimal(1);
        System.out.println(bigDecimal.multiply(new BigDecimal(-1)));

    }
}