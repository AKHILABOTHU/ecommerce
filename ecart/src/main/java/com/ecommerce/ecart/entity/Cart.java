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
@Table(name="cart")
public class Cart {
	
	//define fileds
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cart_id")
	private long cartId;
	
	@Column(name="quantity")
	private int quantity;
	
	@OneToMany
	@JoinTable(
            name="cart_product",
            joinColumns = @JoinColumn( name="cart_id"),
            inverseJoinColumns = @JoinColumn( name="product_id"))
	private List<Product> product;

	
	//define constructors
	public Cart() {}
	
	
		
	
	//define setter/getter
	
	
	

}
