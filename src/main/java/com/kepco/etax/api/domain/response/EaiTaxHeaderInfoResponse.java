package com.kepco.etax.api.domain.response;

import com.kepco.etax.api.domain.entity.EaiTaxHeaderInfoEntity;
import lombok.Getter;

@Getter
public class EaiTaxHeaderInfoResponse {


    private String bizNo;
    private String consNo;
    private String reqNo;
    private String profConsNo;
    private String consNm;
    private String compNo;
    private String pubYmd;
    private String status;
    private String buyerBizId;
    private String inspectorId;
    private String contractorId;
    private String eaiStat;
    private String eaiCdate;
    private String eaiUdate;
    private String buyerBizCd;
    private String docTypeDetail;
    private String relSystemId;
    private String smsYn;
    private String smsSenderName;
    private String smsSenderTel;

    public EaiTaxHeaderInfoResponse(EaiTaxHeaderInfoEntity data) {
        this.bizNo  = data.getEaiTaxHeaderInfoKey().getBizNo();
        this.consNo  = data.getEaiTaxHeaderInfoKey().getConsNo();
        this.reqNo  = data.getEaiTaxHeaderInfoKey().getReqNo();
        this.profConsNo  = data.getProfConsNo();
        this.consNm  = data.getConsNm();
        this.compNo  = data.getCompNo();
        this.pubYmd  = data.getPubYmd();
        this.status  = data.getStatus();
        this.buyerBizId  = data.getBuyerBizId();
        this.inspectorId  = data.getInspectorId();
        this.contractorId  = data.getContractorId();
        this.eaiStat  = data.getEaiStat();
        this.eaiCdate  = data.getEaiCdate();
        this.eaiUdate  = data.getEaiUdate();
        this.buyerBizCd  = data.getBuyerBizCd();
        this.docTypeDetail  = data.getDocTypeDetail();
        this.relSystemId  = data.getRelSystemId();
        this.smsYn  = data.getSmsYn();
        this.smsSenderName  = data.getSmsSenderName();
        this.smsSenderTel  = data.getSmsSenderTel();
    }
}
