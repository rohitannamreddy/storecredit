package com.myretail.model;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

@Component
public class CurrentPrice {

	private BigDecimal value;
	private Currency currency;
	
	public BigDecimal getValue() {
		return value;
	}
	public void setValue(BigDecimal value) {
		this.value = value;
	}
	public Currency getCurrency() {
		return currency;
	}
	public void setCurrency(Currency currency) {
		this.currency = currency;
	}
	
}
