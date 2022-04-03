package com.ips.gateway.api.processor.validator;

public class ValidationServiceImpl implements ValidationService{

	private EmptyVariableException emptyVariableException = new EmptyVariableException("Variable is empty");
	private WrongDataLenghtException wrongLenghtException = new WrongDataLenghtException("Variable is too short");
	@Override
	public void validatePayinRequest(String UUID) throws EmptyVariableException, WrongDataLenghtException {
		if(UUID.length()!= 36) {
			 throw wrongLenghtException;
		}
		if (UUID.isBlank()) {
			throw emptyVariableException; 
		}
		
	}

	@Override
	public void validatePayoutRequest(String UUID) throws EmptyVariableException, WrongDataLenghtException {
		if(UUID.length()!= 36) {
			 throw wrongLenghtException;
		}
		if (UUID.isBlank()) {
			throw emptyVariableException; 
		}
	}

}
