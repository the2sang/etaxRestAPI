package com.kepco.etax.api.domain.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

public class IfTaxBillResultInfoKey implements Serializable {

    private String relSystemId;
    private String jobGubCode;
    private String manageId;
    private String statusCode;
    private Date registDt;


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
