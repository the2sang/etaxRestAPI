package com.kepco.etax.api.service;


import com.kepco.etax.api.domain.entity.IfTaxBillInfoEntity;
import com.kepco.etax.api.domain.entity.IfTaxBillInfoKey;
import com.kepco.etax.api.domain.entity.IfTaxBillItemListEntity;
import com.kepco.etax.api.domain.entity.IfTaxBillItemListKey;
import com.kepco.etax.api.domain.request.IfTaxBillInfoRequest;
import com.kepco.etax.api.domain.request.IfTaxBillItemListRequest;
import com.kepco.etax.api.domain.response.SalsTaxResponse;
import com.kepco.etax.api.exception.SaleTaxExistException;
import com.kepco.etax.api.repository.IfTaxBillInfoRepository;
import com.kepco.etax.api.repository.IfTaxBillItemListRepository;
import com.kepco.etax.api.repository.IfTaxBillResultInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EtaxSalesService {

    private final IfTaxBillInfoRepository ifTaxBillInfoRepository;

    private final IfTaxBillItemListRepository ifTaxBillItemListRepository;

    private final IfTaxBillResultInfoRepository ifTaxBillResultInfoRepository;

    @Transactional
    public IfTaxBillInfoKey createSalesTax(IfTaxBillInfoRequest request) {
        IfTaxBillInfoEntity ifTaxBillInfoEntity = new IfTaxBillInfoEntity();

        IfTaxBillInfoKey parentKey = new IfTaxBillInfoKey(request.getRelSystemId(), request.getJobGubCode(), request.getManageId());
        ifTaxBillInfoEntity.setIfTaxBillInfoKey(parentKey);
        request.setRegistDt(LocalDateTime.now());
        BeanUtils.copyProperties(request, ifTaxBillInfoEntity);
        System.out.println(ifTaxBillInfoEntity);
        IfTaxBillInfoEntity savedIfTaxBillInfoEntity = ifTaxBillInfoRepository.save(ifTaxBillInfoEntity);

        int seqNo = 1;
        for (IfTaxBillItemListRequest item: request.getItemList()) {
            IfTaxBillItemListEntity listEntity = new IfTaxBillItemListEntity();
            IfTaxBillItemListKey listKey = new IfTaxBillItemListKey(parentKey, seqNo);
            listEntity.setIfTaxBillItemListKey(listKey);
            BeanUtils.copyProperties(item, listEntity);
            ifTaxBillItemListRepository.save(listEntity);
            //ifTaxBillInfoEntity.addIfTaxBillItemListEntity(listEntity);
            seqNo++;
        }

        return savedIfTaxBillInfoEntity.getIfTaxBillInfoKey();
    }


    public IfTaxBillInfoKey createSalesTaxParentTable(IfTaxBillInfoRequest request) {

        IfTaxBillInfoEntity ifTaxBillInfoEntity = new IfTaxBillInfoEntity();

        IfTaxBillInfoKey ifTaxBillInfoKey = new IfTaxBillInfoKey(request.getRelSystemId(), request.getJobGubCode(), request.getManageId());
        ifTaxBillInfoEntity.setIfTaxBillInfoKey(ifTaxBillInfoKey);
        request.setRegistDt(LocalDateTime.now());
        BeanUtils.copyProperties(request, ifTaxBillInfoEntity);

        System.out.println(ifTaxBillInfoEntity);

        IfTaxBillInfoEntity returnEntity = ifTaxBillInfoRepository.save(ifTaxBillInfoEntity);

        return returnEntity.getIfTaxBillInfoKey();


    }

    @Transactional(readOnly = true)
    public SalsTaxResponse findSalesTaxByKey(String relSystemId, String jobGubCode, String manageId) {

        IfTaxBillInfoKey key = new IfTaxBillInfoKey();

        key.setRelSystemId(relSystemId);
        key.setJobGubCode(jobGubCode);
        key.setManageId(manageId);

        IfTaxBillInfoEntity ifTaxBillInfoEntity = ifTaxBillInfoRepository.findById(key)
                .orElseThrow(SaleTaxExistException::new);

        return new SalsTaxResponse(ifTaxBillInfoEntity);
    }

}
