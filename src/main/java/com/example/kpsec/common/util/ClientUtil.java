package com.example.kpsec.common.util;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;

public class ClientUtil {
	// 테스트_client ip 조회
	public static String getIp() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		String result = request.getHeader("X-FORWARDED-FOR");
		if (result != null && result.contains(","))
			result = result.split(",")[0].trim();
		if (result == null || result.length() == 0) result = request.getRemoteAddr();
		if (result.equals("0:0:0:0:0:0:0:1")) result = "127.0.0.1";
		return result;
	}
}
