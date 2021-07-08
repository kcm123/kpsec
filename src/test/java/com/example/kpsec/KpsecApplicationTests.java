package com.example.kpsec;

import com.example.kpsec.apiService.service.ApiService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

@RunWith(SpringRunner.class)
@SpringBootTest
class KpsecApplicationTests {

    @Autowired
    ApiService apiService;

    private static final Logger logger = LoggerFactory.getLogger(KpsecApplicationTests.class);

    // 1. 연도별 합계 금액이 가장 많은 고객
    @Test
    void getMaxSumCustomer() {
        try {
            List<Map<String, Object>> list = apiService.getMaxSumCustomer();
            String jsonString = new ObjectMapper().writeValueAsString(list);
            logger.info("1. 연도별 합계 금액이 가장 많은 고객 completed::" + list.size());
            logger.info(jsonString);
        }catch (Exception e){
            logger.error(e.toString());
        }
    }
    // 2. 거래가 없는 고객(2018 or 2019)
    @Test
    void getNoTransaction() {
        try {
            List<Map<String, Object>> list = apiService.getNoTransaction();
            String jsonString = new ObjectMapper().writeValueAsString(list);
            logger.info("2. 거래가 없는 고객(2018 or 2019) completed::" + list.size());
            logger.info(jsonString);
        }catch (Exception e){
            logger.error(e.toString());
        }
    }
    // 3. 거래 합계금액이 큰 순서로 출력
    @Test
    void getOrderByMax() {
        try {
            List<Map<String, Object>> list = apiService.getOrderByMax();
            String jsonString = new ObjectMapper().writeValueAsString(list);
            logger.info("3. 거래 합계금액이 큰 순서로 출력 completed::" + list.size());
            logger.info(jsonString);
        }catch (Exception e){
            logger.error(e.toString());
        }
    }
    // 4. 지점명을 입력하면 해당지점의 거래금액 합계를 출력
    @Test
    void getSumAmt() {
        try {
            // TODO 파라미터 json 파일 읽기
            String brName = "분당";
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put("brName", brName);
            Map<String,Object> map = apiService.getSumAmt(paramMap);
            String jsonString = new ObjectMapper().writeValueAsString(map);
            logger.info("4. 지점명을 입력하면 해당지점의 거래금액 합계를 출력 completed::" + brName);
            logger.info(jsonString);
        }catch (Exception e){
            logger.error(e.toString());
        }
    }
}
