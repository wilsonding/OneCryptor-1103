package com.dosurely.onecryptor.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the product_service database table.
 * 
 */
@Entity
@Table(name="product_service")
@NamedQuery(name="ProductService.findAll", query="SELECT p FROM ProductService p")
public class ProductService implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="product_service_id")
	private int productServiceId;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="product_id")
	private Product product;

	//bi-directional many-to-one association to Service
	@ManyToOne
	@JoinColumn(name="service_id")
	private Service service;

	public ProductService() {
	}

	public int getProductServiceId() {
		return this.productServiceId;
	}

	public void setProductServiceId(int productServiceId) {
		this.productServiceId = productServiceId;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Service getService() {
		return this.service;
	}

	public void setService(Service service) {
		this.service = service;
	}

}