package com.kepco.etax.api.domain.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class IfTaxBillInfoKey implements Serializable {

    @Column(name = "REL_SYSTEM_ID")
    private String relSystemId;

    @Column(name = "JOB_GUB_CODE")
    private String jobGubCode;

    @Column(name = "MANAGE_ID")
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
