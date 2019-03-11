package com.capgemini.beans;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;


@Entity
@Table(name = "product")
public class Products {

	@Pattern(regexp = "[a-zA-Z]{1}[0-9]{1,2}", message = "ID is not valid, id should start from a alphabate and follwed by 1 or 2 digits")
	@Id
	private String id;
	
	@NotNull(message = "name can't be null")
	@Size(min = 5, max = 20, message = "Name is not valid, name length must be  between 5 to 20")
	private String name;
	
	@NotNull(message = "model can not be null")
	@Size(min = 5,  max = 10, message = "model is not valid, name length must be  between 5 to 10")
	private String model;
	
	@NotNull(message = "price can not be null")
	@Positive(message = "price should be positive")
	private int price;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Products [id=" + id + ", name=" + name + ", model=" + model + ", price=" + price + "]";
	}
	
	
	
	
}
