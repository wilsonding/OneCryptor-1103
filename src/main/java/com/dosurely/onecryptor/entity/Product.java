package com.dosurely.onecryptor.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the product database table.
 * 
 */
@Entity
@NamedQuery(name="Product.findAll", query="SELECT p FROM Product p")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="product_id")
	private int productId;

	private BigDecimal price;

	@Column(name="product_name")
	private String productName;

	//bi-directional many-to-one association to ProductService
	@OneToMany(mappedBy="product")
	private List<ProductService> productServices;

	//bi-directional many-to-one association to User
	@OneToMany(mappedBy="product")
	private List<User> users;

	public Product() {
	}

	public int getProductId() {
		return this.productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public List<ProductService> getProductServices() {
		return this.productServices;
	}

	public void setProductServices(List<ProductService> productServices) {
		this.productServices = productServices;
	}

	public ProductService addProductService(ProductService productService) {
		getProductServices().add(productService);
		productService.setProduct(this);

		return productService;
	}

	public ProductService removeProductService(ProductService productService) {
		getProductServices().remove(productService);
		productService.setProduct(null);

		return productService;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User addUser(User user) {
		getUsers().add(user);
		user.setProduct(this);

		return user;
	}

	public User removeUser(User user) {
		getUsers().remove(user);
		user.setProduct(null);

		return user;
	}

}