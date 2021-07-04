package com.example.kpsec.apiService.web;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.kpsec.apiService.model.CommonResult;
import com.example.kpsec.apiService.service.ResponseService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
@Api(tags = {"API 기능"})
@Controller
@RequiredArgsConstructor
public class ApiController {
    @Autowired
    private ResponseService responseService;

    // 1. 2018년, 2019년 각 연도별 합계 금액이 가장 많은 고객을 추출하는 API 개발.(단, 취소여부가 ‘Y’ 거래는 취소된 거래임, 합계 금액은 거래금액에서 수수료를 차감한 금액임)
    @ApiOperation(value = "1. 연도별 합계 금액이 가장 많은 고객")
    @GetMapping(value = "/getMaxSumCustomer")
    public CommonResult getMaxSumCustomer(
            @ApiParam(value = "회사코드", required = true) @RequestParam String compCd,
            @ApiParam(value = "출고처코드(창고코드)", required = true) @RequestParam String outbPlcCd,
            @ApiParam(value = "출고일자", required = false) @RequestParam(required=false) String outbDt
    ) throws Exception {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("compCd", compCd);
        paramMap.put("outbPlcCd", outbPlcCd);
        paramMap.put("outbDt", outbDt);

        List<Map<String,Object>> list = new ArrayList<>();//outboundService.getDlvList(paramMap);
        String oMsg = "";//(String) paramMap.get("oMsg");

        return responseService.getSingleResult(list, oMsg);
    }

    // 2. 2018년 또는 2019년에 거래가 없는 고객을 추출하는 API 개발. (취소여부가 ‘Y’ 거래는 취소된 거래임)
    @ApiOperation(value = "2. 거래가 없는 고객(2018 or 2019)")
    @PostMapping(value = "/getNoTransaction")
    public CommonResult getNoTransaction() throws Exception {
        List<Map<String,Object>> list = new ArrayList<>();//outboundService.getDlvList(paramMap);
        Map<String, Object> map1 = new HashMap<>();
        map1.put("year", "2019");
        map1.put("name", "국민은행");
        map1.put("acctNo", "12345");
        Map<String, Object> map2 = new HashMap<>();
        map2.put("year", "2021");
        map2.put("name", "시은행");
        map2.put("acctNo", "00000");
        list.add(map1);
        list.add(map2);
        String oMsg = "OK";//(String) paramMap.get("oMsg");
        return responseService.getSingleResult(list, oMsg);
    }

    // 3. 연도별 관리점별 거래금액 합계를 구하고 합계금액이 큰 순서로 출력하는 API 개발.( 취소여부가 ‘Y’ 거래는 취소된 거래임) 
    @ApiOperation(value = "3. 거래 합계금액이 큰 순서로 출력")
    @PostMapping(value = "/getOrderByMax")
    public CommonResult getOrderByMax() throws Exception {
        List<Map<String,Object>> list = new ArrayList<>();//outboundService.getDlvList(paramMap);
        String oMsg = "";//(String) paramMap.get("oMsg");
        return responseService.getSingleResult(list, oMsg);
    }

    // 4. 분당점과 판교점을 통폐합하여 판교점으로 관리점 이관을 하였습니다. 지점명을 입력하면 해당지점의 거래금액 합계를 출력하는 API 개발( 취소여부가 ‘Y’ 거래는 취소된 거래임,)
    @ApiOperation(value = "4. 지점명을 입력하면 해당지점의 거래금액 합계를 출력")
    @PostMapping(value = "/getSumAmt")
    public CommonResult getSumAmt(
            @ApiParam(value = "회사코드", required = true) @RequestParam String compCd,
            @ApiParam(value = "출고처코드(창고코드)", required = true) @RequestParam String outbPlcCd,
            @ApiParam(value = "출고일자", required = false) @RequestParam(required=false) String outbDt
    ) throws Exception {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("compCd", compCd);
        paramMap.put("outbPlcCd", outbPlcCd);
        paramMap.put("outbDt", outbDt);

        List<Map<String,Object>> list = new ArrayList<>();//outboundService.getDlvList(paramMap);
        String oMsg = "";//(String) paramMap.get("oMsg");

        return responseService.getSingleResult(list, oMsg);
    }
}
