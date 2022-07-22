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
public class EaiTaxHeaderInfoKey implements Serializable {

    @Column(name = "BIZ_NO")
    private String bizNo;

    @Column(name = "CONS_NO")
    private String consNo;

    @Column(name = "REQ_NO")
    private String reqNo;


    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        EaiTaxHeaderInfoKey eaiTaxHeaderInfoKey = (EaiTaxHeaderInfoKey) object;
        return (
                Objects.equals(bizNo, eaiTaxHeaderInfoKey.bizNo) &&
                        Objects.equals(consNo, eaiTaxHeaderInfoKey.consNo) &&
                        Objects.equals(reqNo, eaiTaxHeaderInfoKey.reqNo)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(bizNo, consNo, reqNo);
    }
}
