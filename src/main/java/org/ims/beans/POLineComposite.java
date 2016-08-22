package org.ims.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Embeddable
public class POLineComposite implements Serializable{
	
	@Column(name = "ORDER_NUMBER_ID", nullable=false)
	@NotNull(message="Order Number is required")
	private int orderNumber;
	@Column(name = "LINE_NUMBER_ID", nullable=false)
	@NotNull(message="Line Number is required")
	@Min(value=0,message="Invalid Line")
	private int lineNumber;
	
	public int getOrderNumber() {

		return orderNumber;
	}
	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}
	public int getLineNumber() {
		return lineNumber;
	}
	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}
}
