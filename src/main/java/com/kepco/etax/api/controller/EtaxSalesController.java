package com.kepco.etax.api.controller;

import com.kepco.etax.api.domain.entity.IfTaxBillInfo;
import com.kepco.etax.api.domain.entity.IfTaxBillInfoId;
import com.kepco.etax.api.domain.entity.IfTaxBillItemList;
import com.kepco.etax.api.domain.request.IfTaxBillInfoRequest;
import com.kepco.etax.api.service.EtaxSalesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/etax")
@RequiredArgsConstructor
@CrossOrigin("*")
public class EtaxSalesController {

    private final EtaxSalesService etaxSalesService;

    @PostMapping("/createSaleTax")
    public ResponseEntity<IfTaxBillInfoId> createCreateSaleTax (@RequestBody IfTaxBillInfoRequest request) {
        return ResponseEntity.ok(etaxSalesService.createSalesTax(request));
    }

    @PostMapping("/createSaleTaxParentTable")
    public ResponseEntity<IfTaxBillInfoId> createCreateSaleTaxEmbedded (@RequestBody IfTaxBillInfoRequest request) {
        return ResponseEntity.ok(etaxSalesService.createSalesTaxParentTable(request));
    }

    @PostMapping("/getSalesTax")
    public ResponseEntity<List<IfTaxBillInfo>> getSalesTax(@RequestBody IfTaxBillInfoId request) {

        List<IfTaxBillInfo> salesTax =
            etaxSalesService.getSalesTax(request.getRelSystemId(), request.getJobGubCode(), request.getManageId());

        return new ResponseEntity<List<IfTaxBillInfo>>(salesTax, HttpStatus.OK);

    }

    @PostMapping("/getSalesTaxItemList")
    public ResponseEntity<List<IfTaxBillItemList>> getSalesTaxItemList(@RequestBody IfTaxBillInfoId request) {
        List<IfTaxBillItemList> salesTaxItemList =
            etaxSalesService.getSalesTaxItemList(request.getRelSystemId(), request.getJobGubCode(), request.getManageId());

        return new ResponseEntity<List<IfTaxBillItemList>>(salesTaxItemList, HttpStatus.OK);
    }

}
