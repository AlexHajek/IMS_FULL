package org.ims.beans;

import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name="IMS_PRODUCT_CATEGORY")
public class ProductCategoryBean {

	@Id
	@Column(name="CATEGORY_ID",nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	@NotNull(message="Id is required")
	@Min(value=0,message="Invalid ID")
	private int categoryId;
	@Column(name="CATEGROY_DESCRIPTION",nullable=false)
	@NotNull(message="Description is required")
	@Size(max=50,message="Too Long")
	private String categoryDescription;
	
	@ManyToMany
	@JoinTable(name="PRODUCT_CATEGORIES",
					joinColumns=@JoinColumn(name="CATEGORY_ID"),
					inverseJoinColumns=@JoinColumn(name="PRODUCT_UPC"))
	private Set<ProductBean> productsForCategory; 
	
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryDescription() {
		return categoryDescription;
	}
	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}
	public Set<ProductBean> getProductsForCategory() {
		return productsForCategory;
	}
	public void setProductsForCategory(Set<ProductBean> productsForCategory) {
		this.productsForCategory = productsForCategory;
	}
	public ProductCategoryBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProductCategoryBean(int categoryId, String categoryDescription, Set<ProductBean> productsForCategory) {
		super();
		this.categoryId = categoryId;
		this.categoryDescription = categoryDescription;
		this.productsForCategory = productsForCategory;
	}
}
