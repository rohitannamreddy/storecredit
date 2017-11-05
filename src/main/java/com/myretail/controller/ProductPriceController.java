package com.myretail.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.myretail.business.ProductPriceBo;
import com.myretail.domain.ProductPrice;
import com.myretail.model.Result;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/productPrice")
@Api(value="ProductPrice")
public class ProductPriceController {
	
	@Autowired
	public ProductPriceBo productPriceBo;
	
	@RequestMapping(method=RequestMethod.POST)
	public Result saveProductPrice(@RequestBody ProductPrice productPrice){
		return productPriceBo.saveProductPrice(productPrice);
	}
	
	@RequestMapping(method=RequestMethod.PUT)
	public Result updateProductPrice(@RequestBody ProductPrice productPrice){
		return productPriceBo.updateProductPrice(productPrice);
	}
	
	@RequestMapping(value="/{productId}", method=RequestMethod.DELETE)
	public Result deleteProductPrice(@PathVariable String productId){
		return productPriceBo.deleteProductPrice(productId);
	}
	
	@RequestMapping(value="/{productId}", method=RequestMethod.GET)
	public ProductPrice getProductPrice(@PathVariable String productId){
		return productPriceBo.getProductPrice(productId);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ArrayList<ProductPrice> getAllProductPrices(){
		return productPriceBo.getAllProductPrices();
	}

}
