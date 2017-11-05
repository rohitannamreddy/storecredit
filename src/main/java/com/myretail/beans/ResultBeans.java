package com.myretail.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.myretail.model.Result;

@Component
public class ResultBeans {
	
	@Bean(name="successResultBean")
	public Result getSuccessResult(){
		return new Result(1,"Success");
	}
	
	@Bean(name="errorResultBean")
	public Result getErrorResult(){
		return new Result(-1,"Error");
	}
	

}
