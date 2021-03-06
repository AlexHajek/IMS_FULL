package org.ims.beans;

import java.sql.Blob;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

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
	@Column(name="ONHAND_QUANTITY",nullable=false)
	@NotNull(message="On Hand Quantity is required")
	@Min(value=0,message="Invalid Quantity")
	private int onHandQuantity;
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
	private double productWeight;
	@Column(name="PRODUCT_IMAGE")
	private Blob productImage;
	//Controller use only
	@Transient
	private String[] categoriesString;
	@Cascade({CascadeType.SAVE_UPDATE})
	@ManyToMany
	@JoinTable(name="PRODUCT_CATEGORIES",
					joinColumns=@JoinColumn(name="PRODUCT_UPC"),
					inverseJoinColumns=@JoinColumn(name="CATEGORY_ID"))
	private Set<ProductCategoryBean> categoriesForProduct;
	@Cascade({CascadeType.SAVE_UPDATE})
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
	public void setUnitCost(double unitCost) {
		this.unitCost = unitCost;
	}
	public String getPackSize() {
		return packSize;
	}
	public void setPackSize(String packSize) {
		this.packSize = packSize;
	}
	public int getOnHandQuantity() {
		return onHandQuantity;
	}
	public void setOnHandQuantity(int onHandQuantity) {
		this.onHandQuantity = onHandQuantity;
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
	public double getProductWeight() {
		return productWeight;
	}
	public void setProductWeight(double productWeight) {
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
	//Controller use only
	public String[] getCategoriesString() {
		return categoriesString;
	}
	public void setCategoriesString(String[] categoriesString) {
		this.categoriesString = categoriesString;
	}
	public ProductBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProductBean(int productUPC, String productName, String productDescription, String shortName, double unitCost,
			String packSize, int reorderQuantity, int onHandQuantity, double retailPrice, double productWeight, Blob productImage,
			Set<ProductCategoryBean> categoriesForProduct, Set<POLineBean> linesForProduct) {
		super();
		this.productUPC = productUPC;
		this.productName = productName;
		this.productDescription = productDescription;
		this.shortName = shortName;
		this.unitCost = unitCost;
		this.packSize = packSize;
		this.onHandQuantity=onHandQuantity;
		this.reorderQuantity = reorderQuantity;
		this.retailPrice = retailPrice;
		this.productWeight = productWeight;
		this.productImage = productImage;
		this.categoriesForProduct = categoriesForProduct;
		this.linesForProduct = linesForProduct;
	}
	public boolean verify(){
//		System.out.println(this.productUPC+":"+this.productName+":"+this.productDescription+":"+this.shortName+":"
//				+this.unitCost+":"+this.packSize+":"+this.productWeight+":"+this.reorderQuantity+":"+this.retailPrice);
		if(!this.productName.isEmpty()&&!this.productDescription.isEmpty()&&!this.shortName.isEmpty()
				&&this.unitCost>0.0&&!this.packSize.isEmpty()&&this.productWeight>0.0&&this.reorderQuantity>0
				&&this.retailPrice>0.0)
			return true;
		return false;
	}
	public Set<ProductCategoryBean> link(ProductBean product,List<ProductCategoryBean> categories){
		if(product.getCategoriesString().length==0)
			return null;
		Set<ProductCategoryBean> set = new HashSet<>();
		for(String s:product.getCategoriesString()){
			for(int i=0;i<categories.size();i++){
				if(s.equals(categories.get(i).getCategoryDescription())){
					set.add(categories.get(i));
				}
			}
		}
		return set;
	}
}
