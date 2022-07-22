package com.kepco.etax.api.domain.request;

import lombok.Data;

@Data
public class EaiTaxDetailInfoRequest {
    private String bizNo;
    private String consNo;
    private String reqNo;
    private String acptno;
    private String consKndCd;
    private String acptKndNm;
    private String matrbillCompAmt;
    private String compAmt;
    private String custnm;
    private String address;
    private String operYmd;
    private String profCompAmt;
    private String relSystemId;
    private String vatAmt;

}
