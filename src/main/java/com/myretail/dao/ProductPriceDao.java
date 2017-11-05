package com.myretail.dao;

import java.util.ArrayList;

import com.myretail.domain.ProductPrice;

public interface ProductPriceDao {
	
	public void saveProductPrice(ProductPrice productPrice);
	
	public void updateProductPrice(ProductPrice productPrice);
	
	public void deleteProductPrice(String productId);
	
	public ProductPrice getProductPrice(String productId);
	
	public ArrayList<ProductPrice> getAllProductPrices();

}
