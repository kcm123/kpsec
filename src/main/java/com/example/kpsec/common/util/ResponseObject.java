package com.example.kpsec.common.util;

import com.example.kpsec.common.status.HttpResult;
import com.example.kpsec.common.status.ResultInfo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;

public class ResponseObject {
	
	public static ResponseEntity<ResultInfo> create(HttpResult status){
		return create(status.getCode(), status.getMessage(), status.getHttpStatus(), new HashMap<String, Object>());
	}
	
	public static ResponseEntity<ResultInfo> create(String code, String message, HttpStatus httpStatus){
		return create(code, message, httpStatus, new HashMap<String, Object>());
	}
	
	public static ResponseEntity<ResultInfo> create(HttpResult status, Object data){
		return create(status.getCode(), status.getMessage(), status.getHttpStatus(), data);
	}
	
	public static ResponseEntity<ResultInfo> create(String code, String message, HttpStatus httpStatus, Object data){
		ResultInfo resultInfo = new ResultInfo(code, message, data);
		return new ResponseEntity<ResultInfo>(resultInfo, httpStatus);
	}

}
