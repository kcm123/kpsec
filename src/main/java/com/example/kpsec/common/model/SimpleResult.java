package com.example.kpsec.common.model;

import lombok.Data;

@Data
public class SimpleResult<T> {
    private T data;
}
