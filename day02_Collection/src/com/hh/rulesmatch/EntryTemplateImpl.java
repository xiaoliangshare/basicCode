package com.hh.rulesmatch;

import com.hh.entity.CalculatedTransaction;
import com.hh.entity.HiveAccountsDetailRule;
import com.hh.entity.KeepAccountRule;
import com.hh.entity.ProvisionOrder;

import java.util.List;

/**
 * @description:
 * @author: lianghaohong
 * @date: 2021/11/22
 * @time: 4:35 下午
 * Copyright (C) 2021 Meituan All rights reserved
 */
public class EntryTemplateImpl implements EntryTemplate {

    // 入账规则匹配统一方法
    @Override
    public HiveAccountsDetailRule detailRulesMatch(KeepAccountRule keepAccountRule, Object entryReceipt) {
        // 1、根据默认规则id查询明细规则
//        List<HiveAccountsDetailRule> detailRuleList = queryDetailRulesByKeepAccountRuleId(keepAccountRule.getId());
//        if (CollectionUtils.isNotEmpty(detailRuleList)) {
//            if (entryReceipt instanceof CalculatedTransaction) {
//                // 取出所有影响条件
//
//            } else if (entryReceipt instanceof ProvisionOrder) {
//
//            }
//        }


        return null;
    }
}
