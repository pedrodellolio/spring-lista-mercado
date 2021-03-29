package com.github.pedrodellolio.ListaMercado.dto;

import java.text.ParseException;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import com.github.pedrodellolio.ListaMercado.model.Product;

public class NewProduct {
	
	@Size(min=1, max=80)
	private String productName;
	@Size(min=0, max=80)
	private String productDescription;
	@Min(value=1)
	private Integer productQuantity;
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public Integer getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(Integer productQuantity) {
		this.productQuantity = productQuantity;
	}
	
	//Cria um objeto Product a partir de uma requisição do tipo NewProduct
	public Product toProduct() throws ParseException {
		Product product = new Product();
		product.setProductQuantity(productQuantity);
		product.setProductDescription(productDescription);
		product.setProductName(productName);

		return product;
		
	}
}
