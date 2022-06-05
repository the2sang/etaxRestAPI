package com.kepco.etax.api.domain.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
public class IfTaxBillInfoKey implements Serializable {

    private String relSystemId;
    private String jobGubCode;
    private String manageId;

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        IfTaxBillInfoKey ifTaxBillInfoKey = (IfTaxBillInfoKey) object;
        return (
            Objects.equals(relSystemId, ifTaxBillInfoKey.relSystemId) &&
            Objects.equals(jobGubCode, ifTaxBillInfoKey.jobGubCode) &&
            Objects.equals(manageId, ifTaxBillInfoKey.manageId)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(relSystemId, jobGubCode, manageId);
    }
}
