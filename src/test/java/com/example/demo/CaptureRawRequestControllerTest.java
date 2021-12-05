package com.example.demo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CaptureRawRequestControllerTest {

	@Autowired
	private CaptureRawRequestController captureRawRequestController;
	
	@Test
	public void test() {
		Assert.assertNotNull("");
		RestTemplate restTemplate = Mockito.mock(RestTemplate.class);
		captureRawRequestController.restTemplate=restTemplate;
		RequestMSOne requestMSOne = new RequestMSOne();
		requestMSOne.setProductName("test_product");
		
		ResponseMSTwo responseMSTwo=new ResponseMSTwo();
		responseMSTwo.setRequestMSTwo(null);
		responseMSTwo.setItemDescription("Mocked Descriptom");
		
		
		ResponseEntity<ResponseMSTwo> responseEntityMock = new ResponseEntity<ResponseMSTwo>(responseMSTwo, HttpStatus.ACCEPTED);
		
		Mockito.when(restTemplate.postForEntity(Mockito.anyString(), Mockito.any(), Mockito.eq(ResponseMSTwo.class))).
		thenReturn(responseEntityMock);
		
		ResponseEntity<ResponseMSOne> responseEntity = captureRawRequestController.processRequestV2(requestMSOne);
		
		/*System.out.println("Response Status >>" + responseEntity.getStatusCode().toString());
		System.out.println("Response Status >>" + responseEntity.getBody().getProductDescription());
		*/
		Assert.assertEquals("Mocked Prod Description", responseEntity.getBody().getProductDescription());
		
		
	}
}
