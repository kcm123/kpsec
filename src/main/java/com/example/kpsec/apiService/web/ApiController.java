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
@Api(tags = {"1. 연도별 합계 금액이 가장 많은 고객을 추출"})
@Controller
@RequiredArgsConstructor
public class ApiController {
    @Autowired
    private ResponseService responseService;

    @ApiOperation(value = "1. 출고거래처 검색")
    @GetMapping(value = "/cust")
    public CommonResult getDlvList(
            @ApiParam(value = "회사코드", required = true) @RequestParam String compCd,
            @ApiParam(value = "출고처코드(창고코드)", required = true) @RequestParam String outbPlcCd,
            @ApiParam(value = "출고일자", required = false) @RequestParam(required=false) String outbDt
//            @RequestParam Map<String, Object> paramMap
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
