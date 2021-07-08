package com.example.kpsec.common.web;

import com.example.kpsec.common.util.ClientUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommonController {

	@Value("${env.title}")
	private String envTitle;
	// 루트경로
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String getApplicationName() {
		return "RUNNING [" + envTitle + "] SERVICE";
	}
	// 테스트_client ip
	@RequestMapping(value="/info/ip", method = RequestMethod.GET)
	public String getIp() throws Exception {
    	return "CLIENT_IP: " + ClientUtil.getIp();
	}

}
