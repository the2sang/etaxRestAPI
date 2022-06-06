package com.kepco.etax.api.domain.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "IF_TAX_BILL_RESULT_INFO")
public class IfTaxBillResultInfo {

   @EmbeddedId
   IfTaxBillResultInfoId id;

    @Column(name = "STATUS_DESC")
    private String statusDesc;

    @Column(name = "MODIFY_DT")
    private Date modifyDt;

    @Column(name = "ISSUE_ID")
    private String issueId;

    @Column(name = "EAI_STAT")
    private String eaiStat;

    @Column(name = "EAI_CDATE")
    private String eaiCdate;

    @Column(name = "EAI_UDATE")
    private String eaiUdate;

    @Column(name = "TAX_CANCEL_DATE")
    private String taxCancelData;

    @Column(name = "ESERO_CREATE_TS")
    private String eseroCreateTs;

    @Column(name = "ESERO_FINISH_TS")
    private String eseroFinishTs;
}
