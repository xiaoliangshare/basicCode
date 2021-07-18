import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @description:
 * @author: lianghaohong
 * @date: 2021/7/16
 * @time: 7:29 上午
 * Copyright (C) 2021 Meituan All rights reserved
 */
public class xintexing<F,T> {
    private F fData;
    private T tData;

    public void convertMethod(Converter<F,T> converter){
        T tData = converter.convert(fData);
        System.out.println(tData);
    }

    public static void main(String[] args) {
        xintexing<String, Integer> xintexing = new xintexing<>();
        xintexing.convertMethod(Integer::new);
    }

}
