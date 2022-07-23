package com.kepco.etax.api.controller.v1;

import com.kepco.etax.api.config.security.JwtProvider;
import com.kepco.etax.api.domain.entity.IfTaxBillInfoEntity;
import com.kepco.etax.api.domain.entity.IfTaxBillInfoKey;
import com.kepco.etax.api.domain.request.IfTaxBillInfoRequest;
import com.kepco.etax.api.domain.response.*;
import com.kepco.etax.api.exception.EntityExistException;
import com.kepco.etax.api.exception.ExpiredAccessTokenException;
import com.kepco.etax.api.service.EtaxSalesService;
import com.kepco.etax.api.service.ResponseService;
import com.sun.xml.bind.v2.runtime.unmarshaller.XsiNilLoader;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Api(tags = {"2. CreateSaleTax"})
@RestController
@RequestMapping(value = "/api/v1")
@RequiredArgsConstructor
@CrossOrigin("*")
public class EtaxSalesController {

    private final EtaxSalesService etaxSalesService;

    private final ResponseService responseService;

    private final JwtProvider jwtProvider;

    @PostMapping("/createSaleTax")
    public CommonResult createSaleTax (@RequestBody @Valid IfTaxBillInfoRequest request) {

        SalsTaxResponse response =
                etaxSalesService.findSalesTaxByKey(request.getRelSystemId(), request.getJobGubCode(), request.getManageId());

        if (response != null) {

            return responseService.getFailResult(-1010, "이미 생성된 데이터가 있습니다.");
        }

        return responseService.getSingleResult(etaxSalesService.createSalesTax(request));
    }

//    @PostMapping("/createSaleTaxParentTable")
//    public ResponseEntity<IfTaxBillInfoKey> createCreateSaleTaxEmbedded (@RequestBody IfTaxBillInfoRequest request) {
//        return ResponseEntity.ok(etaxSalesService.createSalesTaxParentTable(request));
//    }

    @GetMapping("/findSaleTaxOne")
    public SingleResult<SalsTaxResponse> findSaleTaxOne(@RequestParam String relSystemId,
                                                        @RequestParam String jobGubCode,
                                                        @RequestParam String manageId) {
//        String accessKey = req.getHeader("X-AUTH-TOKEN");
//
//        if (!jwtProvider.validationToken(accessKey)) {
//            throw new ExpiredAccessTokenException();
//        }

        return responseService.getSingleResult(etaxSalesService.findSalesTaxByKey(relSystemId, jobGubCode, manageId));
    }

    @GetMapping("/findSaleTaxResultInfo")
    public ListResult<IfTaxBillResultInfoResponse> findSaleTaxResultInfo(@RequestParam String manageId) {

        return responseService.getListResult(etaxSalesService.findSaleTaxResultInfo(manageId));
    }

    @GetMapping("findByIfTaxBillInfoKeyManageId")
    public ListResult<IfTaxBillInfoResponse> findByIfTaxBillInfoKeyManageId(@RequestParam String manageId) {


        return responseService.getListResult(etaxSalesService.findByIfTaxBillInfoKeyManageId(manageId));
    }

}
