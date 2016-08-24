package org.ims.beans;

import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name="IMS_CLIENT")
public class ClientBean {
	@Id
	@Column(name="CLIENT_ID", nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	@NotNull(message = "id is required.")
	@Min(value=0,message="invalid id")
	private int id;
	@Column(name="CLIENT_NAME", nullable=false)
	@NotNull(message = "name is required.")
	@Size(min=0,max=100,message="invalid name")
	private String name;
	@Column(name="CLIENT_EMAIL", nullable=false)
	@NotNull(message = "email is required.")
	@Pattern(regexp="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", message="invalid email")
	private String email;
	@Column(name="POINT_OF_CONTACT_NAME", nullable=false)
	@NotNull(message = "pocname is required.")
	@Size(min=0,max=250,message="invalid pocname")
	private String pocn;
	@Column(name="CLIENT_PHONE", nullable=false)
	@NotNull(message = "phone is required.")
	@Size(min=0,max=15,message="invalid phone")
	private String phone;
	@Column(name="CLIENT_FAX", nullable=false)
	@NotNull(message = "fax is required.")
	@Size(min=0,max=15,message="invalid fax")
	private String fax;
	
//Mappings
	@Cascade({CascadeType.SAVE_UPDATE})
	@OneToOne
	@JoinColumn(name="ADDRESS_ID", nullable=false)
	private AddressBean address;
	@Cascade({CascadeType.SAVE_UPDATE})
	@ManyToOne
	@JoinColumn(name="CLIENT_TYPE_ID", nullable=false)
	private ClientTypeBean clientType;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPocn() {
		return pocn;
	}
	public void setPocn(String pocn) {
		this.pocn = pocn;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public AddressBean getAddress() {
		return address;
	}
	public void setAddress(AddressBean address) {
		this.address = address;
	}
	public ClientTypeBean getClientType() {
		return clientType;
	}
	public void setClientType(ClientTypeBean clientType) {
		this.clientType = clientType;
	}
	public ClientBean() {
		super();
		this.address = new AddressBean();
		this.clientType = new ClientTypeBean();
	}
	public ClientBean(int id, String name, String email, String pocn, String phone, String fax, AddressBean address,
	    ClientTypeBean clientType) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.pocn = pocn;
		this.phone = phone;
		this.fax = fax;
		this.address = address;
		this.clientType = clientType;
	}
}
