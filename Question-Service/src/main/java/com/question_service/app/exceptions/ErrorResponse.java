package com.question_service.app.exceptions;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.TreeMap;

public class ErrorResponse {
	public static Map<String,Object> response(Integer status,String message){
		Map<String,Object> errorMessage = new TreeMap<String, Object>();
		errorMessage.put("status", status);
		errorMessage.put("error", message);
		errorMessage.put("timestamp", LocalDateTime.now());
		return errorMessage;
	}
}
