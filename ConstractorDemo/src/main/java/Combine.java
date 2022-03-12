import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: lianghaohong
 * @date: 2022/3/12
 * @time: 4:28 下午
 * Copyright (C) 2021 Meituan All rights reserved
 */
public class Combine {
    private User user;
    private Student student;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Combine(User user) {
        this.user = user;
    }

    public Combine(Student student) {
        this.student = student;
    }
}
