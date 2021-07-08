package com.example.kpsec.common.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper=false)
public class ListResult<T> extends CommonResult {
    private List<T> list;
}
