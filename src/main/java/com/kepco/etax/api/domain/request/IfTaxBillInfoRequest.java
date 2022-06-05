package com.kepco.etax.api.domain.request;

import lombok.Data;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class IfTaxBillInfoRequest {

    private String relSystemId;
    private String jobGubCode;
    private String manageId;
    private String addTaxYn;
    private String issueId;
    private String issueDay;
    private String billTypeCode;
    private String purposeCode;
    private String amendmentCode;
    private String upperManageId;
    private String description;
    private String invoicerPartyId;
    private String invoicerTaxRegistId;
    private String invoicerPartyName;
    private String invoicerCeoName;
    private String invoicerAddr;
    private String invoicerType;
    private String invoicerClass;
    private String invoicerContactDepart;
    private String invoicerContactName;
    private String invoicerContactPhone;
    private String invoicerContactEmail;
    private String invoiceeBusinessTypeCode;
    private String invoiceePartyId;
    private String invoiceeTaxRegistId;
    private String invoiceePartyName;
    private String invoiceeCeoName;
    private String invoiceeAddr;
    private String invoiceeType;
    private String invoiceeClass;
    private String invoiceeContactDepart1;
    private String invoiceeContactName1;
    private String invoiceeContactPhone1;
    private String invoiceeContactEmail1;
    private String invoiceeContactDepart2;
    private String invoiceeContactName2;
    private String invoiceeContactPhone2;
    private String invoiceeContactEmail2;
    private String paymentTypeCode1;
    private long payAmount1;
    private String paymentTypeCode2;
    private long payAmount2;
    private String paymentTypeCode3;
    private long payAmount3;
    private String paymentTypeCode4;
    private long payAmount4;
    private long chargeTotalAmount;
    private long taxTotalAmount;
    private long grandTotalAmount;
    private String custNo;
    private String billYyyymm;
    private String billIssueYyyymm;
    private String payDeadline;
    private String onlineGubCode;
    private String flg;
    private LocalDateTime registDt;
    private LocalDateTime modifyDt;
    private LocalDateTime cancelDt;
    private String eaiStat;
    private String eaiCdate;
    private String eaiUdate;
    private String erpEvidenceCode;
    private String vatGubCode;
    private String receiptGubCode;
    private String registId;
    private String belnr;
    private String aspIssueId;
    private String taxTypeCode;
    private String attachFile;

    private List<IfTaxBillItemListRequest> itemListRequest = new ArrayList<>();

}
