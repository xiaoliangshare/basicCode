import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: lianghaohong
 * @date: 2022/6/29
 * @time: 8:38 下午
 * Copyright (C) 2021 Meituan All rights reserved
 */
public class KafkaTest {
    @Test
    public void testList() {
        Long l=1L;
        List<String> list =new ArrayList<>();


        list = list.stream().filter(item -> StringUtils.isNotBlank(item)).collect(Collectors.toList());

        System.out.println(list);


    }
}
