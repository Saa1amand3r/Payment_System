package com.ips.processor.api;

//import java.sql.Timestamp;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestControllerImpl implements RequestController {
	@GetMapping("/payment/payin/create")
	public String PayinCreate(/*@RequestParam(value = "OrderId") UUID orderId,
							   @RequestParam(value = "datetime") int datetime,
							   @RequestParam(value = "MerchantId") UUID merchantId,
							   @RequestParam(value = "SiteId") UUID siteId*/) 
							   // Parameters might be changed in future
	{
		/*
		 * TODO realization
		 */
		return "succesfully"; // TODO more sensible status
	}
	
	@GetMapping("/payment/payout/create")
	public String PayoutCreate(@RequestParam(value = "OrderId") UUID orderId,
			   @RequestParam(value = "datetime") int datetime,
			   @RequestParam(value = "MerchantId") UUID merchantId,
			   @RequestParam(value = "SiteId") UUID siteId) {
			   // Parameters might be changed in future
		/*
		 * TODO realization
		 */
		return "succesfully"; //TODO change this with more sensible return.
	}
	
	@GetMapping("/payment/payin/update")
	public String PayinUpdate() {
		/*
		 * TODO realization
		 */
		return "succesfully"; //TODO change this with more sensible return.
	}
	
	@GetMapping("/payment/payout/update")
	public String PayoutUpdate() {
		/*
		 * TODO realization
		 */
		return "succesfully"; //TODO change this with more sensible return.
	}
	
	@GetMapping("/payment/payin/get")
	public String PayinGet() {
		/*
		 * TODO realization
		 */
		return "succesfully"; //TODO change this with more sensible return.
	}
	
	@GetMapping("/payment/payout/get")
	public String PayoutGet() {
		/*
		 * TODO realization
		 */
		return "succesfully"; //TODO change this with more sensible return.
	}
} 
