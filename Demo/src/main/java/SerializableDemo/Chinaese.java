package SerializableDemo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @description:
 * @author: lianghaohong
 * @date: 2021/11/18
 * @time: 8:24 下午
 * Copyright (C) 2021 Meituan All rights reserved
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Chinaese implements Serializable {
    private int area = 960;

}
