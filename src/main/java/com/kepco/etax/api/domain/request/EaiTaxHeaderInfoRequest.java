package com.kepco.etax.api.domain.request;


import lombok.Data;

@Data
public class EaiTaxHeaderInfoRequest {

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

}
