import lombok.Data;

/**
 * @description:
 * @author: lianghaohong
 * @date: 2022/5/26
 * @time: 9:16 下午
 * Copyright (C) 2021 Meituan All rights reserved
 */
@Data
public class ApInvoiceReq {
    private String orgCode;
    private String bgbuCode;
    private String periodCode;
    private String user_name = "SYSADMIN";
    private Integer lastInvoiceId;
    private Integer limit = 10;
    private String invOrg;
}
