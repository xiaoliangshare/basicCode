package com.lhh.rule;

import com.lhh.entity.TransactionCstRes;

/**
 * @description: 规则模版
 * @author: lianghaohong
 * @date: 2021/9/16
 * @time: 10:44 上午
 * Copyright (C) 2021 Meituan All rights reserved
 */

public abstract class AbstractRule implements BaseRule {

    protected <T> T convert(TransactionCstRes transactionCstRes) {
        return (T) transactionCstRes;
    }

    protected <T> boolean executeRule(T t){
        return true;
    }

    /**
     * 重写BaseRule的 execute方法
     * @param transactionCstRes
     * @return
     */
    @Override
    public boolean execute(TransactionCstRes transactionCstRes) {
        return false;
    }
}
