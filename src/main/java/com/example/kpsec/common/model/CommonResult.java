package com.example.kpsec.common.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CommonResult {
    @ApiModelProperty(value = "응답 코드번호")
    private String code;
    @ApiModelProperty(value = "응답메세지")
    private String message = "";
}
