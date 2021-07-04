package com.example.kpsec.apiService.service;

import com.example.kpsec.apiService.model.CommonResult;
import com.example.kpsec.apiService.model.SingleResult;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class ResponseService {

    // enum으로 api 요청 결과에 대한 code, message를 정의.
    public enum CommonResponse {
        /**
         * Success
         */
        SUCCESS("00", "OK", HttpStatus.OK),
        /**
         * SuccessS
         */
        DATA_NOT_FOUND("11", "Data Not Found", HttpStatus.OK),
        /**
         * Bad Request
         */
        BAD_REQUEST("80", "Bad Request", HttpStatus.BAD_REQUEST),
        /**
         * Unauthorized
         */
        UNAUTHORIZED("81", "Unauthorized", HttpStatus.UNAUTHORIZED),
        /**
         * Forbidden
         */
        FORBIDDEN("82", "Forbidden", HttpStatus.FORBIDDEN),
        /**
         * Resource Not Found
         */
        NOT_FOUND("83", "Resource Not Found", HttpStatus.NOT_FOUND),
        /**
         * HTTP Method Not Allowed
         */
        METHOD_NOT_ALLOWED("84", "HTTP Method Not Allowed", HttpStatus.METHOD_NOT_ALLOWED),
        /**
         * Unsupported Media Type
         */
        UNSUPPORTED_MEDIA_TYPE("85", "Unsupported Media Type", HttpStatus.UNSUPPORTED_MEDIA_TYPE),
        /**
         * Too many requests
         */
        TOO_MANY_REQUESTS("86", "Too_many_requests", HttpStatus.TOO_MANY_REQUESTS),
        /**
         * System Error
         */
        SYS_ERROR("99", "System Error", HttpStatus.INTERNAL_SERVER_ERROR),

        /**
         * Jwt Expired
         */
        EXPIRED_ERROR("88", "Jwt Token Expired", HttpStatus.FORBIDDEN),
        /**
         * Jwt Expired
         */
        JWT_FORMED_ERROR("89", "JWT Token was not correctly", HttpStatus.FORBIDDEN);


        private String code;
        private String message;
        private HttpStatus httpStatus;

        CommonResponse(String code, String message, HttpStatus httpStatus) {
            this.code = code;
            this.message = message;
            this.httpStatus = httpStatus;
        }

        public String getCode() {
            return code;
        }

        public String getmessage() {
            return message;
        }

        public HttpStatus getHttpStatus() {
            return httpStatus;
        }
    }

    // 단일건 결과를 처리하는 메소드
    public <T> SingleResult<T> getSingleResult(T data, String message) {
        SingleResult<T> result = new SingleResult<>();
        //result.setData(data);
        setSuccessResult(result, message);
        return result;
    }

    // 다중건 결과를 처리하는 메소드
//    public <T> ListResult<T> getListResult(List<T> list, String message) {
//        ListResult<T> result = new ListResult<>();
//        result.setList(list);
//        setSuccessResult(result, message);
//        return result;
//    }
//
//    // 성공 결과만 처리하는 메소드
//    public CommonResult getSuccessResult(String message) {
//        CommonResult result = new CommonResult();
//        setSuccessResult(result, message);
//        return result;
//    }
//
//    // 실패 결과만 처리하는 메소드
//    public CommonResult getFailResult(CommonResponse commonResponse) {
//        CommonResult result = new CommonResult();
//        result.setCode(commonResponse.getCode());
//        result.setMessage(commonResponse.getmessage());
//        return result;
//    }
//
//    // Data not Found
//    public CommonResult getFailResult(String message) {
//        CommonResult result = new CommonResult();
//        result.setCode("11");
//        result.setMessage(message);
//        return result;
//    }
//
//    // 결과 모델에 api 요청 성공 데이터를 세팅해주는 메소드
//    private void setSuccessResult(CommonResult result) {
//        result.setCode(CommonResponse.SUCCESS.getCode());
//        result.setMessage(CommonResponse.SUCCESS.getmessage());
//    }
//
//    // SP return message + data
    private void setSuccessResult(CommonResult result, String message) {
        //result.setCode(CommonResponse.SUCCESS.getCode());
        if (("").equals(message) || message == null) {
            result.setMessage(CommonResponse.SUCCESS.getmessage());
        } else {
            result.setMessage(message);
        }
    }
}
