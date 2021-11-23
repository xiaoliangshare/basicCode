package com.hh.rulesmatch;

import com.hh.entity.HiveAccountsDetailRule;
import com.hh.entity.KeepAccountRule;

/**
 * @description: 入账规则模版类
 * @author: lianghaohong
 * @date: 2021/11/22
 * @time: 4:30 下午
 * Copyright (C) 2021 Meituan All rights reserved
 */
public interface EntryTemplate {

    //入账规则匹配
     HiveAccountsDetailRule detailRulesMatch(KeepAccountRule keepAccountRule, Object entryReceipt);

}
