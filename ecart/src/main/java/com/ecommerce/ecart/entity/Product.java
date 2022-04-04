package com.ecommerce.ecart.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="product_id")
	private long productId;
	
	
	@Column(name="product_name")
	private String productName;
	
	@Column(name="price")
	private float price;
	
	
	@OneToMany
	@JoinTable(
            name="product_book",
            joinColumns = @JoinColumn( name="product_id"),
            inverseJoinColumns = @JoinColumn( name="book_id"))
	private List<Book> book;
	
	
	@OneToMany
	@JoinTable(
            name="product_apparal",
            joinColumns = @JoinColumn( name="product_id"),
            inverseJoinColumns = @JoinColumn( name="apparal_id"))
	private List<Apparal> apparal;
	

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	

	public List<Book> getBook() {
		return book;
	}

	public void setBook(List<Book> book) {
		this.book = book;
	}

	public List<Apparal> getApparal() {
		return apparal;
	}

	public void setApparal(List<Apparal> apparal) {
		this.apparal = apparal;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", price=" + price + "]";
	}
	
	
	
}
