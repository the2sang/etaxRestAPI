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
@Table(name = "EAI_TAX_DETAIL_INFO_TB")
public class EaiTaxDetailInfoEntity {

    @EmbeddedId
    EaiTaxDetailInfoKey eaiTaxDetailInfoKey;

    @Column(name = "ACPT_KND_NM")
    private String acptKndNm;

    @Column(name = "MATRBILL_COMP_AMT")
    private String matrbillCompAmt;

    @Column(name = "COMP_AMT")
    private String compAmt;

    @Column(name = "CUSTNM")
    private String custnm;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "OPER_YMD")
    private String operYmd;

    @Column(name = "PROF_COMP_AMT")
    private String profCompAmt;

    @Column(name = "REL_SYSTEM_ID")
    private String relSystemId;

    @Column(name = "VAT_AMT")
    private String vatAmt;

}
