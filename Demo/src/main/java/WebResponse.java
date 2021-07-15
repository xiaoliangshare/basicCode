/**
 * @description:
 * @author: lianghaohong
 * @date: 2021/7/15
 * @time: 8:51 上午
 * Copyright (C) 2021 Meituan All rights reserved
 */
public class WebResponse<T> {
    private String code;
    private String msg;
    private T data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    /**
     * 成功返回,静态方法是读取不到类的泛型T，在调用data的时候T取的才是具体类型
     * 记：就是我们在定义的时候泛型和规范一定要定义好，但是实际上我用不用可以随机选择
     * 下面的WebResponse<E>按道理可以不要<E>,但是最好写上<E>，实际用的时候就是来提高
     */
    public static <E> WebResponse<E> succ(E data){
        WebResponse<E> webResponse=new WebResponse<>();//所以你在创建泛型类对象的时候就时刻想着应该把泛型带上，不确定就用E
        webResponse.setCode("000");
        webResponse.setMsg("成功");
        webResponse.setData(data);//当你setData的时候就是把实际的E类型的data传递给了类类型的E
        return webResponse;
    }
}
