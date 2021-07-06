package com.example.kpsec.apiService.service;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ApiDAO {
    List<Map<String, Object>> selectMaxSumCustomer() throws Exception;
    List<Map<String, Object>> selectNoTransaction() throws Exception;
    List<Map<String, Object>> selectOrderByMax() throws Exception;
    Map<String, Object> selectSumAmt(Map<String, Object> paramMap) throws Exception;
}
