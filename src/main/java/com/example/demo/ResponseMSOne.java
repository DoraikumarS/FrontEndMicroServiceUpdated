package com.example.demo;

public class ResponseMSOne {
	private String productName;
	private String productDescription;
	
	

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	@Override
	public String toString() {
		return "ResponseMSOne [productName=" + productName + ", productDescription=" + productDescription + "]";
	}
	
	
}
