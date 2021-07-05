package com.example.kpsec.common.web;

import com.example.kpsec.common.model.CommonResult;
import com.example.kpsec.common.service.ResponseService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RequiredArgsConstructor
@RestControllerAdvice
public class ExceptionController {
	
	private static final Logger logger = LoggerFactory.getLogger(ExceptionController.class);

	private final ResponseService responseService;

	@ExceptionHandler(value = Exception.class)
	protected CommonResult handleException(Exception e){
		logger.error("Exception :: ", e);
		return responseService.getFailResult(ResponseService.CommonResponse.SYS_ERROR);
	}

}
