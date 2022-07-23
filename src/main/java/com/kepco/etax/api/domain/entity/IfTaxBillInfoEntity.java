package com.kepco.etax.api.domain.entity;

import com.kepco.etax.api.domain.request.IfTaxBillItemListRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "IF_TAX_BILL_INFO")
public class IfTaxBillInfoEntity {


    @EmbeddedId
    private IfTaxBillInfoKey ifTaxBillInfoKey;

    @Column(name = "ADD_TAX_YN")
    private String addTaxYn;

    @Column(name = "ISSUE_ID", nullable = false)
    private String issueId;

    @Column(name = "ISSUE_DAY", nullable = false, length = 8)
    private String issueDay;

    @Column(name = "BILL_TYPE_CODE", nullable = false)
    private String billTypeCode;

    @Column(name = "PURPOSE_CODE")
    private String purposeCode;

    @Column(name = "AMENDMENT_CODE")
    private String amendmentCode;

    @Column(name = "UPPER_MANAGE_ID")
    private String upperManageId;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "INVOICER_PARTY_ID", nullable = false)
    private String invoicerPartyId;

    @Column(name = "INVOICER_TAX_REGIST_ID")
    private String invoicerTaxRegistId;

    @Column(name = "INVOICER_PARTY_NAME")
    private String invoicerPartyName;

    @Column(name = "INVOICER_CEO_NAME")
    private String invoicerCeoName;

    @Column(name = "INVOICER_ADDR")
    private String invoicerAddr;

    @Column(name = "INVOICER_TYPE")
    private String invoicerType;

    @Column(name = "INVOICER_CLASS")
    private String invoicerClass;

    @Column(name = "INVOICER_CONTACT_DEPART")
    private String invoicerContactDepart;

    @Column(name = "INVOICER_CONTACT_NAME")
    private String invoicerContactName;

    @Column(name = "INVOICER_CONTACT_PHONE")
    private String invoicerContactPhone;

    @Column(name = "INVOICER_CONTACT_EMAIL")
    private String invoicerContactEmail;

    @Column(name = "INVOICEE_BUSINESS_TYPE_CODE")
    private String invoiceeBusinessTypeCode;

    @Column(name = "INVOICEE_PARTY_ID")
    private String invoiceePartyId;

    @Column(name = "INVOICEE_TAX_REGIST_ID")
    private String invoiceeTaxRegistId;

    @Column(name = "INVOICEE_PARTY_NAME")
    private String invoiceePartyName;

    @Column(name = "INVOICEE_CEO_NAME")
    private String invoiceeCeoName;

    @Column(name = "INVOICEE_ADDR")
    private String invoiceeAddr;

    @Column(name = "INVOICEE_TYPE")
    private String invoiceeType;

    @Column(name = "INVOICEE_CLASS")
    private String invoiceeClass;

    @Column(name = "INVOICEE_CONTACT_DEPART1")
    private String invoiceeContactDepart1;

    @Column(name = "INVOICEE_CONTACT_NAME1")
    private String invoiceeContactName1;

    @Column(name = "INVOICEE_CONTACT_PHONE1")
    private String invoiceeContactPhone1;

    @Column(name = "INVOICEE_CONTACT_EMAIL1")
    private String invoiceeContactEmail1;

    @Column(name = "INVOICEE_CONTACT_DEPART2")
    private String invoiceeContactDepart2;

    @Column(name = "INVOICEE_CONTACT_NAME2")
    private String invoiceeContactName2;

    @Column(name = "INVOICEE_CONTACT_PHONE2")
    private String invoiceeContactPhone2;

    @Column(name = "INVOICEE_CONTACT_EMAIL2")
    private String invoiceeContactEmail2;

    @Column(name = "PAYMENT_TYPE_CODE1")
    private String paymentTypeCode1;

    @Column(name = "PAY_AMOUNT1")
    private long payAmount1;

    @Column(name = "PAYMENT_TYPE_CODE2")
    private String paymentTypeCode2;

    @Column(name = "PAY_AMOUNT2")
    private long payAmount2;

    @Column(name = "PAYMENT_TYPE_CODE3")
    private String paymentTypeCode3;

    @Column(name = "PAY_AMOUNT3")
    private long payAmount3;

    @Column(name = "PAYMENT_TYPE_CODE4")
    private String paymentTypeCode4;

    @Column(name = "PAY_AMOUNT4")
    private long payAmount4;

    @Column(name = "CHARGE_TOTAL_AMOUNT")
    private long chargeTotalAmount;

    @Column(name = "TAX_TOTAL_AMOUNT")
    private long taxTotalAmount;

    @Column(name = "GRAND_TOTAL_AMOUNT")
    private long grandTotalAmount;

    @Column(name = "CUST_NO")
    private String custNo;

    @Column(name = "BILL_YYYYMM")
    private String billYyyymm;

    @Column(name = "BILL_ISSUE_YYYYMM")
    private String billIssueYyyymm;

    @Column(name = "PAY_DEADLINE")
    private String payDeadline;

    @Column(name = "ONLINE_GUB_CODE")
    private String onlineGubCode;

    @Column(name = "FLG")
    private String flg;

//    @Column(name = "REGIST_DT", nullable = false)
//    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
//    private LocalDateTime registDt;
//
//    @Column(name = "MODIFY_DT", nullable = false)
//    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
//    private LocalDateTime modifyDt;
//
//    @Column(name = "CANCEL_DT")
//    private LocalDateTime cancelDt;

    @Column(name = "EAI_STAT")
    private String eaiStat;

    @Column(name = "EAI_CDATE")
    private String eaiCdate;

    @Column(name = "EAI_UDATE")
    private String eaiUdate;

    @Column(name = "ERP_EVIDENCE_CODE")
    private String erpEvidenceCode;

    @Column(name = "VAT_GUB_CODE")
    private String vatGubCode;

    @Column(name = "RECEIPT_GUB_CODE")
    private String receiptGubCode;

    @Column(name = "REGIST_ID")
    private String registId;

    @Column(name = "BELNR")
    private String belnr;

    @Column(name = "ASP_ISSUE_ID")
    private String aspIssueId;

    @Column(name = "TAX_TYPE_CODE")
    private String taxTypeCode;

    @Column(name = "ATTACH_FILE")
    private String attachFile;
}
