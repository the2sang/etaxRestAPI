package com.kepco.etax.api.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@IdClass(IfTaxBillItemListKey.class)
@Table(name = "IF_TAX_BILL_ITEM_LIST")
public class IfTaxBillItemListEntity {

    //    @Id
    //    @Column(name = "REL_SYSTEM_ID")
    //    private String relSystemId;
    //
    //    @Id
    //    @Column(name = "JOB_GUB_CODE")
    //    private String jobGubCode;
    //
    //    @Id
    //    @Column(name = "MANAGE_ID")
    //    private String manageId;

    @Id
    @Column(name = "SEQ_NO")
    private long seqNo;

    @ManyToOne
    @JoinColumns(
        {
            @JoinColumn(name = "REL_SYSTEM_ID", referencedColumnName = "REL_SYSTEM_ID"),
            @JoinColumn(name = "JOB_GUB_CODE", referencedColumnName = "JOB_GUB_CODE"),
            @JoinColumn(name = "MANAGE_ID", referencedColumnName = "MANAGE_ID"),
        }
    )
    private IfTaxBillInfoEntity ifTaxBillInfoEntity;

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
