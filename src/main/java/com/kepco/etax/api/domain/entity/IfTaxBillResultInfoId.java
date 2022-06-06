package com.kepco.etax.api.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class IfTaxBillResultInfoId implements Serializable {

    @Column(name = "REL_SYSTEM_ID")
    private String relSystemId;

    @Column(name = "JOB_GUB_CODE")
    private String jobGubCode;

    @Column(name = "MANAGE_ID")
    private String manageId;

    @Column(name = "STATUS_CODE")
    private String statusCode;

    @Column(name = "REGIST_DT")
    private Date registDt;


    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        IfTaxBillResultInfoId id = (IfTaxBillResultInfoId) object;
        return (
            Objects.equals(relSystemId, id.relSystemId) &&
                Objects.equals(jobGubCode, id.jobGubCode) &&
                Objects.equals(manageId, id.manageId) &&
                Objects.equals(statusCode, id.statusCode) &&
                Objects.equals(registDt, id.registDt)
        );
    }

    @Override
    public int hashCode() {

        return Objects.hash(relSystemId, jobGubCode, manageId, statusCode, registDt);
    }
}
