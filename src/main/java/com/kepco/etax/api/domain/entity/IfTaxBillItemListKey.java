package com.kepco.etax.api.domain.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
public class IfTaxBillItemListKey implements Serializable {

    private String relSystemId;
    private String jobGubCode;
    private String manageId;
    private long seqNo;

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        IfTaxBillItemListKey ifTaxBillItemListKey = (IfTaxBillItemListKey) object;
        return (
            Objects.equals(relSystemId, ifTaxBillItemListKey.relSystemId) &&
            Objects.equals(jobGubCode, ifTaxBillItemListKey.jobGubCode) &&
            Objects.equals(manageId, ifTaxBillItemListKey.manageId) &&
            Objects.equals(seqNo, ifTaxBillItemListKey.seqNo)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(relSystemId, jobGubCode, manageId, seqNo);
    }
}
