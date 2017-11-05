package com.myretail.business;

import java.util.ArrayList;

import com.myretail.model.Product;
import com.myretail.model.Result;

public interface ProductBo {
	
	public Product getProduct(String productId);
	
	public ArrayList<Product> getAllProducts();
	
	public Result saveProduct(Product product);
	
	public Result updateProduct(Product product);
	
	public Result deleteProduct(String productId);

}
