package com.example.kpsec.common.model;

import lombok.Data;

@Data
public class SingleResult<T> extends CommonResult {
    private T data;
}
