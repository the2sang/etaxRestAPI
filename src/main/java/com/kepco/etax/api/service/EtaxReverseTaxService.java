package com.kepco.etax.api.service;


import com.kepco.etax.api.domain.entity.EaiTaxDetailInfoEntity;
import com.kepco.etax.api.domain.entity.EaiTaxDetailInfoKey;
import com.kepco.etax.api.domain.entity.EaiTaxHeaderInfoEntity;
import com.kepco.etax.api.domain.entity.EaiTaxHeaderInfoKey;
import com.kepco.etax.api.domain.request.EaiTaxDetailInfoRequest;
import com.kepco.etax.api.domain.request.EaiTaxHeaderInfoRequest;
import com.kepco.etax.api.domain.response.EaiTaxDetailInfoResponse;
import com.kepco.etax.api.domain.response.EaiTaxHeaderInfoResponse;
import com.kepco.etax.api.exception.EntityExistException;
import com.kepco.etax.api.repository.EaiTaxDetailInfoRepository;
import com.kepco.etax.api.repository.EaiTaxHeaderInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EtaxReverseTaxService {

    private final EaiTaxHeaderInfoRepository eaiTaxHeaderInfoRepository;

    private final EaiTaxDetailInfoRepository eaiTaxDetailInfoRepository;

    @Transactional
    public EaiTaxHeaderInfoKey createReverseTaxHeader(EaiTaxHeaderInfoRequest request) {

        EaiTaxHeaderInfoEntity entity = new EaiTaxHeaderInfoEntity();

        EaiTaxHeaderInfoKey key = new EaiTaxHeaderInfoKey(request.getBizNo(), request.getConsNo(), request.getReqNo());
        entity.setEaiTaxHeaderInfoKey(key);
        BeanUtils.copyProperties(request, entity);
        EaiTaxHeaderInfoEntity savedEntity = eaiTaxHeaderInfoRepository.save(entity);

        return savedEntity.getEaiTaxHeaderInfoKey();

    }

    @Transactional
    public String createReverseTaxHeaderBulk(List<EaiTaxHeaderInfoRequest> rows) {

        List<EaiTaxHeaderInfoEntity> saveEntityList = new ArrayList<>();

        int dupleCount = 0;

        for (EaiTaxHeaderInfoRequest row : rows) {
            EaiTaxHeaderInfoEntity entity = new EaiTaxHeaderInfoEntity();

            EaiTaxHeaderInfoKey key = new EaiTaxHeaderInfoKey(row.getBizNo(), row.getConsNo(), row.getReqNo());

            Optional<EaiTaxHeaderInfoEntity> existEntity =eaiTaxHeaderInfoRepository.findById(key);

            if (existEntity.isPresent()) {
                dupleCount++;
            } else {
                entity.setEaiTaxHeaderInfoKey(key);
                BeanUtils.copyProperties(row, entity);
                saveEntityList.add(entity);
            }
        }
        eaiTaxHeaderInfoRepository.saveAll(saveEntityList);

        return "Save Success:" + (rows.size() - dupleCount) + " / Duplicated Fail:" + dupleCount;

    }

    @Transactional
    public EaiTaxDetailInfoKey createReverseTaxDetail(EaiTaxDetailInfoRequest request) {

        EaiTaxDetailInfoEntity entity = new EaiTaxDetailInfoEntity();

        EaiTaxDetailInfoKey key = new EaiTaxDetailInfoKey(request.getBizNo(), request.getConsNo(), 
                request.getReqNo(), request.getAcptno(), request.getConsKndCd());
        entity.setEaiTaxDetailInfoKey(key);
        BeanUtils.copyProperties(request, entity);
        EaiTaxDetailInfoEntity savedEntity = eaiTaxDetailInfoRepository.save(entity);

        return savedEntity.getEaiTaxDetailInfoKey();

    }

    @Transactional
    public String createReverseTaxDetailBulk(List<EaiTaxDetailInfoRequest> rows) {

        List<EaiTaxDetailInfoEntity> saveEntityList = new ArrayList<>();

        int dupleCount = 0;

        for (EaiTaxDetailInfoRequest row : rows) {
            EaiTaxDetailInfoEntity entity = new EaiTaxDetailInfoEntity();

            EaiTaxDetailInfoKey key = new EaiTaxDetailInfoKey(row.getBizNo(),row.getConsNo(), row.getReqNo(),
                    row.getAcptno(), row.getConsKndCd());

            Optional<EaiTaxDetailInfoEntity> existEntity =eaiTaxDetailInfoRepository.findById(key);

            if (existEntity.isPresent()) {
                dupleCount++;
            } else {
                entity.setEaiTaxDetailInfoKey(key);
                BeanUtils.copyProperties(row, entity);
                saveEntityList.add(entity);
            }
        }

        eaiTaxDetailInfoRepository.saveAll(saveEntityList);

        return "Save Success:" + (rows.size() - dupleCount) + " / Duplicated Fail:" + dupleCount;

    }

    public EaiTaxHeaderInfoResponse findReverseTaxHeaderByKey(String bizNo, String consNo, String reqNo) {
        EaiTaxHeaderInfoKey key = new EaiTaxHeaderInfoKey();

        key.setBizNo(bizNo);
        key.setConsNo(consNo);
        key.setReqNo(reqNo);

        EaiTaxHeaderInfoEntity entity = eaiTaxHeaderInfoRepository.findById(key)
                .orElseThrow(EntityExistException::new);

        return new EaiTaxHeaderInfoResponse((entity));
    }

    public EaiTaxDetailInfoResponse findReverseTaxDetailByKey(String bizNo, String consNo, String reqNo, String acptno, String consKndCd) {
        EaiTaxDetailInfoKey key = new EaiTaxDetailInfoKey();

        key.setBizNo(bizNo);
        key.setConsNo(consNo);
        key.setReqNo(reqNo);
        key.setAcptno(acptno);
        key.setConsKndCd(consKndCd);

        EaiTaxDetailInfoEntity entity = eaiTaxDetailInfoRepository.findById(key)
                .orElseThrow(EntityExistException::new);

        return  new EaiTaxDetailInfoResponse((entity));
    }

    public boolean existReverseTaxHeaderByKey(EaiTaxHeaderInfoKey key) {

        return eaiTaxHeaderInfoRepository.existsById(key);
    }

    public boolean existReverseTaxDetailByKey(EaiTaxDetailInfoKey key) {

       return eaiTaxDetailInfoRepository.existsById(key);
    }

}
