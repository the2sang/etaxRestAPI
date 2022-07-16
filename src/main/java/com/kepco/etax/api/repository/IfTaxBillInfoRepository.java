package com.kepco.etax.api.repository;

import com.kepco.etax.api.domain.entity.IfTaxBillInfoEntity;
import com.kepco.etax.api.domain.entity.IfTaxBillInfoKey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IfTaxBillInfoRepository extends JpaRepository<IfTaxBillInfoEntity, IfTaxBillInfoKey> {

    //List<IfTaxBillInfoEntity> findByRelSystemId(String relSystemId);

  //Optional<IfTaxBillInfoEntity> findByIdManageId(String manageId, String jobGubCode);

}
