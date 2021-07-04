package com.example.kpsec.apiService.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

//@Getter
//@Setter
//@Data
//@EqualsAndHashCode(callSuper=false)
public class CommonResult {
    @ApiModelProperty(value = "응답 코드번호")
    private String code;
    @ApiModelProperty(value = "응답메세지")
    private String message = "";

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
