package com.kepco.etax.api.repository;

import com.kepco.etax.api.domain.entity.IfTaxBillItemListEntity;
import com.kepco.etax.api.domain.entity.IfTaxBillItemListKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IfTaxBillItemListRepository extends JpaRepository<IfTaxBillItemListEntity, IfTaxBillItemListKey> {

}
