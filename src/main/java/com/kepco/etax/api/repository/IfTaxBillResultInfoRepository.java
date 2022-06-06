package com.kepco.etax.api.repository;

import com.kepco.etax.api.domain.entity.IfTaxBillResultInfo;
import com.kepco.etax.api.domain.entity.IfTaxBillResultInfoId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IfTaxBillResultInfoRepository extends JpaRepository<IfTaxBillResultInfo, IfTaxBillResultInfoId> {

}
