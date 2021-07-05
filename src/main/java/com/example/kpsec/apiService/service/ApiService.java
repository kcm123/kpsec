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

    public List<Map<String, Object>> getList() throws Exception{
        Map<String, Object> map = new HashMap<>();
        List<Map<String, Object>> list = acctInfoDAO.selectAcctInfoList(map);
//        List<Map<String,Object>> list = new ArrayList<>();
//        Map<String, Object> map1 = new HashMap<>();
//        map1.put("year", "2019");
//        map1.put("name", "국민은행");
//        map1.put("acctNo", "12345");
//        Map<String, Object> map2 = new HashMap<>();
//        map2.put("year", "2021");
//        map2.put("name", "시티은행");
//        map2.put("acctNo", "00000");
//        list.add(map1);
//        list.add(map2);
//        logger.info("getList completed");
        return list;
    };

}
