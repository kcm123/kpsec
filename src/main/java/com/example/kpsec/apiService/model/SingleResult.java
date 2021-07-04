package com.example.kpsec.apiService.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Data
@EqualsAndHashCode(callSuper=false)
public class SingleResult<T> extends CommonResult {
    private T data;
}
