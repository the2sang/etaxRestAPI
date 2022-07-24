package com.kepco.etax.api.domain.request;

import lombok.Data;

@Data
public class IfTaxBillItemListRequest {

    private String purchaseDay;
    private String itemName;
    private String itemInfo;
    private String itemDesc;
    private double unitQuantity;
    private double unitAmount;
    private long invoiceAmount;
    private long taxAmount;
    private String billIssueYyyymm;

}
