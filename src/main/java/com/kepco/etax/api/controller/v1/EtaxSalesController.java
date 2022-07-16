package com.kepco.etax.api.controller.v1;

import com.kepco.etax.api.domain.entity.IfTaxBillInfoKey;
import com.kepco.etax.api.domain.request.IfTaxBillInfoRequest;
import com.kepco.etax.api.service.EtaxSalesService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"2. CreateSaleTax"})
@RestController
@RequestMapping(value = "/api/v1")
@RequiredArgsConstructor
@CrossOrigin("*")
public class EtaxSalesController {

    private final EtaxSalesService etaxSalesService;

    @PostMapping("/createSaleTax")
    public ResponseEntity<IfTaxBillInfoKey> createCreateSaleTax (@RequestBody IfTaxBillInfoRequest request) {
        return ResponseEntity.ok(etaxSalesService.createSalesTax(request));
    }

    @PostMapping("/createSaleTaxParentTable")
    public ResponseEntity<IfTaxBillInfoKey> createCreateSaleTaxEmbedded (@RequestBody IfTaxBillInfoRequest request) {
        return ResponseEntity.ok(etaxSalesService.createSalesTaxParentTable(request));
    }

}
