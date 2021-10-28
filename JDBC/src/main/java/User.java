import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description:
 * @author: lianghaohong
 * @date: 2021/10/27
 * @time: 5:31 下午
 * Copyright (C) 2021 Meituan All rights reserved
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    /**
     * 此处的属性需要和数据库的字段一致才行
     */
    private int id;
    private String username;
    private String password;
}
