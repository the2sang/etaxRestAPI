package com.kepco.etax.api.domain.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class IfTaxBillItemListRequest {

    @ApiModelProperty(value = "물품 공급일자", example = "yyyymmdd-8")
    private String purchaseDay;

    @ApiModelProperty(value = "물품명", example = "text-100")
    private String itemName;

    @ApiModelProperty(value = "물품에 대한 규격", example = "text-60")
    private String itemInfo;

    @ApiModelProperty(value = "물품과 관련된 자유기술문", example = "text-100")
    private String itemDesc;

    @ApiModelProperty(value = "수량", example = "number-12,3")
    private double unitQuantity;

    @ApiModelProperty(value = "물품 단가", example = "number-16,2")
    private double unitAmount;

    @ApiModelProperty(value = "물품 공급 가액", example = "number-18")
    private long invoiceAmount;

    @ApiModelProperty(value = "물품 세액", example = "number-18")
    private long taxAmount;

    @ApiModelProperty(value = "청구발행년월", example = "yyyymm-6")
    private String billIssueYyyymm;

}
