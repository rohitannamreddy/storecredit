package com.myretail.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.myretail.business.ProductNameBo;
import com.myretail.domain.ProductName;
import com.myretail.model.Result;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/productName")
@Api(value="ProductName")
public class ProductNameController {
	
	@Autowired
	private ProductNameBo productNameBo;

	@RequestMapping(method=RequestMethod.POST)
	public Result saveProductName(@RequestBody ProductName productName){
		return productNameBo.saveProductName(productName);
	}
	
	@RequestMapping(method=RequestMethod.PUT)
	public Result updateProductName(@RequestBody ProductName productName){
		return productNameBo.updateProductName(productName);
	}
	
	@RequestMapping(value="/{productId}", method=RequestMethod.DELETE)
	public Result deleteProductName(@PathVariable String productId){
		return productNameBo.deleteProductName(productId);
	}
	
	@RequestMapping(value="/{productId}", method=RequestMethod.GET)
	public ProductName getProductName(@PathVariable String productId){
		return productNameBo.getProductName(productId);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ArrayList<ProductName> getAllProductNames(){
		return productNameBo.getAllProductNames();
	}
	
}
