package com.ips.gateway.api.processor.validator;

/**
 * 
 * @author Erik
 *  This interface is validating requests which we got from client.
 *
 */

public interface ValidationService {
	
	/**
	 * This method validate all payin requests
	 * 
	 * @param UUID
	 * One of request parameters is indentificator. This parameter we will validate
	 * @throws EmptyVariableException
	 * Exception is thrown if UUID is empty.
	 * @throws WrongDataLenghtException
	 * Exception is thrown if UUID is too big or too short
	 */
	public void validatePayinRequest(String UUID) throws EmptyVariableException, 
														 WrongDataLenghtException;
	
	/**
	 * This method validate all payout requests
	 * 
	 * @param UUID
	 * One of request parameters is indentificator. This parameter we will validate
	 * @throws EmptyVariableException
	 * Exception is thrown if UUID is empty.
	 * @throws WrongDataLenghtException
	 * Exception is thrown if UUID is too big or too short
	 */
	public void validatePayoutRequest(String UUID) throws EmptyVariableException,
														  WrongDataLenghtException;
}
