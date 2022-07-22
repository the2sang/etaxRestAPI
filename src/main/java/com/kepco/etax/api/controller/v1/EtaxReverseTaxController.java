package com.kepco.etax.api.controller.v1;


import com.kepco.etax.api.config.security.JwtProvider;
import com.kepco.etax.api.domain.entity.EaiTaxDetailInfoKey;
import com.kepco.etax.api.domain.entity.EaiTaxHeaderInfoKey;
import com.kepco.etax.api.domain.request.EaiTaxDetailInfoRequest;
import com.kepco.etax.api.domain.request.EaiTaxHeaderInfoRequest;
import com.kepco.etax.api.service.EtaxReverseTaxService;
import com.kepco.etax.api.service.ResponseService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
    public ResponseEntity<EaiTaxHeaderInfoKey> createReverseTaxHeader(@RequestBody @Valid EaiTaxHeaderInfoRequest request) {
        return ResponseEntity.ok(etaxReverseTaxService.createReverseTaxHeader(request));
    }

    @PostMapping("/createReverseTaxDetail")
    public ResponseEntity<EaiTaxDetailInfoKey> createReverseTaxDetail(@RequestBody @Valid EaiTaxDetailInfoRequest request) {
        return ResponseEntity.ok(etaxReverseTaxService.createReverseTaxDetail(request));
    }


}
