package com.kepco.etax.api.controller.v1;


import com.kepco.etax.api.config.security.JwtProvider;
import com.kepco.etax.api.domain.entity.EaiTaxDetailInfoKey;
import com.kepco.etax.api.domain.entity.EaiTaxHeaderInfoKey;
import com.kepco.etax.api.domain.request.EaiTaxDetailInfoRequest;
import com.kepco.etax.api.domain.request.EaiTaxHeaderInfoRequest;
import com.kepco.etax.api.domain.response.CommonResult;
import com.kepco.etax.api.domain.response.EaiTaxDetailInfoResponse;
import com.kepco.etax.api.domain.response.EaiTaxHeaderInfoResponse;
import com.kepco.etax.api.service.EtaxReverseTaxService;
import com.kepco.etax.api.service.ResponseService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(tags = {"3. CreateReverseTax"})
@RestController
@RequestMapping(value = "/api/v1")
@RequiredArgsConstructor
@CrossOrigin("*")
public class EtaxReverseTaxController {

    private final EtaxReverseTaxService etaxReverseTaxService;

    private final ResponseService responseService;

    private final JwtProvider jwtProvider;

    @PostMapping("/createReverseTaxHeader")
    public CommonResult createReverseTaxHeader(@RequestBody @Valid EaiTaxHeaderInfoRequest request) {

        EaiTaxHeaderInfoKey key = new EaiTaxHeaderInfoKey(request.getBizNo(), request.getConsNo(), request.getReqNo());

        if (etaxReverseTaxService.existReverseTaxHeaderByKey(key))
            return responseService.getFailResult(-1010, "이미 생성된 데이터가 있습니다.");

        return responseService.getSingleResult(etaxReverseTaxService.createReverseTaxHeader(request));
    }

    @PostMapping("/createReverseTaxHeaderBulk")
    public CommonResult createReverseTaxHeaderBulk(@RequestBody @Valid List<EaiTaxHeaderInfoRequest> request) {

        return responseService.getSingleResult(etaxReverseTaxService.createReverseTaxHeaderBulk(request));
    }

    @PostMapping("/createReverseTaxDetail")
    public CommonResult createReverseTaxDetail(@RequestBody @Valid EaiTaxDetailInfoRequest request) {

        EaiTaxDetailInfoKey key = new EaiTaxDetailInfoKey(request.getBizNo(), request.getConsNo(), request.getReqNo(),
                request.getAcptno(), request.getConsKndCd());

        if (etaxReverseTaxService.existReverseTaxDetailByKey(key))
            return responseService.getFailResult(-1010, "이미 생성된 데이터가 있습니다.");

        return responseService.getSingleResult(etaxReverseTaxService.createReverseTaxDetail(request));
    }

    @PostMapping("/createReverseTaxDetailBulk")
    public ResponseEntity<String> createReverseTaxDetailBulk(@RequestBody @Valid List<EaiTaxDetailInfoRequest> request) {
        return ResponseEntity.ok(etaxReverseTaxService.createReverseTaxDetailBulk(request));
    }


}
