package com.kepco.etax.api.service;


import com.kepco.etax.api.domain.entity.IfTaxBillInfoEntity;
import com.kepco.etax.api.domain.entity.IfTaxBillItemListEntity;
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


        int seqNo = 1;
        for (IfTaxBillItemListRequest item: request.getItemListRequest()) {
            IfTaxBillItemListEntity listEntity =
                new IfTaxBillItemListEntity();
            listEntity.setRelSystemId(request.getRelSystemId());
            listEntity.setJobGubCode(request.getJobGubCode());
            listEntity.setManageId(request.getManageId());

            listEntity.setSeqNo(seqNo);
            BeanUtils.copyProperties(item, listEntity);
            //ifTaxBillInfoEntity.addIfTaxBillItemListEntity(listEntity);
            seqNo++;
            ifTaxBillItemListRepository.save(listEntity);

        }

        request.setRegistDt(LocalDateTime.now());

        BeanUtils.copyProperties(request, ifTaxBillInfoEntity);

        System.out.println(ifTaxBillInfoEntity);

        return ifTaxBillInfoRepository.save(ifTaxBillInfoEntity);
    }

}
