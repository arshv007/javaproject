package com.store.model;

import java.util.Date;

public class Product {
	
	private int productId;
	private String productName;
	private int quantity;
	private double price;
	private Date dateOfManufacture;
	private Date dateOfExpiry;
	private String location;
	private String productCategory;
	private String productSubCategory;
	
	
	
	public Product(String productName, int quantity, double price, Date dateOfManufacture, Date dateOfExpiry,
			String location, String productCategory, String productSubCategory) {
		super();
		this.productName = productName;
		this.quantity = quantity;
		this.price = price;
		this.dateOfManufacture = dateOfManufacture;
		this.dateOfExpiry = dateOfExpiry;
		this.location = location;
		this.productCategory = productCategory;
		this.productSubCategory = productSubCategory;
	}
	public Product(int productId, String productName, int quantity, double price, Date dateOfManufacture,
			Date dateOfExpiry, String location, String productCategory, String productSubCategory) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.quantity = quantity;
		this.price = price;
		this.dateOfManufacture = dateOfManufacture;
		this.dateOfExpiry = dateOfExpiry;
		this.location = location;
		this.productCategory = productCategory;
		this.productSubCategory = productSubCategory;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Date getDateOfManufacture() {
		return dateOfManufacture;
	}
	public void setDateOfManufacture(Date dateOfManufacture) {
		this.dateOfManufacture = dateOfManufacture;
	}
	public Date getDateOfExpiry() {
		return dateOfExpiry;
	}
	public void setDateOfExpiry(Date dateOfExpiry) {
		this.dateOfExpiry = dateOfExpiry;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	public String getProductSubCategory() {
		return productSubCategory;
	}
	public void setProductSubCategory(String productSubCategory) {
		this.productSubCategory = productSubCategory;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", quantity=" + quantity
				+ ", price=" + price + ", dateOfManufacture=" + dateOfManufacture + ", dateOfExpiry=" + dateOfExpiry
				+ ", location=" + location + ", productCategory=" + productCategory + ", productSubCategory="
				+ productSubCategory + "]";
	}
	
	
	

	
}
