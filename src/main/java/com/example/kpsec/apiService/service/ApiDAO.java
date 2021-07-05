package com.example.kpsec.apiService.service;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ApiDAO {
    List<Map<String, Object>> selectAcctInfoList(Map<String, Object> map) throws Exception;
}
