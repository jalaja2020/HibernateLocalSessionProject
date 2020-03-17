package com.hcl.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
@Entity
@Table(name="Category")
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="category_id")
	private Integer categoryId;
	@Column(name="category_name")
	private String name;
	@Column(name="category_desc")
	private String desc;
	
	@ManyToMany(mappedBy = "categories")
	 Set<Stock> stocks;
	
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Set<Stock> getStocks() {
		return stocks;
	}
	public void setStocks(Set<Stock> stocks) {
		this.stocks = stocks;
	}
	public Category() {
		super();
	}
	public Category(Integer categoryId, String name, String desc, Set<Stock> stocks) {
		super();
		this.categoryId = categoryId;
		this.name = name;
		this.desc = desc;
		this.stocks = stocks;
	}
	
	
}
