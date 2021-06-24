
/*
      函数式接口定义：有且只有一个抽象方法的接口，它与普通接口的区别就是我只有一个抽象方法
      @FunctionalInterface:
           一旦使用该注解来定义接口，编译器将会强制检查该接口是否确实有且仅有一个抽象方法，否则将会报错。
           需要注意的是，即使不使用该注解，只要满足函数式接口的定义，这仍然是一个函数式接口，使用起来都一样。
*/
@FunctionalInterface
public interface MyFunctionInterface {
    public abstract void method();
}
