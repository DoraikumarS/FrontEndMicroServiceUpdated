package com.example.demo;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class RequestMSOne implements Validator{

	private String productName;

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	@Override
	public String toString() {
		return "Request [productName=" + productName + "]";
	}

	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}

	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		
		
		
	}
	
	
}
