package com.kepco.etax.api.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "IF_TAX_BILL_ITEM_LIST")
public class IfTaxBillItemListEntity implements Serializable {



//    @MapsId("ifTaxBillInfoKey")
//    @ManyToOne
//    @JoinColumns(
//        {
//            @JoinColumn(name = "REL_SYSTEM_ID", insertable = false, updatable = false),
//            @JoinColumn(name = "JOB_GUB_CODE", insertable = false, updatable = false),
//            @JoinColumn(name = "MANAGE_ID", insertable = false, updatable = false)
//        }
//    )
//    private IfTaxBillInfoEntity ifTaxBillInfoEntity;

    @EmbeddedId
    IfTaxBillItemListKey ifTaxBillItemListKey;

    @Column(name = "PURCHASE_DAY")
    private String purchaseDay;

    @Column(name = "ITEM_NAME")
    private String itemName;

    @Column(name = "ITEM_INFO")
    private String itemInfo;

    @Column(name = "ITEM_DESC")
    private String itemDesc;

    @Column(name = "UNIT_QUANTITY")
    private double unitQuantity;

    @Column(name = "UNIT_AMOUNT")
    private double unitAmount;

    @Column(name = "INVOICE_AMOUNT")
    private long invoiceAmount;

    @Column(name = "TAX_AMOUNT")
    private long taxAmount;

    @Column(name = "BILL_ISSUE_YYYYMM")
    private String billIssueYyyymm;
}
