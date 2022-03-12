import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: lianghaohong
 * @date: 2022/3/12
 * @time: 4:40 下午
 * Copyright (C) 2021 Meituan All rights reserved
 */
public class CombineTest {
    @Test
    public void testUser() {
        List<User> userList = new ArrayList<>();
        userList.add(new User("Lhh", 26));
        userList.add(new User("Lhh1", 27));

        List<Combine> combineList = userList.stream().map(Combine::new).collect(Collectors.toList());


        for (Combine combine : combineList) {
            User user = combine.getUser();
            System.out.println(user.getUsername());
        }
    }

    @Test
    public void testStudent() {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("1001", 12));
        studentList.add(new Student("1002", 13));
        List<Combine> combineList = studentList.stream().map(Combine::new).collect(Collectors.toList());

        for (Combine combine : combineList) {
            Student student = combine.getStudent();
            System.out.println(student.getAge());
        }

    }
}
