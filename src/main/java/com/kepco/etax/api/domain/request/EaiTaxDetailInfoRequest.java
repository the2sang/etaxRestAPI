package com.kepco.etax.api.domain.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class EaiTaxDetailInfoRequest {

    @ApiModelProperty(value = "사업자번호", example = "숫자만-10", required = true)
    private String bizNo;

    @ApiModelProperty(value = "공사번호", example = "숫자만-12", required = true)
    private String consNo;

    @ApiModelProperty(value = "발행요청일시", example = "년월일시분초-숫자만-yyyymmddhhmmss-14", required = true)
    private String reqNo;

    @ApiModelProperty(value = "접수번호", example = "숫자-yyyymm-6", required = true)
    private String acptno;

    @ApiModelProperty(value = "공사종류코드", example = "01~XX-2", required = true)
    private String consKndCd;

@ApiModelProperty(value = "접수종류명", example = "한글-60" )
    private String acptKndNm;

    @ApiModelProperty(value = "금액", example = "계기공사비(내선계기), 공급가액(영업검침, 조류, PPA)-18")
    private String matrbillCompAmt;

    @ApiModelProperty(value = "공사금액", example = "내선계기-18")
    private String compAmt;

    @ApiModelProperty(value = "고객명", example = "고객명-20")
    private String custnm;

    @ApiModelProperty(value = "주소", example = "주소-60")
    private String address;

    @ApiModelProperty(value = "시공일자", example = "년월일-yyyymmdd-8")
    private String operYmd;

    @ApiModelProperty(value = "수익적공사금액", example = "수익적공사금액-18")
    private String profCompAmt;

    @ApiModelProperty(value = "연계시스템ID", example = "K1ETAX1022-내선계기, K1NCIS1000-영업검침 용역 수수료, K1NDIS1000-조류예방활동비, K1PPAS1000-PPA")
    private String relSystemId;

    @ApiModelProperty(value = "부가세액", example = "부가세액(PPA시스템용)-18")
    private String vatAmt;

}
