package com.kepco.etax.api.repository;

import com.kepco.etax.api.domain.entity.IfTaxBillInfo;
import com.kepco.etax.api.domain.entity.IfTaxBillInfoId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IfTaxBillInfoRepository extends JpaRepository<IfTaxBillInfo, IfTaxBillInfoId> {

    //List<IfTaxBillInfoEntity> findByRelSystemId(String relSystemId);
  List<IfTaxBillInfo> findByIdRelSystemIdAndIdJobGubCodeAndIdManageId(String relSystemId, String jobGubCode, String manageId);


}
