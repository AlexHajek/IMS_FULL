package org.ims.beans;

import java.sql.Blob;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="IMS_PRODUCT")
public class ProductBean {
	
	@Id
	@Column(name="PRODUCT_UPC",nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	@NotNull(message="UPC is required")
	@Min(value=0,message="Invalid UPC")
	private int productUPC;
	@Column(name="PRODUCT_NAME",nullable=false)
	@NotNull(message="Name is required")
	@Size(max=150,message="Too Long")
	private String productName;
	@Column(name="PRODUCT_DESCRIPTION",nullable=false)
	@NotNull(message="Description is required")
	@Size(max=150,message="Too Long")
	private String productDescription;
	@Column(name="SHORT_NAME",nullable=false)
	@NotNull(message="Abbreviation is required")
	@Size(max=5,message="Too Long")
	private String shortName;
	@Column(name="UNIT_COST",nullable=false)
	@NotNull(message="Cost is required")
	@Min(value=0,message="Invalid Price")
	private double unitCost;
	@Column(name="PACK_SIZE",nullable=false)
	@NotNull(message="Size is required")
	@Size(max=10,message="Too Long")
	private String packSize;
	@Column(name="REORDER_QUANTITY",nullable=false)
	@NotNull(message="Reorder Minimum is required")
	@Min(value=0,message="Invalid Quantity")
	private int reorderQuantity;
	@Column(name="RETAIL_PRICE",nullable=false)
	@NotNull(message="Price is required")
	@Min(value=0,message="Invalid Price")
	private double retailPrice;
	@Column(name="PRODUCT_WEIGHT")
	@Min(value=0,message="Invalid Weight")
	private int productWeight;
	@Column(name="PRODUCT_IMAGE")
	private Blob productImage;
	@ManyToMany
	@JoinTable(name="PRODUCT_CATEGORIES",
					joinColumns=@JoinColumn(name="PRODUCT_UPC"),
					inverseJoinColumns=@JoinColumn(name="CATEGORY_ID"))
	private Set<ProductCategoryBean> categoriesForProduct;

	@OneToMany(mappedBy="product")
	private Set<POLineBean> linesForProduct;

	
	public int getProductUPC() {
		return productUPC;
	}
	public void setProductUPC(int productUPC) {
		this.productUPC = productUPC;
	}
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
	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	public double getUnitCost() {
		return unitCost;
	}
	public void setUnitCost(int unitCost) {
		this.unitCost = unitCost;
	}
	public String getPackSize() {
		return packSize;
	}
	public void setPackSize(String packSize) {
		this.packSize = packSize;
	}
	public int getReorderQuantity() {
		return reorderQuantity;
	}
	public void setReorderQuantity(int reorderQuantity) {
		this.reorderQuantity = reorderQuantity;
	}
	public double getRetailPrice() {
		return retailPrice;
	}
	public void setRetailPrice(double retailPrice) {
		this.retailPrice = retailPrice;
	}
	public int getProductWeight() {
		return productWeight;
	}
	public void setProductWeight(int productWeight) {
		this.productWeight = productWeight;
	}
	public Blob getProductImage() {
		return productImage;
	}
	public void setProductImage(Blob productImage) {
		this.productImage = productImage;
	}
	public Set<ProductCategoryBean> getCategoriesForProduct() {
		return categoriesForProduct;
	}
	public void setCategoriesForProduct(Set<ProductCategoryBean> categoriesForProduct) {
		this.categoriesForProduct = categoriesForProduct;
	}

	public Set<POLineBean> getLinesForProduct() {
		return linesForProduct;
	}
	public void setLinesForProduct(Set<POLineBean> linesForProduct) {
		this.linesForProduct = linesForProduct;
	}

	public ProductBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProductBean(int productUPC, String productName, String productDescription, String shortName, double unitCost,
			String packSize, int reorderQuantity, int retailPrice, int productWeight, Blob productImage,
			Set<ProductCategoryBean> categoriesForProduct, Set<POLineBean> linesForProduct) {
		super();
		this.productUPC = productUPC;
		this.productName = productName;
		this.productDescription = productDescription;
		this.shortName = shortName;
		this.unitCost = unitCost;
		this.packSize = packSize;
		this.reorderQuantity = reorderQuantity;
		this.retailPrice = retailPrice;
		this.productWeight = productWeight;
		this.productImage = productImage;
		this.categoriesForProduct = categoriesForProduct;
		this.linesForProduct = linesForProduct;
	}
}
