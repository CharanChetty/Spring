package com.zensar.daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 * @author CHARAN R
 * @creation date: 4th oct 2019 10:23am
 * @modification date: 4th oct 2019 10:23am
 * @version 1.0
 * @copyright Zensar technologies ltd, all rights reserved
 *
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.zensar.entities.Product;

@Repository

public class ProductDaoImpl implements ProductDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Product> getAll() {
		// TODO Auto-generated method stub
		String sql = "select * from product";
		return jdbcTemplate.query(sql, new ResultSetExtractor<List<Product>>() {

			@Override
			public List<Product> extractData(ResultSet rs) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				ArrayList products = new ArrayList();
				while (rs.next()) {
					Product product = new Product();
					product.setProductId(rs.getInt(1));
					product.setName(rs.getString(2));
					product.setBrand(rs.getString(3));
					product.setPrice(rs.getFloat(4));
					products.add(product);
				}
				return products;
			}
		});
	}

	@Override
	public Product getById(int productId) {
		// TODO Auto-generated method stub
		String sql = "select * from product where id=?";
		return jdbcTemplate.query(sql, new Object[] { productId }, new ResultSetExtractor<Product>() {

			@Override
			public Product extractData(ResultSet rs) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				if (rs.next()) {
					Product product = new Product();
					product.setProductId(rs.getInt(1));
					product.setName(rs.getString(2));
					product.setBrand(rs.getString(3));
					product.setPrice(rs.getFloat(4));
					return product;

				} else {
					return null;
				}

			}
		});

	}

	@Override
	public void insert(Product product) {
		// TODO Auto-generated method stub
		String sql = "insert into product values(?,?,?,?)";
		jdbcTemplate.update(sql, product.getProductId(), product.getName(), product.getBrand(), product.getPrice());
		System.out.println("new product is inserted");
	}

	@Override
	public void update(Product product) {
		// TODO Auto-generated method stub
		String sql = "update product set name=?,brand=?,price=?";
		jdbcTemplate.update(sql,product.getName(), product.getBrand(), product.getPrice());
		System.out.println("new product is updated");

	}

	@Override
	public void delete(Product product) {
		// TODO Auto-generated method stub
		String sql="delete from product where id=?";
		jdbcTemplate.update(sql, product.getProductId());
		System.out.println(" product is deleted");
	}

}
