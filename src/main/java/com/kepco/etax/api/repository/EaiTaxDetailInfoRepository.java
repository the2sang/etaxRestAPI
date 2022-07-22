package com.kepco.etax.api.repository;

import com.kepco.etax.api.domain.entity.EaiTaxDetailInfoEntity;
import com.kepco.etax.api.domain.entity.EaiTaxDetailInfoKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EaiTaxDetailInfoRepository  extends JpaRepository<EaiTaxDetailInfoEntity, EaiTaxDetailInfoKey> {

}
