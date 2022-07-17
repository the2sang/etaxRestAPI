package com.kepco.etax.api.service;


import com.kepco.etax.api.config.security.JwtProvider;
import com.kepco.etax.api.domain.entity.IfTaxBillInfoEntity;
import com.kepco.etax.api.domain.entity.IfTaxBillInfoKey;
import com.kepco.etax.api.domain.entity.IfTaxBillItemListEntity;
import com.kepco.etax.api.domain.entity.IfTaxBillItemListKey;
import com.kepco.etax.api.domain.request.IfTaxBillInfoRequest;
import com.kepco.etax.api.domain.request.IfTaxBillItemListRequest;
import com.kepco.etax.api.domain.response.IfTaxBillInfoResponse;
import com.kepco.etax.api.domain.response.IfTaxBillResultInfoResponse;
import com.kepco.etax.api.domain.response.SalsTaxResponse;
import com.kepco.etax.api.exception.*;
import com.kepco.etax.api.repository.IfTaxBillInfoRepository;
import com.kepco.etax.api.repository.IfTaxBillItemListRepository;
import com.kepco.etax.api.repository.IfTaxBillResultInfoRepository;
import io.jsonwebtoken.ExpiredJwtException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

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

    @Transactional(readOnly = true)
    public List<IfTaxBillResultInfoResponse> findSaleTaxResultInfo(String manageId) {

        return ifTaxBillResultInfoRepository.findByIfTaxBillResultInfoKeyManageId(manageId)
                .stream()
                .map(IfTaxBillResultInfoResponse::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<IfTaxBillInfoResponse> findByIfTaxBillInfoKeyManageId(String manageId) {

        return ifTaxBillInfoRepository.findByIfTaxBillInfoKeyManageId(manageId)
                .stream()
                .map(IfTaxBillInfoResponse::new)
                .collect(Collectors.toList());
    }

}
