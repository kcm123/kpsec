package com.example.kpsec.common.model;

import lombok.Data;
import java.util.List;

@Data
public class ListResult<T> extends CommonResult {
    private List<T> list;
}
