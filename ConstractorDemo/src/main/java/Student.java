import lombok.Data;

/**
 * @description:
 * @author: lianghaohong
 * @date: 2022/3/12
 * @time: 4:27 下午
 * Copyright (C) 2021 Meituan All rights reserved
 */
@Data
public class Student {
    private String stuNum;
    private Integer age;

    public Student(String stuNum, Integer age) {
        this.stuNum = stuNum;
        this.age = age;
    }

    public String getStuNum() {
        return stuNum;
    }

    public void setStuNum(String stuNum) {
        this.stuNum = stuNum;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
