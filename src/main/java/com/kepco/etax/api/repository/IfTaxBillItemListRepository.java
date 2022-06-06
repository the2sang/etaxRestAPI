package com.kepco.etax.api.repository;

import com.kepco.etax.api.domain.entity.IfTaxBillItemList;
import com.kepco.etax.api.domain.entity.IfTaxBillItemListId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IfTaxBillItemListRepository extends JpaRepository<IfTaxBillItemList, IfTaxBillItemListId> {
  List<IfTaxBillItemList> findByIdRelSystemIdAndIdJobGubCodeAndIdManageId(String relSystemId, String jobGubCode, String manageId);
}

