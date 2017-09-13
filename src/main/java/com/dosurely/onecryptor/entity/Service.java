package com.dosurely.onecryptor.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the service database table.
 * 
 */
@Entity
@NamedQuery(name="Service.findAll", query="SELECT s FROM Service s")
public class Service implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="service_id")
	private int serviceId;

	private String description;

	@Column(name="service_name")
	private String serviceName;

	//bi-directional many-to-one association to ProductService
	@OneToMany(mappedBy="service")
	private List<ProductService> productServices;

	public Service() {
	}

	public int getServiceId() {
		return this.serviceId;
	}

	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getServiceName() {
		return this.serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public List<ProductService> getProductServices() {
		return this.productServices;
	}

	public void setProductServices(List<ProductService> productServices) {
		this.productServices = productServices;
	}

	public ProductService addProductService(ProductService productService) {
		getProductServices().add(productService);
		productService.setService(this);

		return productService;
	}

	public ProductService removeProductService(ProductService productService) {
		getProductServices().remove(productService);
		productService.setService(null);

		return productService;
	}

}