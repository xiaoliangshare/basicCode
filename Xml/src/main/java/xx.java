import com.dianping.lion.client.util.Json;

/**
 * @description:
 * @author: lianghaohong
 * @date: 2022/5/26
 * @time: 9:17 下午
 * Copyright (C) 2021 Meituan All rights reserved
 */
public class xx {
    public static void main(String[] args) {
        ApInvoiceReq req = new ApInvoiceReq();
        req.setOrgCode("1040");
        req.setBgbuCode("20050");
        req.setPeriodCode("2020-01");
        req.setUser_name("SYSADMIN");
        req.setLastInvoiceId(0);
        req.setLimit(10);
        req.setInvOrg("A11");


    }
}
