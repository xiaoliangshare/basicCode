import java.util.function.Supplier;

/**
 * @description:
 * @author: lianghaohong
 * @date: 2021/7/16
 * @time: 10:09 上午
 * Copyright (C) 2021 Meituan All rights reserved
 */
public class EntityFactory {
    //获取任意对象
    public static <T> T getEntity(final Supplier<T> supplier) {
        return supplier.get();
    }

    public static void method(User user) {
        System.out.println(user.toString());
    }
}
