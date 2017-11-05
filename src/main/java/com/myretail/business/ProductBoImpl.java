package com.myretail.business;

import java.math.BigDecimal;
import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.myretail.domain.ProductName;
import com.myretail.domain.ProductPrice;
import com.myretail.model.Currency;
import com.myretail.model.CurrentPrice;
import com.myretail.model.Product;
import com.myretail.model.Result;

@Service
public class ProductBoImpl implements ProductBo {

	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private ProductName productName;
	@Autowired
	private ProductPrice productPrice;

	@Resource(name="successResultBean")
	private Result successResult;
	@Resource(name="errorResultBean")
	private Result errorResult;

	@Value("${rs.ProductName}")
	private String productNameUrl;
	@Value("${rs.ProductPrice}")
	private String productPriceUrl;

	@Override
	public Product getProduct(String productId) {
		try{
			ProductName productName = restTemplate.getForObject(productNameUrl+productId, ProductName.class);
			ProductPrice productPrice = restTemplate.getForObject(productPriceUrl+productId, ProductPrice.class);
			return getProductPOJO(productId,productName,productPrice);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public ArrayList<Product> getAllProducts() {
		try{
			ArrayList<Product> response = new ArrayList<Product>();
			ResponseEntity<ProductName[]> responseEntity = restTemplate.getForEntity(productNameUrl, ProductName[].class);
			ProductName[] productNames = responseEntity.getBody();
			for(ProductName productName : productNames){
				ProductPrice productPrice = restTemplate.getForObject(productPriceUrl+productName.getProductId(), ProductPrice.class);
				response.add(getProductPOJO(productName,productPrice));
			}
			return response;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Result saveProduct(Product product) {

		if(product.getProductId()==null || product.getProductId().isEmpty()){
			return errorResult;
		}

		try{
			productName.setProductId(product.getProductId());
			productName.setProductName(product.getProductName());

			productPrice.setProductId(product.getProductId());
			productPrice.setCurrency(product.getCurrentPrice().getCurrency());
			productPrice.setProductPrice(product.getCurrentPrice().getValue());

			Result res = restTemplate.postForObject(productNameUrl, productName, Result.class);
			if(res.getCode().equals(-1)) throw new Exception();
			res = restTemplate.postForObject(productPriceUrl, productPrice, Result.class);
			if(res.getCode().equals(-1)) throw new Exception();
			return successResult;
		}catch(Exception e){
			e.printStackTrace();
			return errorResult;
		}

	}

	@Override
	public Result updateProduct(Product product) {

		if(product.getProductId()==null || product.getProductId().isEmpty()){
			return errorResult;
		}

		try{
			productName.setProductId(product.getProductId());
			productName.setProductName(product.getProductName());

			productPrice.setProductId(product.getProductId());
			productPrice.setCurrency(product.getCurrentPrice().getCurrency());
			productPrice.setProductPrice(product.getCurrentPrice().getValue());

			restTemplate.put(productNameUrl, productName);
			restTemplate.put(productPriceUrl, productPrice);
			return successResult;
		}catch(Exception e){
			e.printStackTrace();
			return errorResult;
		}
	}

	public Result deleteProduct(String productId){
		try{
		restTemplate.delete(productNameUrl+productId);
		restTemplate.delete(productPriceUrl+productId);
		return successResult;
		}catch(Exception e){
			e.printStackTrace();
			return errorResult;
		}
	}

	private Product getProductPOJO(ProductName productName, ProductPrice productPrice){
		return getProductPOJO(productName.getProductId(),productName,productPrice);
	}

	private Product getProductPOJO(String productId, ProductName productName, ProductPrice productPrice){

		Product product = new Product();
		CurrentPrice currentPrice = new CurrentPrice();

		if(productName!=null){
			product.setProductName(productName.getProductName());
		}else{
			product.setProductName("Not Available!");
		}

		if(productPrice!=null){
			currentPrice.setCurrency(productPrice.getCurrency());
			currentPrice.setValue(productPrice.getProductPrice());
		}else{
			currentPrice.setCurrency(Currency.USD);
			currentPrice.setValue(new BigDecimal(-1));
		}
		product.setCurrentPrice(currentPrice);
		product.setProductId(productId);

		return product;
	}



}
