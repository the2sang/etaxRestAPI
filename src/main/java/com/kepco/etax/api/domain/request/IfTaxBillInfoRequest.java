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

    @ApiModelProperty(value = "연계 시스템ID-코드테이블: REL_SYSTEM_ID 참고", example = "text-10" , required = true)
    private String relSystemId;

    @ApiModelProperty(value = "업무구분코드-전력매출, 공사매출 등 코드테이블 JOB_GUB_CODE 참고", example = "text-6", required = true)
    private String jobGubCode;

    @ApiModelProperty(value = "사업자관리번호-세금계산서 유형별 관리번호", example = "1112233333-24", required = true)
    private String manageId;

    @ApiModelProperty(value = "가산세 여부-N-가산세 대상 아님 / Y-가산세 대상", example = "N-1", required = false)
    private String addTaxYn;


    @ApiModelProperty(value = "국세청승인번호세금신고용 국세청 싱인번호-코드생성 참고", example = "text-24", required = true)
    private String issueId;

    @ApiModelProperty(value = "세금계산서 작성일자-매출기준일자", example = "20220710-8", required = true)
    private String issueDay;

    @ApiModelProperty(value = "세금계산서 종류", example = "0101-4", required = true)
    private String billTypeCode;

    @ApiModelProperty(value = "영수청구코드-코드 테이블 참고", example = "text-2")
    private String purposeCode;

    @ApiModelProperty(value = "전자세금계산서 수정 사유코드-코드테이블 참고", example = "text-2")
    private String amendmentCode;

    @ApiModelProperty(value = "부모관리번호-수정세금계산서 발행시사용", example = "text-24")
    private String upperManageId;

    @ApiModelProperty(value = "비고", example = "text-150")
    private String description;

    @ApiModelProperty(value = "공급자 사업자번호", example = "1112233333-13", required = true)
    private String invoicerPartyId;

    @ApiModelProperty(value = "종사업장 식별코드", example = "0001~9999-4")
    private String invoicerTaxRegistId;

    @ApiModelProperty(value = "공급업체 사업자명", example = "text-70", required = true)
    private String invoicerPartyName;

    @ApiModelProperty(value = "공급업체 대표자명", example = "text-50", required = true)
    private String invoicerCeoName;

    @ApiModelProperty(value = "공급업체 주소", example = "text-150")
    private String invoicerAddr;

    @ApiModelProperty(value = "공급업체 업태", example = "text-40")
    private String invoicerType;

    @ApiModelProperty(value = "공급업체 업종", example = "text-40")
    private String invoicerClass;

    @ApiModelProperty(value = "공급업체 담당부서", example = "text-40")
    private String invoicerContactDepart;

    @ApiModelProperty(value = "공급업체 담당자명", example = "text-30")
    private String invoicerContactName;

    @ApiModelProperty(value = "공급업체 담당자 전화번호", example = "text-20")
    private String invoicerContactPhone;

    @ApiModelProperty(value = "공급업체 담당자 이메일", example = "text-40")
    private String invoicerContactEmail;

    @ApiModelProperty(value = "공급받는자 사업자등록번호 구분코드", example = "text-2", required = true)
    private String invoiceeBusinessTypeCode;

    @ApiModelProperty(value = "공급받는자 사업자등록번호", example = "text-13", required = true)
    private String invoiceePartyId;

    @ApiModelProperty(value = "공급받는자 종사업장 식별코드", example = "0000~9999")
    private String invoiceeTaxRegistId;

    @ApiModelProperty(value = "공급받는자 사업체명", example = "text-70", required = true)
    private String invoiceePartyName;

    @ApiModelProperty(value = "공급받는자 대표자명", example = "text-30", required = true)
    private String invoiceeCeoName;

    @ApiModelProperty(value = "공급받는자 주소", example = "text-150", required = true)
    private String invoiceeAddr;

    @ApiModelProperty(value = "공급받는자 업태", example = "text-40")
    private String invoiceeType;

    @ApiModelProperty(value = "공급받는자 업종", example = "text-40")
    private String invoiceeClass;

    @ApiModelProperty(value = "공급받는자 담당부서", example = "text-40")
    private String invoiceeContactDepart1;

    @ApiModelProperty(value = "공급받는자 담당자명", example = "text-30")
    private String invoiceeContactName1;

    @ApiModelProperty(value = "공급받는자 담당자 전화번호", example = "text-20")
    private String invoiceeContactPhone1;

    @ApiModelProperty(value = "공급받는자 담당자 이메일", example = "text-40")
    private String invoiceeContactEmail1;

    @ApiModelProperty(value = "공급받는자 담당부서2", example = "text-40")
    private String invoiceeContactDepart2;

    @ApiModelProperty(value = "공급받는자 담당자명2", example = "text-30")
    private String invoiceeContactName2;

    @ApiModelProperty(value = "공급받는자 담당자 전화번호2", example = "text-20")
    private String invoiceeContactPhone2;

    @ApiModelProperty(value = "공급받는자 담당자 이메일2", example = "text-40")
    private String invoiceeContactEmail2;

    @ApiModelProperty(value = "결제방법코드", example = "text-2", required = true)
    private String paymentTypeCode1;

    @ApiModelProperty(value = "결제방법별금액", example = "number-18", required = true)
    private long payAmount1;

    @ApiModelProperty(value = "결제방법코드", example = "text-2")
    private String paymentTypeCode2;

    @ApiModelProperty(value = "결제방법별금액", example = "number-18")
    private long payAmount2;

    @ApiModelProperty(value = "결제방법코드", example = "text-2")
    private String paymentTypeCode3;

    @ApiModelProperty(value = "결제방법별금액", example = "number-18")
    private long payAmount3;

    @ApiModelProperty(value = "결제방법코드", example = "text-2")
    private String paymentTypeCode4;

    @ApiModelProperty(value = "결제방법별금액", example = "number-18")
    private long payAmount4;

    @ApiModelProperty(value = "총 공급가액 합계", example = "number-18", required = true)
    private long chargeTotalAmount;

    @ApiModelProperty(value = "총 세액 합계", example = "number-18", required = true)
    private long taxTotalAmount;

    @ApiModelProperty(value = "총액(공급가액+세액)", example = "number-18", required = true)
    private long grandTotalAmount;

    @ApiModelProperty(value = "전기고객번호", example = "number-10")
    private String custNo;

    @ApiModelProperty(value = "청구년월", example = "yyyymm-6")
    private String billYyyymm;

    @ApiModelProperty(value = "청구서발행년월", example = "yyyymm-6")
    private String billIssueYyyymm;

    @ApiModelProperty(value = "지급만기일자", example = "yyymmdd-8")
    private String payDeadline;

    @ApiModelProperty(value = "온,오프라인 구분코드(1:온라인,2:오프라인, 3:요금온라인)", example = "number-1", required = true)
    private String onlineGubCode;

    @ApiModelProperty(value = "처리구분(Y,N)", example = "N-1", required = true)
    private String flg;

//    @ApiModelProperty(value = "생성 년월일시", example = "2022-04-19 15:20", required = true)
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Seoul")
//    private LocalDateTime registDt;
//
//    @ApiModelProperty(value = "수정 년월일시", example = "2022-04-19 15:20", required = true, dataType = "DateTime")
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Seoul")
//    private LocalDateTime modifyDt;

//    @ApiModelProperty(value = "취소 년월일시", example = "2022-04-19 15:20")
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Seoul")
//    private LocalDateTime cancelDt;

    @ApiModelProperty(value = "p:진행중 c:완료 e:에러", example = "text-1")
    private String eaiStat;

    @ApiModelProperty(value = "EAI 연계 생성일시", example = "yyyyMMddHHmmss-14")
    private String eaiCdate;

    @ApiModelProperty(value = "EAI 연계 갱신일시", example = "yyyyMMddHHmmss-14")
    private String eaiUdate;

    @ApiModelProperty(value = "ERP증빙유형코드(매입/매출공통사용)", example = "text-6")
    private String erpEvidenceCode;

    @ApiModelProperty(value = "세금종류", example = "text-2")
    private String vatGubCode;

    @ApiModelProperty(value = "접수방법 1:인편,2:우편,3이메일", example = "number-1")
    private String receiptGubCode;

    @ApiModelProperty(value = "등록자 사번", example = "text-10")
    private String registId;

    @ApiModelProperty(value = "MM송장번호", example = "text-14")
    private String belnr;

    @ApiModelProperty(value = "외부발행승인번호", example = "text-24")
    private String aspIssueId;

    @ApiModelProperty(value = "전자/수기구분(증빙구분) 11=ASP매입(대표메일),12=ASP매입(개별메일),13=수기입력(ASP),14=겸용서식,21=수기입력(종이)", example = "number-2")
    private String taxTypeCode;

    @ApiModelProperty(value = "수기분 첨부파일명", example = "text-30")
    private String attachFile;


    private List<IfTaxBillItemListRequest> itemList = new ArrayList<>();

}
