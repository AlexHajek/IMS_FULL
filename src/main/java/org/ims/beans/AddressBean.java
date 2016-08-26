package org.ims.beans;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

//import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="IMS_ADDRESS")
public class AddressBean {
	
	@Id
	@Column(name="ADDRESS_ID", nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	@NotNull(message = "arrvId is required.")
	@Min(value=0,message="invalid id")
	private int addressId;
	@Column(name="STREET_ADDRESS_1", nullable=false)
	@NotNull(message = "streetAddress1 is required.")
	@Size(min=0,max=250,message="invalid address size")
	private String streetAddress1;
	@Column(name="STREET_ADDRESS_2", nullable=false)
	@NotNull(message = "streetAddress2 is required.")
	@Size(min=0,max=50,message="invalid address size")
	private String streetAddress2;
	@Column(name="ADDRESS_CITY", nullable=false)
	@NotNull(message = "addressCity is required.")
	@Size(min=0,max=35,message="invalid address city")
	private String addressCity;
	@Column(name="ADDRESS_ZIP", nullable=false)
	@NotNull(message = "addressZip is required.")
	@Digits(integer=10, fraction=0, message="invalid zip")
	private String addressZip;
	@Cascade({CascadeType.SAVE_UPDATE})
	@ManyToOne
	@JoinColumn(name="STATE_ID", nullable=false)
	@NotNull(message = "stateAbbrv is required.")
	@Size(min=2,max=2,message="invalid state abbrv")
	//@JsonManagedReference
	private StateAbbrvBean stateAbbrv;
	
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public String getStreetAddress1() {
		return streetAddress1;
	}
	public void setStreetAddress1(String streetAddress1) {
		this.streetAddress1 = streetAddress1;
	}
	public String getStreetAddress2() {
		return streetAddress2;
	}
	public void setStreetAddress2(String streetAddress2) {
		this.streetAddress2 = streetAddress2;
	}
	public String getAddressCity() {
		return addressCity;
	}
	public void setAddressCity(String addressCity) {
		this.addressCity = addressCity;
	}
	public String getAddressZip() {
		return addressZip;
	}
	public void setAddressZip(String addressZip) {
		this.addressZip = addressZip;
	}
	public StateAbbrvBean getStateAbbrv() {
		return stateAbbrv;
	}
	public void setStateAbbrv(StateAbbrvBean stateAbbrv) {
		this.stateAbbrv = stateAbbrv;
	}
	public AddressBean() {
		super();
		this.stateAbbrv = new StateAbbrvBean();
	}
	public AddressBean(int addressId, String streetAddress1, String streetAddress2, String addressCity,
			String addressZip, StateAbbrvBean stateAbbrv) {
		super();
		this.addressId = addressId;
		this.streetAddress1 = streetAddress1;
		this.streetAddress2 = streetAddress2;
		this.addressCity = addressCity;
		this.addressZip = addressZip;
		this.stateAbbrv = stateAbbrv;
	}	
}
