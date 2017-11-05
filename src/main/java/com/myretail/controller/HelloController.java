package com.myretail.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myretail.domain.Sample;

@RestController
public class HelloController {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	@RequestMapping("/hello")
	public String sayHello(){
		return "Hello. This is a sample service by Kartheek Maremalla.";
	}
	
	@RequestMapping("/sample")
	public String insertSampleDocument(){
		
		Sample samp = new Sample();
		samp.setMessage("This is a sample message from eclipse");
		samp.setMessageId(1);
		mongoTemplate.insert(samp);
		return "Sample Message Insert Successful!";
		
	}
	
	@RequestMapping("/getsampledata")
	public ArrayList<Sample> getSampleData(){
		return (ArrayList<Sample>)mongoTemplate.findAll(Sample.class);
	}
	
	
}
