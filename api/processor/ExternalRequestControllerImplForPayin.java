package com.ips.gateway.api.processor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.googlecode.jsonrpc4j.spring.AutoJsonRpcServiceImpl;
import com.ips.gateway.api.processor.requests.PayinRequest;
import com.ips.gateway.api.processor.validator.EmptyVariableException;
import com.ips.gateway.api.processor.validator.ValidationService;
import com.ips.gateway.api.processor.validator.ValidationServiceImpl;
import com.ips.gateway.api.processor.validator.WrongDataLenghtException;

@Service
@AutoJsonRpcServiceImpl
public class ExternalRequestControllerImplForPayin implements ExternalRequestControllerForPayin {
	
	private ValidationService validator = new ValidationServiceImpl();
	
	@Override
	public ResponseEntity<String> create(String UUID) throws EmptyVariableException, WrongDataLenghtException{
		/* validating and parsing*/
		try {
		validator.validatePayinRequest(UUID); // validating
		} catch(EmptyVariableException emptyVariableException) {
			return new ResponseEntity<String>("Validation error - EmptyVariableException", HttpStatus.BAD_REQUEST); // if there is any problem we return status "validation error"
		} catch(WrongDataLenghtException wrongLenghtException) {
			return new ResponseEntity<String>("Validation error - WrongLenghtException", HttpStatus.BAD_REQUEST);
		}
		PayinRequest payin = new PayinRequest(UUID, "create"); // parsing
		
		ResponseEntity<String> status; // we need variable which will contain status of operation
		
		/* we initialize internal controller that will be redirecting our request to
		  processor */
		InternalRequestController reqController = new InternalRequestControllerImpl(); 
		
		/* we call method in our internal controller
		  which redirects it to processor where will be created payin operation */
		status = reqController.createPayin(); // after all operations in processor we get status
		
		return status; // we return status to payment page
	}

	public ResponseEntity<String> update(String UUID) throws EmptyVariableException, WrongDataLenghtException {
		/* validating and parsing*/
		try {
			validator.validatePayinRequest(UUID); // validating
			} catch(EmptyVariableException emptyVariableException) {
				return new ResponseEntity<String>("Validation error - EmptyVariableException", HttpStatus.BAD_REQUEST); // if there is any problem we return status "validation error"
			} catch(WrongDataLenghtException wrongLenghtException) {
				return new ResponseEntity<String>("Validation error - WrongLenghtException", HttpStatus.BAD_REQUEST);
			}
			PayinRequest payin = new PayinRequest(UUID, "update"); // parsing
		
		ResponseEntity<String> status;
		InternalRequestController reqController = new InternalRequestControllerImpl();
		status = reqController.updatePayin();
		return status;
	}

	public ResponseEntity<String> get(String UUID) throws EmptyVariableException, WrongDataLenghtException {
		/* validating and parsing*/
		try {
			validator.validatePayinRequest(UUID); // validating
			} catch(EmptyVariableException emptyVariableException) {
				return new ResponseEntity<String>("Validation error - EmptyVariableException", HttpStatus.BAD_REQUEST); // if there is any problem we return status "validation error"
			} catch(WrongDataLenghtException wrongLenghtException) {
				return new ResponseEntity<String>("Validation error - WrongLenghtException", HttpStatus.BAD_REQUEST);
			}
			PayinRequest payin = new PayinRequest(UUID, "get"); // parsing
		
		ResponseEntity<String> status;
		InternalRequestController reqController = new InternalRequestControllerImpl();
		status = reqController.getPayin();
		return status;
	}
	
}
