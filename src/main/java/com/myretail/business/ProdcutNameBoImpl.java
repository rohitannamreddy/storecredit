package com.myretail.business;
//making a change

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myretail.dao.ProductNameDao;
import com.myretail.domain.ProductName;
import com.myretail.model.Result;

@Service
public class ProdcutNameBoImpl implements ProductNameBo {

	@Autowired
	private ProductNameDao productNameDao;
	@Resource(name="successResultBean")
	private Result successResult;
	@Resource(name="errorResultBean")
	private Result errorResult;
	
	@Override
	public Result saveProductName(ProductName productName) {
		try{
			productNameDao.saveProductName(productName);
			return successResult;
		}catch(Exception e){
			e.printStackTrace();
			return errorResult;
		}
	}

	@Override
	public Result updateProductName(ProductName productName) {
		try{	
			if(getProductName(productName.getProductId())==null){
				return errorResult;
			}
			productNameDao.updateProductName(productName);
			return successResult;
		}catch(Exception e){
			e.printStackTrace();
			return errorResult;
		}
	}

	@Override
	public Result deleteProductName(String productId) {
		try{
			productNameDao.deleteProductName(productId);
			return successResult;
		}catch(Exception e){
			e.printStackTrace();
			return errorResult;
		}
		
	}

	@Override
	public ProductName getProductName(String productId) {
		try{
			return productNameDao.getProductName(productId);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public ArrayList<ProductName> getAllProductNames() {
		try{
			return productNameDao.getAllProductNames();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	

}
