package org.ims.beans;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name="IMS_PO_LINE")
public class POLineBean {
	
	@EmbeddedId		//composite key
	@NotNull(message="Composite Key is required")
	private POLineComposite compositeKey;
	@Column(name="UNIT_PRICE", nullable=false)
	@NotNull(message="Price is required")
	@Min(value=0,message="Invalid Price")
	private double unitPrice;
	@Column(name="QUANTITY_ORDERED", nullable=false)
	@NotNull(message="Quantity is required")
	@Min(value=0,message="Invalid Quantity")
	private int quantityOrdered;
	
	//mappings
	@Cascade({CascadeType.SAVE_UPDATE})
	@ManyToOne
	@JoinColumn(name="PRODUCT_UPC", nullable=false)
	private ProductBean product;
	@Cascade({CascadeType.SAVE_UPDATE})
	@ManyToOne
	@JoinColumn(name="ORDER_NUMBER", nullable=false)
	private PurchaseOrderBean order;
	
	public POLineComposite getCompositeKey() {
		return compositeKey;
	}
	public void setCompositeKey(POLineComposite compositeKey) {
		this.compositeKey = compositeKey;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public int getQuantityOrdered() {
		return quantityOrdered;
	}
	public void setQuantityOrdered(int quantityOrdered) {
		this.quantityOrdered = quantityOrdered;
	}
	public ProductBean getProduct() {
		return product;
	}
	public void setProduct(ProductBean product) {
		this.product = product;
	}
	public PurchaseOrderBean getOrder() {
		return order;
	}
	public void setOrder(PurchaseOrderBean order) {
		this.order = order;
	}
	public POLineBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public POLineBean(POLineComposite compositeKey, double unitPrice, int quantityOrdered, ProductBean product,
			PurchaseOrderBean order) {
		super();
		this.compositeKey = compositeKey;
		this.unitPrice = unitPrice;
		this.quantityOrdered = quantityOrdered;
		this.product = product;
		this.order = order;
	}
}
