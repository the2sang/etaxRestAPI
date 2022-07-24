package com.kepco.etax.api.domain.request;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class EaiTaxHeaderInfoRequest {

    @ApiModelProperty(value = "사업자번호", example = "1112233344-10", required = true)
    private String bizNo;

    @ApiModelProperty(value = "공사번호", example = "공사번호-12", required = true)
    private String consNo;

    @ApiModelProperty(value = "발행요청일시", example = "년월일시분초-yyyyMMddHHmmss-14", required = true)
    private String reqNo;

    @ApiModelProperty(value = "수익적공사번호", example = "숫자-12")
    private String profConsNo;

    @ApiModelProperty(value = "공사명", example = "한글-26")
    private String consNm;

    @ApiModelProperty(value = "공사업체코드", example = "코드테이블 참고-7")
    private String compNo;

    @ApiModelProperty(value = "발행일", example = "년월일-yyyymmdd-8", required = true)
    private String pubYmd;

    @ApiModelProperty(value = "상태코드", example = "WRM-처음 내선계기에서 등록한 상태, CFR, CFS, END 등은 ETS_TAX_META_INFO_TB.STATUS_CODE와 동일", required = true)
    private String status;

    @ApiModelProperty(value = "한전사업자번호", example = "공급받는자 사업자번호-10", required = true)
    private String buyerBizId;

    @ApiModelProperty(value = "검사담당자 사번", example = "숫자-8", required = true)
    private String inspectorId;

    @ApiModelProperty(value = "계약담당자 사번", example = "숫자-8", required = true)
    private String contractorId;

    @ApiModelProperty(value = "EAI 연계상태", example = "숫자-1")
    private String eaiStat;

    @ApiModelProperty(value = "EAI 연계 생성일시", example = "년월일시분초-yyyyMMddHHmmss-14")
    private String eaiCdate;

    @ApiModelProperty(value = "EAI 연계 갱신일시", example = "년월일시분초-yyyyMMddHHmmss-14")
    private String eaiUdate;

    @ApiModelProperty(value = "공급받는자 종사업장번호", example = "숫자(0000~9999)-4")
    private String buyerBizCd;

    @ApiModelProperty(value = "세금계산서 종류", example = "숫자-0101-4")
    private String docTypeDetail;

    @ApiModelProperty(value = "연계 시스템ID",
            example = "K1ETAX1022=내선계기, K1NCIS1000=영업 검침원 용역 수수료, K1NDIS1000=영업 조류예방활동비 K1PPAS1000=PPA태양광", required = true)
    private String relSystemId;

    @ApiModelProperty(value = "SMS발신여부", example = "SMS발신여부 Y:발신, N=미발신, null=미발신")
    private String smsYn;

    @ApiModelProperty(value = "SMS 발신자명", example = "성명-20")
    private String smsSenderName;

    @ApiModelProperty(value = "SMS 발신자 전화번호", example = "숫자-20")
    private String smsSenderTel;

}
