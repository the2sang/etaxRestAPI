package com.kepco.etax.api.repository;

import com.kepco.etax.api.domain.entity.EaiTaxHeaderInfoEntity;
import com.kepco.etax.api.domain.entity.EaiTaxHeaderInfoKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EaiTaxHeaderInfoRepository extends JpaRepository<EaiTaxHeaderInfoEntity, EaiTaxHeaderInfoKey> {

}
