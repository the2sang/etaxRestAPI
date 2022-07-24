package com.kepco.etax.api.controller.v1;

import com.kepco.etax.api.config.security.JwtProvider;
import com.kepco.etax.api.domain.entity.IfTaxBillInfoEntity;
import com.kepco.etax.api.domain.entity.IfTaxBillInfoKey;
import com.kepco.etax.api.domain.request.IfTaxBillInfoRequest;
import com.kepco.etax.api.domain.response.*;
import com.kepco.etax.api.service.EtaxSalesTaxService;
import com.kepco.etax.api.service.ResponseService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(tags = {"2. CreateSaleTax"})
@RestController
@RequestMapping(value = "/api/v1")
@RequiredArgsConstructor
@CrossOrigin("*")
public class EtaxSalesController {

    private final EtaxSalesTaxService etaxSalesTaxService;

    private final ResponseService responseService;

    private final JwtProvider jwtProvider;

    @PostMapping("/createSaleTax")
    public CommonResult createSaleTax (@RequestBody @Valid IfTaxBillInfoRequest request) {

//        etaxSalesService.findSalesTaxByKey(request.getRelSystemId(), request.getJobGubCode(), request.getManageId());
        IfTaxBillInfoKey key = new IfTaxBillInfoKey(request.getRelSystemId(), request.getJobGubCode(),request.getManageId());

        if (etaxSalesTaxService.existIfTaxBillInfoByKey(key)) {
            return responseService.getFailResult(-1010, "이미 생성된 데이터가 있습니다.");
        }

        return responseService.getSingleResult(etaxSalesTaxService.createSalesTax(request));
    }

    @GetMapping("/findSaleTaxByKey")
    public CommonResult findSaleTaxByKey(@RequestParam String relSystemId,
                                                        @RequestParam String jobGubCode,
                                                        @RequestParam String manageId) {

        if (!etaxSalesTaxService.existIfTaxBillInfoByKey(new IfTaxBillInfoKey(relSystemId, jobGubCode, manageId))) {
            return responseService.getFailResult(-1020, "검색조건에 맞는 데이터가 없습니다.");
        }

        return responseService.getSingleResult(etaxSalesTaxService.findSalesTaxByKey(relSystemId, jobGubCode, manageId));
    }

//    @GetMapping("/findSaleTaxResultInfoByKey")
//    public CommonResult findSaleTaxResultInfoByKey(@RequestParam String relSystemId,
//                                       @RequestParam String jobGubCode,
//                                       @RequestParam String manageId,
//                                                   @RequestParam String statusCode,
//                                                   @RequestParam String registDt) {
//
//        if (!etaxSalesTaxService.existIfTaxBillInfoByKey(new IfTaxBillInfoKey(relSystemId, jobGubCode, manageId))) {
//            return responseService.getFailResult(-1020, "검색조건에 맞는 데이터가 없습니다.");
//        }
//
//        return responseService.getSingleResult(etaxSalesTaxService.findSalesTaxByKey(relSystemId, jobGubCode, manageId));
//    }

    @GetMapping("/findSaleTaxResultInfo")
    public ListResult<IfTaxBillResultInfoResponse> findSaleTaxResultInfo(@RequestParam String manageId) {

        return responseService.getListResult(etaxSalesTaxService.findSaleTaxResultInfo(manageId));
    }

    @GetMapping("findByIfTaxBillInfoKeyManageId")
    public ListResult<IfTaxBillInfoResponse> findByIfTaxBillInfoKeyManageId(@RequestParam String manageId) {


        return responseService.getListResult(etaxSalesTaxService.findByIfTaxBillInfoKeyManageId(manageId));
    }

}
