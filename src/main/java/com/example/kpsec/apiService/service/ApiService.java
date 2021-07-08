package com.example.kpsec.apiService.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

@Service
public class ApiService {

    private static final Logger logger = LoggerFactory.getLogger(ApiService.class);

    @Autowired
    ApiDAO acctInfoDAO;
    // 1. 연도별 합계 금액이 가장 많은 고객
    public List<Map<String, Object>> getMaxSumCustomer() throws Exception{
        List<Map<String, Object>> list = acctInfoDAO.selectMaxSumCustomer();
        logger.info("getMaxSumCustomer() completed::" + list.size());
        return list;
    }
    // 2. 거래가 없는 고객(2018 or 2019)
    public List<Map<String, Object>> getNoTransaction() throws Exception{
        List<Map<String, Object>> list = acctInfoDAO.selectNoTransaction();
        logger.info("getNoTransaction() completed::" + list.size());
        return list;
    }
    // 3. 거래 합계금액이 큰 순서로 출력
    public List<Map<String, Object>> getOrderByMax() throws Exception{
        List<Map<String, Object>> list = acctInfoDAO.selectOrderByMax();
        logger.info("getOrderByMax() completed::" + list.size());
        return list;
    }
    // 4. 지점명을 입력하면 해당지점의 거래금액 합계를 출력
    public Map<String, Object> getSumAmt(Map<String, Object> paramMap) throws Exception{
        Map<String, Object> map = acctInfoDAO.selectSumAmt(paramMap);
        logger.info("getSumAmt() completed::" + paramMap);
        return map;
    }
}
