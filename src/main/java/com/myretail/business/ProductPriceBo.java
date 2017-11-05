package com.myretail.business;

import java.util.ArrayList;

import com.myretail.domain.ProductPrice;
import com.myretail.model.Result;

public interface ProductPriceBo {

	public Result saveProductPrice(ProductPrice productPrice);
	
	public Result updateProductPrice(ProductPrice productPrice);
	
	public Result deleteProductPrice(String productId);
	
	public ProductPrice getProductPrice(String productId);
	
	public ArrayList<ProductPrice> getAllProductPrices();
	
}
