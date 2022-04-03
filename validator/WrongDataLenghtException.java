package com.ips.gateway.api.processor.validator;

public class WrongDataLenghtException extends Exception {
	public WrongDataLenghtException(String message) {
		super("Variable is too long or too short");
	}
}
