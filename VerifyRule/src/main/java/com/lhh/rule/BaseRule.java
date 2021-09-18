package com.lhh.rule;

import com.lhh.entity.TransactionCstRes;

/**
 * @description:
 * @author: lianghaohong
 * @date: 2021/9/16
 * @time: 10:41 上午
 * Copyright (C) 2021 Meituan All rights reserved
 */

// 规则抽象
public interface BaseRule {
    boolean execute(TransactionCstRes transactionCstRes);
}
