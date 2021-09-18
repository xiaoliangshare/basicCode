package com.lhh.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @description: 对接外部系统的接口字段（36）
 * @author: lianghaohong
 * @date: 2021/9/16
 * @time: 10:32 上午
 * Copyright (C) 2021 Meituan All rights reserved
 */
@Data
public class TransactionCstRes {
    private String systemCode;
    private Integer id;
    private String bizLineCode;
    private String orgCode;
    private String toOrgCode;
    private String orderCode;
    private Integer orderTypeSource;
    private String orderTypeSourceName;
    private Integer orderType;
    private String orderTypeName;
    private Integer orderLineId;
    private String fromWarehouseCode;
    private String fromWarehouseName;
    private String fromWarehouseAreaCode;
    private String fromWarehouseAreaName;
    private String fromLocationCode;
    private String toWarehouseCode;
    private String toWarehouseName;
    private String toWarehouseAreaCode;
    private String toWarehouseAreaName;
    private String toLocationCode;
    private String materielCode;
    private String materielDesc;
    private Integer type;
    private String typeName;
    private String unit;
    private BigDecimal num;
    private Integer needCalcul;
    private String createUser;
    private String createTime;
    private String operateTime;
    private String sourceCode;
    private Integer sourceLineId;
    private String saleChannelName;
    private String associatedCode;
    private String sourceInfoBackup;
    private String pacPrice;
}
