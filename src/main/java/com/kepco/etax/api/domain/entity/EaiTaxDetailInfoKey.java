package com.kepco.etax.api.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;


@NoArgsConstructor
@AllArgsConstructor
@Embeddable
@Getter
@Setter
public class EaiTaxDetailInfoKey implements Serializable {

    @Column(name = "BIZ_NO")
    private String bizNo;

    @Column(name = "CONS_NO")
    private String consNo;

    @Column(name = "REQ_NO")
    private String reqNo;

    @Column(name = "ACPTNO")
    private String acptno;

    @Column(name = "CONS_KND_CD")
    private String consKndCd;

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        EaiTaxDetailInfoKey eaiTaxDetailInfoKey = (EaiTaxDetailInfoKey) object;
        return (
                Objects.equals(bizNo, eaiTaxDetailInfoKey.bizNo) &&
                        Objects.equals(consNo, eaiTaxDetailInfoKey.consNo) &&
                        Objects.equals(reqNo, eaiTaxDetailInfoKey.reqNo) &&
                        Objects.equals(acptno, eaiTaxDetailInfoKey.acptno) &&
                        Objects.equals(consKndCd, eaiTaxDetailInfoKey.consKndCd)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(bizNo, consNo, reqNo, acptno, consKndCd);
    }

}
