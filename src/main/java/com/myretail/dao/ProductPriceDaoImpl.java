package com.myretail.dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.myretail.domain.ProductPrice;

@Repository
public class ProductPriceDaoImpl implements ProductPriceDao {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Override
	public void saveProductPrice(ProductPrice productPrice) {
		mongoTemplate.insert(productPrice);
	}

	@Override
	public void updateProductPrice(ProductPrice productPrice) {
		mongoTemplate.save(productPrice);
	}

	@Override
	public void deleteProductPrice(String productId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("productId").is(productId));
		mongoTemplate.remove(query, ProductPrice.class);
	}

	@Override
	public ProductPrice getProductPrice(String productId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("productId").is(productId));
		return mongoTemplate.findOne(query, ProductPrice.class);
	}

	@Override
	public ArrayList<ProductPrice> getAllProductPrices() {
		return (ArrayList<ProductPrice>) mongoTemplate.findAll(ProductPrice.class);
	}

}
