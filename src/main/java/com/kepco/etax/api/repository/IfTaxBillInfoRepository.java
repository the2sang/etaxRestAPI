package com.kepco.etax.api.repository;

import com.kepco.etax.api.domain.entity.IfTaxBillInfoEntity;
import com.kepco.etax.api.domain.entity.IfTaxBillInfoKey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IfTaxBillInfoRepository extends JpaRepository<IfTaxBillInfoEntity, IfTaxBillInfoKey> {

    //List<IfTaxBillInfoEntity> findByRelSystemId(String relSystemId);
}
