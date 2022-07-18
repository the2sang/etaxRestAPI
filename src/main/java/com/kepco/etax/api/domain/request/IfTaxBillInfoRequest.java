package com.kepco.etax.api.domain.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class IfTaxBillInfoRequest {

    @ApiModelProperty(value = "연계 시스템ID", example = "코드테이블: REL_SYSTEM_ID 참고")
    private String relSystemId;

    @ApiModelProperty(value = "업무구분코드", example = "전력매출, 공사매출 등 코드테이블 JOB_GUB_CODE 참고")
    private String jobGubCode;

    @ApiModelProperty(value = "사업자관리번호", example = "세금계산서 유형별 관리번호")
    private String manageId;

    @ApiModelProperty(value = "가산세 여부", example = "N-가산세 대상 아님 / Y-가산세 대상", required = false)
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

    @ApiModelProperty(value = "생성 년월일시", example = "2022-04-19 15:20", required = true)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Seoul")
    private LocalDateTime registDt;

    @ApiModelProperty(value = "수정 년월일시", example = "2022-04-19 15:20", required = true, dataType = "DateTime")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Seoul")
    private LocalDateTime modifyDt;

    @ApiModelProperty(value = "취소 년월일시", example = "2022-04-19 15:20")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Seoul")
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

    private List<IfTaxBillItemListRequest> itemList = new ArrayList<>();

}
