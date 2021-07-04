package com.example.kpsec.apiService.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommonResult {
    @ApiModelProperty(value = "응답 코드번호")
    private String code;
    @ApiModelProperty(value = "응답메세지")
    private String message = "";
}
