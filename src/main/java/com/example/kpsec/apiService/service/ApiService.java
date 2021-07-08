package com.example.kpsec.apiService.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
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
        List<Map<String, Object>> newList = new ArrayList<>();
        // 출력 포멧에 맞춰 수정(newList)
        if(list != null && list.size() > 0){
            String years = "";
            Map<String, Object> map = new HashMap<>();
            List<Map<String, Object>> mapList = new ArrayList<>();
            for(int i = 0; i < list.size(); i++){
                Map<String, Object> dbMap = list.get(i);
                String year = (String) dbMap.get("year");
                if(!years.equals(year)){
                    if(i != 0) {
                        map.put("dataList", mapList);
                        map.put("year", years);
                        newList.add(map);
                        // 초기화
                        map = new HashMap<>();
                        mapList = new ArrayList<>();
                    }
                    years = year;
                }
                dbMap.remove("year");
                mapList.add(list.get(i));
            }
            // 마지막 데이터 추가
            map.put("year", years);
            map.put("dataList", mapList);
            newList.add(map);
        }
        logger.info("getOrderByMax() completed::" + newList.size());
        return newList;
    }
    // 4. 지점명을 입력하면 해당지점의 거래금액 합계를 출력
    public Map<String, Object> getSumAmt(Map<String, Object> paramMap) throws Exception{
        Map<String, Object> map = acctInfoDAO.selectSumAmt(paramMap);
        logger.info("getSumAmt() completed::");
        return map;
    }
}
