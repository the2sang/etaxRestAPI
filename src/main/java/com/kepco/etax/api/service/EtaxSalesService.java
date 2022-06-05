package com.kepco.etax.api.service;


import com.kepco.etax.api.domain.entity.IfTaxBillInfoEntity;
import com.kepco.etax.api.domain.entity.IfTaxBillInfoKey;
import com.kepco.etax.api.domain.entity.IfTaxBillItemListEntity;
import com.kepco.etax.api.domain.entity.IfTaxBillItemListKey;
import com.kepco.etax.api.domain.request.IfTaxBillInfoRequest;
import com.kepco.etax.api.domain.request.IfTaxBillItemListRequest;
import com.kepco.etax.api.repository.IfTaxBillInfoRepository;
import com.kepco.etax.api.repository.IfTaxBillItemListRepository;
import com.kepco.etax.api.repository.IfTaxBillResultInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class EtaxSalesService {

    private final IfTaxBillInfoRepository ifTaxBillInfoRepository;

    private final IfTaxBillItemListRepository ifTaxBillItemListRepository;

    private final IfTaxBillResultInfoRepository ifTaxBillResultInfoRepository;


    public IfTaxBillInfoEntity createSalesTax(IfTaxBillInfoRequest request) {
        IfTaxBillInfoEntity ifTaxBillInfoEntity = new IfTaxBillInfoEntity();

        IfTaxBillInfoKey parentKey = new IfTaxBillInfoKey(request.getRelSystemId(), request.getJobGubCode(), request.getManageId());
        ifTaxBillInfoEntity.setIfTaxBillInfoKey(parentKey);
        request.setRegistDt(LocalDateTime.now());
        BeanUtils.copyProperties(request, ifTaxBillInfoEntity);
        System.out.println(ifTaxBillInfoEntity);
        IfTaxBillInfoEntity savedIfTaxBillInfoEntity = ifTaxBillInfoRepository.save(ifTaxBillInfoEntity);

        int seqNo = 1;
        for (IfTaxBillItemListRequest item: request.getItemListRequest()) {
            IfTaxBillItemListEntity listEntity = new IfTaxBillItemListEntity();
            IfTaxBillItemListKey listKey = new IfTaxBillItemListKey(parentKey, seqNo);
            listEntity.setIfTaxBillItemListKey(listKey);
            BeanUtils.copyProperties(item, listEntity);
            ifTaxBillItemListRepository.save(listEntity);
            //ifTaxBillInfoEntity.addIfTaxBillItemListEntity(listEntity);
            seqNo++;
        }

        return savedIfTaxBillInfoEntity;
    }


    public IfTaxBillInfoEntity createSalesTaxParentTable(IfTaxBillInfoRequest request) {

        IfTaxBillInfoEntity ifTaxBillInfoEntity = new IfTaxBillInfoEntity();

        IfTaxBillInfoKey ifTaxBillInfoKey = new IfTaxBillInfoKey(request.getRelSystemId(), request.getJobGubCode(), request.getManageId());
        ifTaxBillInfoEntity.setIfTaxBillInfoKey(ifTaxBillInfoKey);
        request.setRegistDt(LocalDateTime.now());
        BeanUtils.copyProperties(request, ifTaxBillInfoEntity);

        System.out.println(ifTaxBillInfoEntity);

        IfTaxBillInfoEntity returnEntity = ifTaxBillInfoRepository.save(ifTaxBillInfoEntity);

        return returnEntity;


    }

}
