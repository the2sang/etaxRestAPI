package com.kepco.etax.api.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import java.io.Serializable;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Embeddable
@Getter
public class IfTaxBillItemListKey implements Serializable {

    @Embedded
    private IfTaxBillInfoKey ifTaxBillInfoKey;

    @Column(name = "SEQ_NO")
    private long seqNo;

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        IfTaxBillItemListKey ifTaxBillItemListKey = (IfTaxBillItemListKey) object;
        return (
            Objects.equals(ifTaxBillInfoKey.getRelSystemId(), ifTaxBillItemListKey.getIfTaxBillInfoKey().getRelSystemId()) &&
            Objects.equals(ifTaxBillInfoKey.getJobGubCode(), ifTaxBillItemListKey.getIfTaxBillInfoKey().getJobGubCode()) &&
            Objects.equals(ifTaxBillInfoKey.getManageId(), ifTaxBillItemListKey.getIfTaxBillInfoKey().getManageId()) &&
            Objects.equals(seqNo, ifTaxBillItemListKey.seqNo)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(ifTaxBillInfoKey.getRelSystemId(), ifTaxBillInfoKey.getJobGubCode(), ifTaxBillInfoKey.getManageId(), seqNo);
    }
}
