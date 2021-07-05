package com.example.kpsec.common.status;

import org.springframework.http.HttpStatus;

/**
	00	Success	200
	80	Bad Request	400
	81	Unauthorized	401
	82	Forbidden	403
	83	Resource Not Found	404
	84	HTTP Method Not Allowed	405
	85	Unsupported Media Type	415
	86	Too many Requests 	429
	87	System Error	500
 */
public enum HttpResult {
	
	/**
	 * Success
	 */
	SUCCESS("00", "Success", HttpStatus.OK),
	/**
	 * Success
	 */
	DATA_NOT_FOUND("11", "Data Not Found", HttpStatus.OK),
	/**
	 * Bad Request
	 */
	BAD_REQUEST("80","Bad Request", HttpStatus.BAD_REQUEST),
	/**
	 *  Unauthorized
	 */
	UNAUTHORIZED("81","Unauthorized", HttpStatus.UNAUTHORIZED),
	/**
	 * Forbidden
	 */
	FORBIDDEN("82","Forbidden", HttpStatus.FORBIDDEN),
	/**
	 * Resource Not Found
	 */
	NOT_FOUND("83","Resource Not Found", HttpStatus.NOT_FOUND),
	/**
	 * HTTP Method Not Allowed
	 */
	METHOD_NOT_ALLOWED("84","HTTP Method Not Allowed", HttpStatus.METHOD_NOT_ALLOWED),
	/**
	 * Unsupported Media Type
	 */
	UNSUPPORTED_MEDIA_TYPE("85","Unsupported Media Type", HttpStatus.UNSUPPORTED_MEDIA_TYPE),
	/**
	 * Too many requests
	 */
	TOO_MANY_REQUESTS("86","Too_many_requests", HttpStatus.TOO_MANY_REQUESTS),
	/**
	 * System Error
	 */
	SYS_ERROR("87","System Error", HttpStatus.INTERNAL_SERVER_ERROR);
	
	private final String code;
	private final String message;
	private final HttpStatus httpStatus;

	private HttpResult(String code, String message, HttpStatus httpStatus) {
		this.code = code;
		this.message = message;
		this.httpStatus = httpStatus;
	}
	
	public String getCode(){
		return this.code;
	}
	
	public String getMessage(){
		return this.message;
	}
	
	public HttpStatus getHttpStatus(){
		return this.httpStatus;
	}

}
