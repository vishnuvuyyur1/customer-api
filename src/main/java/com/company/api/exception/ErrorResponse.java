package com.company.api.exception;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ErrorResponse {
	LocalDateTime timeStamp;
	int statusCode;
	String message;
}
