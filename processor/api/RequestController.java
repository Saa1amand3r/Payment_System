package com.ips.processor.api;

import java.util.UUID;

import org.springframework.web.bind.annotation.RequestParam;

/**
 * 
 * @author Erik
 * This interface contains methods which will receive (and after that parse, validate and process) requests from gateway and other microservices.
 * It is just a mapping interface. It just work with requests.
 *
 */

public interface RequestController {
	/**
	 * TODO change parameters if necessary 
	 * This method is parse, validate and route request to service which can create payin operation and work with it.
	 * @param orderId
	 * @param datetime
	 * @param merchantId
	 * @param siteId
	 * @return String with operation status (OK, Error, etc.)
	 */
	public String PayinCreate(/*@RequestParam(value = "OrderId") UUID orderId,
			   @RequestParam(value = "datetime") int datetime,
			   @RequestParam(value = "MerchantId") UUID merchantId,
			   @RequestParam(value = "SiteId") UUID siteId*/);
	
	/**
	 * TODO change parameters if necessary 
	 * This method is parse, validate and route request to service which can create payout operation and work with it.
	 * @param orderId
	 * @param datetime
	 * @param merchantId
	 * @param siteId
	 * @return String with operation status (OK, Error, etc.)
	 */
	public String PayoutCreate(@RequestParam(value = "OrderId") UUID orderId,
			   @RequestParam(value = "datetime") int datetime,
			   @RequestParam(value = "MerchantId") UUID merchantId,
			   @RequestParam(value = "SiteId") UUID siteId);
	/**
	 * TODO add parameters if necessary 
	 * This method is parse, validate and route request to service which can update payin operation and work with it.
	 * @return String with operation status (OK, Error, etc.)
	 */
	public String PayinUpdate();
	
	/**
	 * TODO add parameters if necessary 
	 * This method is parse, validate and route request to service which can get information about payin operation.
	 * @return String with operation status (OK, Error, etc.)
	 */
	public String PayinGet();
	
	/**
	 * TODO add parameters if necessary 
	 * This method is parse, validate and route request to service which can get information about payout operation
	 * @return String with operation status (OK, Error, etc.)
	 */
	public String PayoutGet();
	
	/**
	 * TODO add parameters if necessary 
	 * This method is parse, validate and route request to service which can update payout operation and work with it.
	 * @return String with operation status (OK, Error, etc.)
	 */
	public String PayoutUpdate();
}
