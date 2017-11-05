package com.myretail.business;

import java.util.ArrayList;

import com.myretail.domain.ProductName;
import com.myretail.model.Result;

public interface ProductNameBo {
	
	public Result saveProductName(ProductName productName);
	
	public Result updateProductName(ProductName productName);
	
	public Result deleteProductName(String productId);
	
	public ProductName getProductName(String productId);
	
	public ArrayList<ProductName> getAllProductNames();

}
