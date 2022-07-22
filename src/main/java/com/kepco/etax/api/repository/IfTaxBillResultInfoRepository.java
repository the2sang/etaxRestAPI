package com.kepco.etax.api.repository;

import com.kepco.etax.api.domain.entity.IfTaxBillResultInfoEntity;
import com.kepco.etax.api.domain.entity.IfTaxBillResultInfoKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IfTaxBillResultInfoRepository extends JpaRepository<IfTaxBillResultInfoEntity, IfTaxBillResultInfoKey> {
    List<IfTaxBillResultInfoEntity> findByIfTaxBillResultInfoKeyManageId(String managedId);

    List<IfTaxBillResultInfoEntity> findByIfTaxBillResultInfoKeyManageIdAndIfTaxBillResultInfoKeyJobGubCode(String manageId, String jobGubCode);
}
