package com.myretail.business;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myretail.dao.ProductPriceDao;
import com.myretail.domain.ProductPrice;
import com.myretail.model.Result;

@Service
public class ProductPriceBoImpl implements ProductPriceBo {

	@Autowired
	private ProductPriceDao productPriceDao;
	@Resource(name="successResultBean")
	private Result successResult;
	@Resource(name="errorResultBean")
	private Result errorResult;
	
	@Override
	public Result saveProductPrice(ProductPrice productPrice) {
		try{
			productPriceDao.saveProductPrice(productPrice);
			return successResult;
		}catch(Exception e){
			e.printStackTrace();
			return errorResult;
		}
	
	}

	@Override
	public Result updateProductPrice(ProductPrice productPrice) {
		try{	
			if(getProductPrice(productPrice.getProductId())==null){
				return errorResult;
			}
			productPriceDao.updateProductPrice(productPrice);
			return successResult;
		}catch(Exception e){
			e.printStackTrace();
			return errorResult;
		}
	}

	@Override
	public Result deleteProductPrice(String productId) {
		try{
			productPriceDao.deleteProductPrice(productId);
			return successResult;
		}catch(Exception e){
			e.printStackTrace();
			return errorResult;
		}
	}

	@Override
	public ProductPrice getProductPrice(String productId) {
		try{
			return productPriceDao.getProductPrice(productId);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public ArrayList<ProductPrice> getAllProductPrices() {
		try{
			return productPriceDao.getAllProductPrices();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

}
