package com.kepco.etax.api.controller;

import com.kepco.etax.api.domain.Author;
import com.kepco.etax.api.domain.entity.IfTaxBillInfoEntity;
import com.kepco.etax.api.domain.request.AuthorCreationRequest;
import com.kepco.etax.api.domain.request.IfTaxBillInfoRequest;
import com.kepco.etax.api.service.EtaxSalesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/etax")
@RequiredArgsConstructor
@CrossOrigin("*")
public class EtaxSalesController {

    private final EtaxSalesService etaxSalesService;

    @PostMapping("/createSaleTax")
    public ResponseEntity<IfTaxBillInfoEntity> createCreateSaleTax (@RequestBody IfTaxBillInfoRequest request) {
        return ResponseEntity.ok(etaxSalesService.createSalesTax(request));
    }

    @PostMapping("/createSaleTaxParentTable")
    public ResponseEntity<IfTaxBillInfoEntity> createCreateSaleTaxEmbedded (@RequestBody IfTaxBillInfoRequest request) {
        return ResponseEntity.ok(etaxSalesService.createSalesTaxParentTable(request));
    }

}
