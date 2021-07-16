/**
 * @description: 自定义类型转化方法
 * @author: lianghaohong
 * @date: 2021/7/16
 * @time: 8:24 上午
 * Copyright (C) 2021 Meituan All rights reserved
 */
@FunctionalInterface
public interface Converter<F,T> {
    T convert(F from);
}
//在课上学习泛型时，老师提到不能使用instanceof这个运算符来检验泛型类型的信息，因为“运行时泛型消失了”