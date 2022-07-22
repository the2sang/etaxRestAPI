package com.kepco.etax.api.domain.response;

import com.kepco.etax.api.domain.entity.EaiTaxDetailInfoEntity;
import lombok.Getter;

@Getter
public class EaiTaxDetailInfoResponse {

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

    public EaiTaxDetailInfoResponse(EaiTaxDetailInfoEntity data) {
        this.bizNo = data.getEaiTaxDetailInfoKey().getBizNo();
        this.consNo = data.getEaiTaxDetailInfoKey().getConsNo();
        this.reqNo = data.getEaiTaxDetailInfoKey().getReqNo();
        this.acptno = data.getEaiTaxDetailInfoKey().getAcptno();
        this.consKndCd = data.getEaiTaxDetailInfoKey().getConsKndCd();
        this.acptKndNm = data.getAcptKndNm();
        this.matrbillCompAmt = data.getMatrbillCompAmt();
        this.compAmt = data.getCompAmt();
        this.custnm = data.getCustnm();
        this.address = data.getAddress();
        this.operYmd = data.getOperYmd();
        this.profCompAmt = data.getProfCompAmt();
        this.relSystemId = data.getRelSystemId();
        this.vatAmt = data.getVatAmt();
    }

}
