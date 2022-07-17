package com.kepco.etax.api.repository;

import com.kepco.etax.api.domain.entity.IfTaxBillResultInfoEntity;
import com.kepco.etax.api.domain.entity.IfTaxBillResultInfoKey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IfTaxBillResultInfoRepository extends JpaRepository<IfTaxBillResultInfoEntity, IfTaxBillResultInfoKey> {
    List<IfTaxBillResultInfoEntity> findByIfTaxBillResultInfoKeyManageId(String managedId);
}
