package com.kepco.etax.api.domain.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class IfTaxBillItemListKey implements Serializable {

    @Column(name = "REL_SYSTEM_ID")
    private String relSystemId;

    @Column(name = "JOB_GUB_CODE")
    private String jobGubCode;

    @Column(name = "MANAGE_ID")
    private String manageId;

    @Column(name = "SEQ_NO")
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
