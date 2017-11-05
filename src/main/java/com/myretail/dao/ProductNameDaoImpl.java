package com.myretail.dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.myretail.domain.ProductName;

@Repository
public class ProductNameDaoImpl implements ProductNameDao {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Override
	public void saveProductName(ProductName productName) {
		mongoTemplate.insert(productName);
	}

	@Override
	public void updateProductName(ProductName productName) {
		mongoTemplate.save(productName);
	}

	@Override
	public void deleteProductName(String productId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("productId").is(productId));
		mongoTemplate.remove(query, ProductName.class);
	}

	@Override
	public ProductName getProductName(String productId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("productId").is(productId));
		return mongoTemplate.findOne(query, ProductName.class);
	}

	@Override
	public ArrayList<ProductName> getAllProductNames() {
		return (ArrayList<ProductName>) mongoTemplate.findAll(ProductName.class);
	}

}
