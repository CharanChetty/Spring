package com.zensar.daos;

import java.util.List;



import com.zensar.entities.Product;

/**
 * @author CHARAN R
 * @creation date: 4th oct 2019 9:58am
 * @modification date: 10th oct 2019 4:10pm
 * @version 2.0
 * @copyright Zensar technologies ltd, all rights reserved
 *
 */

public interface ProductDao {

	List<Product> getAll();

	Product getById(int prod_id);

	void insert(Product product);

	void update(Product product);

	void delete(Product product);
	 
	
}
