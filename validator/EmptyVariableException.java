package com.ips.gateway.api.processor.validator;

public class EmptyVariableException extends Exception {
	public EmptyVariableException(String message) {
		super("Variable is empty");
	}
}
