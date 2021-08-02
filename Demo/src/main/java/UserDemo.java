/**
 * @description:
 * @author: lianghaohong
 * @date: 2021/7/28
 * @time: 9:35 下午
 * Copyright (C) 2021 Meituan All rights reserved
 */
public class UserDemo {
    public static void main(String[] args) {
        User user=new User();
        setUserName(user);
        System.out.println(user);

    }

    private static void setUserName(User user) {
        user.setUsername("lhh");
        user.setAge(12);
    }
}
