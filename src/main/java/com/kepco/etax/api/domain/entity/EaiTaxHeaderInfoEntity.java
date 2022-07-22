package com.kepco.etax.api.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;


@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "EAI_TAX_HEADER_INFO_TB")
public class EaiTaxHeaderInfoEntity {

    @EmbeddedId
    private EaiTaxHeaderInfoKey eaiTaxHeaderInfoKey;

    @Column(name = "PROF_CONS_NO")
    private String profConsNo;

    @Column(name = "CONS_NM")
    private String consNm;

    @Column(name = "COMP_NO")
    private String compNo;

    @Column(name = "PUB_YMD")
    private String pubYmd;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "BUYER_BIZ_ID")
    private String buyerBizId;

    @Column(name = "INSPECTOR_ID")
    private String inspectorId;

    @Column(name = "CONTRACTOR_ID")
    private String contractorId;

    @Column(name = "EAI_STAT", columnDefinition = "CHAR")
    private String eaiStat;

    @Column(name = "EAI_CDATE")
    private String eaiCdate;

    @Column(name = "EAI_UDATE")
    private String eaiUdate;

    @Column(name = "BUYER_BIZ_CD")
    private String buyerBizCd;

    @Column(name = "DOC_TYPE_DETAIL")
    private String docTypeDetail;

    @Column(name = "REL_SYSTEM_ID")
    private String relSystemId;

    @Column(name = "SMS_YN", columnDefinition = "CHAR")
    private String smsYn;

    @Column(name = "SMS_SENDER_NAME")
    private String smsSenderName;

    @Column(name = "SMS_SENDER_TEL")
    private String smsSenderTel;

}
