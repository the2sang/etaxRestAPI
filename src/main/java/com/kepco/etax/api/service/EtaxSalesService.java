package com.kepco.etax.api.service;


import com.kepco.etax.api.domain.entity.IfTaxBillInfo;
import com.kepco.etax.api.domain.entity.IfTaxBillInfoId;
import com.kepco.etax.api.domain.entity.IfTaxBillItemList;
import com.kepco.etax.api.domain.entity.IfTaxBillItemListId;
import com.kepco.etax.api.domain.request.IfTaxBillInfoRequest;
import com.kepco.etax.api.domain.request.IfTaxBillItemListRequest;
import com.kepco.etax.api.repository.IfTaxBillInfoRepository;
import com.kepco.etax.api.repository.IfTaxBillItemListRepository;
import com.kepco.etax.api.repository.IfTaxBillResultInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EtaxSalesService {

    private final IfTaxBillInfoRepository ifTaxBillInfoRepository;

    private final IfTaxBillItemListRepository ifTaxBillItemListRepository;

    private final IfTaxBillResultInfoRepository ifTaxBillResultInfoRepository;


    public IfTaxBillInfoId createSalesTax(IfTaxBillInfoRequest request) {
        IfTaxBillInfo ifTaxBillInfo = new IfTaxBillInfo();

        IfTaxBillInfoId parentId = new IfTaxBillInfoId(request.getRelSystemId(), request.getJobGubCode(), request.getManageId());
        ifTaxBillInfo.setId(parentId);
        request.setRegistDt(LocalDateTime.now());
        BeanUtils.copyProperties(request, ifTaxBillInfo);
        System.out.println(ifTaxBillInfo);
        IfTaxBillInfo savedIfTaxBillInfo = ifTaxBillInfoRepository.save(ifTaxBillInfo);

        int seqNo = 1;
        for (IfTaxBillItemListRequest item: request.getItemList()) {
            IfTaxBillItemList listEntity = new IfTaxBillItemList();
            IfTaxBillItemListId listKey =
                new IfTaxBillItemListId(parentId.getRelSystemId(), parentId.getJobGubCode(), parentId.getManageId(), seqNo);
            listEntity.setId(listKey);
            BeanUtils.copyProperties(item, listEntity);
            ifTaxBillItemListRepository.save(listEntity);
            //ifTaxBillInfoEntity.addIfTaxBillItemListEntity(listEntity);
            seqNo++;
        }

        return savedIfTaxBillInfo.getId();
    }


    public IfTaxBillInfoId createSalesTaxParentTable(IfTaxBillInfoRequest request) {

        IfTaxBillInfo ifTaxBillInfo = new IfTaxBillInfo();

        IfTaxBillInfoId id = new IfTaxBillInfoId(request.getRelSystemId(), request.getJobGubCode(), request.getManageId());
        ifTaxBillInfo.setId(id);
        request.setRegistDt(LocalDateTime.now());
        BeanUtils.copyProperties(request, ifTaxBillInfo);

        System.out.println(ifTaxBillInfo);

        IfTaxBillInfo returnEntity = ifTaxBillInfoRepository.save(ifTaxBillInfo);

        return returnEntity.getId();


    }

    public List<IfTaxBillInfo> getSalesTax(String relSystemId, String jobGubCode, String manageId) {

        List<IfTaxBillInfo> salesTax =
            ifTaxBillInfoRepository.findByIdRelSystemIdAndIdJobGubCodeAndIdManageId(relSystemId, jobGubCode, manageId);

        return salesTax;

    }

    public List<IfTaxBillItemList> getSalesTaxItemList(String relSystemId, String jobGubCode, String manageId) {
        List<IfTaxBillItemList> salesTaxItemList =
            ifTaxBillItemListRepository.findByIdRelSystemIdAndIdJobGubCodeAndIdManageId(relSystemId, jobGubCode, manageId);

        return salesTaxItemList;
    }


}
