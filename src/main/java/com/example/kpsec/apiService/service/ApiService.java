package com.example.kpsec.apiService.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ApiService {

    private static final Logger logger = LoggerFactory.getLogger(ApiService.class);

    @Autowired
    ApiDAO acctInfoDAO;

    public List<Map<String, Object>> getMaxSumCustomer() throws Exception{
        List<Map<String, Object>> list = acctInfoDAO.selectMaxSumCustomer();
        return list;
    }
    public List<Map<String, Object>> getNoTransaction() throws Exception{
        List<Map<String, Object>> list = acctInfoDAO.selectNoTransaction();
        return list;
    }
    public List<Map<String, Object>> getOrderByMax() throws Exception{
        List<Map<String, Object>> list = acctInfoDAO.selectOrderByMax();
        return list;
    }
    public Map<String, Object> getSumAmt(Map<String, Object> paramMap) throws Exception{
        Map<String, Object> map = new HashMap<>();
        map.put("brName", "분당점");
        map.put("brCode", "1111");
        return map;
    }
}
