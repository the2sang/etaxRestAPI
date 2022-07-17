package com.kepco.etax.api.domain.response;

import com.kepco.etax.api.domain.entity.IfTaxBillResultInfoEntity;
import lombok.Getter;
import java.time.LocalDateTime;

@Getter
public class IfTaxBillResultInfoResponse {

    private String jobGubCode;
    private String managedId;
    private LocalDateTime rigistDt;
    private String relSystemId;
    private String statusCode;
    private String statusDesc;
    private LocalDateTime modifyDt;
    private String issueId;
    private String eaiStat;
    private String eaiCdate;
    private String eaiUdate;
    private String taxCancelData;
    private String eseroCreateTs;
    private String eseroFinishTs;

    public IfTaxBillResultInfoResponse(IfTaxBillResultInfoEntity entity) {
        this.jobGubCode = entity.getIfTaxBillResultInfoKey().getJobGubCode();
        this.managedId = entity.getIfTaxBillResultInfoKey().getManageId();
        this.rigistDt = entity.getIfTaxBillResultInfoKey().getRegistDt();
        this.relSystemId = entity.getIfTaxBillResultInfoKey().getRelSystemId();
        this.statusCode = entity.getIfTaxBillResultInfoKey().getStatusCode();
        this.statusDesc = entity.getStatusDesc();
        this.modifyDt = entity.getModifyDt();
        this.issueId = entity.getIssueId();
        this.eaiStat = entity.getEaiStat();
        this.eaiCdate = entity.getEaiCdate();
        this.eaiUdate = entity.getEaiUdate();
        this.taxCancelData = entity.getTaxCancelData();
        this.eseroCreateTs = entity.getEseroCreateTs();
        this.eseroFinishTs = entity.getEseroFinishTs();
    }

}
