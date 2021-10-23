import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @description:
 * @author: lianghaohong
 * @date: 2021/10/23
 * @time: 10:17 下午
 * Copyright (C) 2021 Meituan All rights reserved
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Emp {
    private int id;
    private String username;
    private BigDecimal amount;
}
