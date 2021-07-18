import org.junit.Assert;
import org.junit.Test;

/**
 * @description:
 * @author: lianghaohong
 * @date: 2021/7/18
 * @time: 10:24 上午
 * Copyright (C) 2021 Meituan All rights reserved
 */

public class AssertDemo {
    @Test
    public void testAdd(){
        Calculate calculate = new Calculate();
        int result = calculate.add(1, 2);
        Assert.assertEquals("计算错误",3,result);
    }

    @Test
    public void testBool(){
        boolean bool=false;
        Assert.assertTrue("您传入的值为false",bool);
        System.out.println("校验通过");
    }

    @Test
    public void testNotNull(){
        //User user = new User();
        User user=null;
        Assert.assertNotNull("您传入的对象为空",user);
        System.out.println("校验通过");
    }
}
