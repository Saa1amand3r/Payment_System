package com.ips.gateway.api.processor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.googlecode.jsonrpc4j.spring.AutoJsonRpcServiceImpl;
import com.ips.gateway.api.processor.requests.PayinRequest;
import com.ips.gateway.api.processor.requests.PayoutRequest;
import com.ips.gateway.api.processor.validator.EmptyVariableException;
import com.ips.gateway.api.processor.validator.ValidationService;
import com.ips.gateway.api.processor.validator.ValidationServiceImpl;
import com.ips.gateway.api.processor.validator.WrongDataLenghtException;

@Service
@AutoJsonRpcServiceImpl
public class ExternalRequestControllerImplForPayout implements ExternalRequestControllerForPayout {
	
	private ValidationService validator = new ValidationServiceImpl();
	
	public ResponseEntity<String> create(String UUID) throws EmptyVariableException, WrongDataLenghtException {
		/* validating and parsing*/
		try {
			validator.validatePayoutRequest(UUID); // validating
		} catch(EmptyVariableException emptyVariableException) {
			return new ResponseEntity<String>("Validation error - EmptyVariableException", HttpStatus.BAD_REQUEST); // if there is any problem we return status "validation error"
		} catch(WrongDataLenghtException wrongLenghtException) {
			return new ResponseEntity<String>("Validation error - WrongLenghtException", HttpStatus.BAD_REQUEST);
		}
		PayoutRequest payout = new PayoutRequest(UUID, "create"); // parsing
		
		ResponseEntity<String> status;
		InternalRequestController reqController = new InternalRequestControllerImpl();
		status = reqController.createPayout();
		return status;
	}

	public ResponseEntity<String> update(String UUID) throws EmptyVariableException, WrongDataLenghtException {
		/* validating and parsing*/
		try {
			validator.validatePayoutRequest(UUID); // validating
		} catch(EmptyVariableException emptyVariableException) {
			return new ResponseEntity<String>("Validation error - EmptyVariableException", HttpStatus.BAD_REQUEST); // if there is any problem we return status "validation error"
		} catch(WrongDataLenghtException wrongLenghtException) {
			return new ResponseEntity<String>("VValidation error - WrongLenghtException", HttpStatus.BAD_REQUEST);
		}
		PayoutRequest payout = new PayoutRequest(UUID, "update"); // parsing
		
		ResponseEntity<String> status;
		InternalRequestController reqController = new InternalRequestControllerImpl();
		status = reqController.updatePayout();
		return status;
	}

	public ResponseEntity<String> get(String UUID) throws EmptyVariableException, WrongDataLenghtException {
		/* validating and parsing*/
		try {
			validator.validatePayoutRequest(UUID); // validating
		} catch(EmptyVariableException emptyVariableException) {
			return new ResponseEntity<String>("Validation error - EmptyVariableException", HttpStatus.BAD_REQUEST); // if there is any problem we return status "validation error"
		} catch(WrongDataLenghtException wrongLenghtException) {
			return new ResponseEntity<String>("Validation error - WrongLenghtException", HttpStatus.BAD_REQUEST);
		}
		PayoutRequest payout = new PayoutRequest(UUID, "get"); // parsing
		
		ResponseEntity<String> status;
		InternalRequestController reqController = new InternalRequestControllerImpl();
		status = reqController.getPayout();
		return status;
	}
}
