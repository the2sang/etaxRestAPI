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
public class IfTaxBillItemListId implements Serializable {

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
        IfTaxBillItemListId objectId = (IfTaxBillItemListId) object;
        return (
            Objects.equals(relSystemId, objectId.getRelSystemId()) &&
            Objects.equals(jobGubCode, objectId.getJobGubCode()) &&
            Objects.equals(manageId, objectId.getManageId()) &&
            Objects.equals(seqNo, objectId.seqNo)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(relSystemId, jobGubCode, manageId, seqNo);
    }
}
