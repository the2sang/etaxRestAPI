package com.kepco.etax.api.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class IfTaxBillResultInfoKey implements Serializable {

    @Column(name = "REL_SYSTEM_ID")
    private String relSystemId;

    @Column(name = "JOB_GUB_CODE")
    private String jobGubCode;

    @Column(name = "MANAGE_ID")
    private String manageId;

    @Column(name = "STATUS_CODE")
    private String statusCode;

    @Column(name = "REGIST_DT")
    private LocalDateTime registDt;


    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        IfTaxBillResultInfoKey ifTaxBillResultInfoKey = (IfTaxBillResultInfoKey) object;
        return (
            Objects.equals(relSystemId, ifTaxBillResultInfoKey.relSystemId) &&
                Objects.equals(jobGubCode, ifTaxBillResultInfoKey.jobGubCode) &&
                Objects.equals(manageId, ifTaxBillResultInfoKey.manageId) &&
                Objects.equals(statusCode, ifTaxBillResultInfoKey.statusCode) &&
                Objects.equals(registDt, ifTaxBillResultInfoKey.registDt)
        );
    }

    @Override
    public int hashCode() {

        return Objects.hash(relSystemId, jobGubCode, manageId, statusCode, registDt);
    }
}
