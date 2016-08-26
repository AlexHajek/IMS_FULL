package org.ims.beans;

import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;


@Entity
@Table(name="IMS_STATE_ABBRV")
public class StateAbbrvBean {
	
	@Id
	@Column(name="ABBRV_ID",nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	@NotNull(message = "arrvId is required.")
	@Min(value=0,message="Invalid id")
	private int arrvId;
	
	@Column(name="STATE_NAME",nullable=false)
	@NotNull(message = "stateName is required")
	@Size(min=0,max=15,message="invalid size for stateName")
	private String stateName;
	
	@Column(name="STATE_ABBRV",nullable=false)
	@NotNull(message = "stateAbbrv is required")
	@Size(min=2,max=2,message="stateAbbrv not of size 2!")
	private String stateAbbrv;
	
	@Cascade({CascadeType.SAVE_UPDATE})
	@OneToMany(mappedBy="stateAbbrv")
	private Set<AddressBean> stateAddressSet;
	
	public int getArrvId() {
		return arrvId;
	}
	public void setArrvId(int arrvId) {
		this.arrvId = arrvId;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public String getStateAbbrv() {
		return stateAbbrv;
	}
	public void setStateAbbrv(String stateAbbrv) {
		this.stateAbbrv = stateAbbrv;
	}
	public Set<AddressBean> getStateAddressSet() {
		return stateAddressSet;
	}
	public void setStateAddressSet(Set<AddressBean> stateAddressSet) {
		this.stateAddressSet = stateAddressSet;
	}
	public StateAbbrvBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StateAbbrvBean(int arrvId, String stateName, String stateAbbrv, Set<AddressBean> stateAddressSet) {
		super();
		this.arrvId = arrvId;
		this.stateName = stateName;
		this.stateAbbrv = stateAbbrv;
		this.stateAddressSet = stateAddressSet;
	}
//	public boolean verify(){
//		if(this.arrvId>0&&
//				!this.stateName.isEmpty()&&
//				!this.stateAbbrv.isEmpty())
//			return true;
//		return false;
//	}
}