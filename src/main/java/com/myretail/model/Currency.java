package com.myretail.model;

public enum Currency {

	USD("USD"), GBP("GBP"), INR("INR"), AUD("AUD"), CAD("CAD");
	
	private String value;
	
	private Currency(String val){
		value = val;
	}
	
	public String getCurrency(){
		return value;
	}
	

}
