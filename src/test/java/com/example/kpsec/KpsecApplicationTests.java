package com.example.kpsec;

import com.example.kpsec.apiService.service.ApiService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.parser.JSONParser;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.io.FileReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
            // 파라미터 json 파일 읽기
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader(getClass().getClassLoader().getResource("test.json").getPath()));
            Map<String, Object> paramMap = new ObjectMapper().readValue(obj.toString(), Map.class);
            // 결과처리
            Map<String,Object> resultMap = apiService.getSumAmt(paramMap);
            resultMap = checkExistYn(resultMap);
            String jsonString = new ObjectMapper().writeValueAsString(resultMap);
            logger.info("4. 지점명을 입력하면 해당지점의 거래금액 합계를 출력 completed::" + obj);
            logger.info(jsonString);
        }catch (Exception e){
            logger.error(e.toString());
        }
    }
    // 데이터 없을 경우 오류코드 매핑
    Map<String, Object> checkExistYn(Map<String, Object> paramMap){
        if(paramMap == null){
            paramMap = new HashMap<>();
            paramMap.put("code", "404");
            paramMap.put("message", "br code not found error");
        }
        return paramMap;
    }
}
