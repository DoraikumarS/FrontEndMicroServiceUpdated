package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CaptureRawRequestController {

	@Autowired
	RestTemplate restTemplate;
	
	@PostMapping(path="/processRequestV2", consumes = "application/json", produces = "application/json")
	public ResponseEntity<ResponseMSOne> processRequestV2(@RequestBody RequestMSOne requestMSOne) {
		ResponseMSOne responseMSOne = new ResponseMSOne();
		
		responseMSOne.setProductName(requestMSOne.getProductName());
		System.out.println("Step_One , request to FrontEndMicroservice is "+ requestMSOne.toString());
		
		ResponseEntity<ResponseMSOne> responseEntity ;
		if(null != requestMSOne.getProductName() && !"".equals(requestMSOne.getProductName())) {
			
			RequestMSTwo requestMSTwo = new RequestMSTwo();
			requestMSTwo.setItemName(requestMSOne.getProductName());
			requestMSTwo.setTokenToValidate("sdk");
			ResponseEntity<ResponseMSTwo> response3 =restTemplate.postForEntity(
					"http://localhost:8081/validateRequest",
					requestMSTwo, ResponseMSTwo.class);
			
			responseMSOne.setProductDescription(response3.getBody().getItemDescription());
			responseEntity = new ResponseEntity<ResponseMSOne>(responseMSOne, HttpStatus.ACCEPTED);
		
		}else {
			responseEntity = new ResponseEntity<ResponseMSOne>(responseMSOne, HttpStatus.BAD_REQUEST);
		}
		
		return responseEntity;
	}
}
