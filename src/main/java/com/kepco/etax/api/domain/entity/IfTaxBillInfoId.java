package com.kepco.etax.api.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Embeddable
@Getter
public class IfTaxBillInfoId implements Serializable {

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
        IfTaxBillInfoId ifTaxBillInfoId = (IfTaxBillInfoId) object;
        return (
            Objects.equals(relSystemId, ifTaxBillInfoId.relSystemId) &&
            Objects.equals(jobGubCode, ifTaxBillInfoId.jobGubCode) &&
            Objects.equals(manageId, ifTaxBillInfoId.manageId)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(relSystemId, jobGubCode, manageId);
    }
}
