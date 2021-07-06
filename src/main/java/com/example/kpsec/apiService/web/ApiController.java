package com.example.kpsec.apiService.web;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.kpsec.apiService.service.ApiService;
import com.example.kpsec.common.model.CommonResult;
import com.example.kpsec.common.service.ResponseService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

//@Api(tags = {"API 기능"})
//@Controller
//@RequiredArgsConstructor

@Api(tags = {"API 기능"})
@RequiredArgsConstructor
@RestController
public class ApiController {
    @Autowired
    private ResponseService responseService;

    @Autowired
    private ApiService apiService;

    // 1. 2018년, 2019년 각 연도별 합계 금액이 가장 많은 고객을 추출하는 API 개발.(단, 취소여부가 ‘Y’ 거래는 취소된 거래임, 합계 금액은 거래금액에서 수수료를 차감한 금액임)
    @ApiOperation(value = "1. 연도별 합계 금액이 가장 많은 고객")
    @PostMapping(value = "/getMaxSumCustomer")
    public CommonResult getMaxSumCustomer() throws Exception {
        List<Map<String,Object>> list = apiService.getMaxSumCustomer();
        String oMsg = "";
        return responseService.getSingleResult(list, oMsg);
    }

    // 2. 2018년 또는 2019년에 거래가 없는 고객을 추출하는 API 개발. (취소여부가 ‘Y’ 거래는 취소된 거래임)
    @ApiOperation(value = "2. 거래가 없는 고객(2018 or 2019)")
    @PostMapping(value = "/getNoTransaction")
    public ResponseEntity<?> getNoTransaction() throws Exception {
        List<Map<String,Object>> list = apiService.getNoTransaction();
//        String oMsg = "OK";
        return ResponseEntity.ok(responseService.getListResult(list, ""));
    }

    // 3. 연도별 관리점별 거래금액 합계를 구하고 합계금액이 큰 순서로 출력하는 API 개발.( 취소여부가 ‘Y’ 거래는 취소된 거래임) 
    @ApiOperation(value = "3. 거래 합계금액이 큰 순서로 출력")
    @PostMapping(value = "/getOrderByMax")
    public ResponseEntity<?> getOrderByMax() throws Exception {
        List<Map<String,Object>> list = apiService.getOrderByMax();
        String oMsg = "OK";
        return ResponseEntity.ok(responseService.getListResult(list, null));
    }
//
//    // 4. 분당점과 판교점을 통폐합하여 판교점으로 관리점 이관을 하였습니다. 지점명을 입력하면 해당지점의 거래금액 합계를 출력하는 API 개발( 취소여부가 ‘Y’ 거래는 취소된 거래임,)
    @ApiOperation(value = "4. 지점명을 입력하면 해당지점의 거래금액 합계를 출력")
    @PostMapping(value = "/getSumAmt")
    public CommonResult getSumAmt(@ApiParam(value = "관리점명", required = true) @RequestParam String brName) throws Exception {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("brName", brName);
        Map<String,Object> list = apiService.getSumAmt(paramMap);
        String oMsg = "";//(String) paramMap.get("oMsg");

        return responseService.getSingleResult(list, oMsg);
    }
}