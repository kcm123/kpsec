package com.example.kpsec.common.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class SingleResult<T> extends CommonResult {
    private T data;
}
