package org.ims.beans;

import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name="IMS_CLIENT_TYPE")
public class ClientTypeBean {
	
	@Id
	@Column(name="CLIENT_TYPE_ID", nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	@NotNull(message = "clientTypeId is required.")
	@Min(value=0,message="invalid clientTypeId")
	private int clientTypeId;
	@Column(name="CLIENT_TYPE", nullable=false)
	@NotNull(message = "clientType is required.")
	@Size(min=0,max=25,message="invalid clientType")
	private String clientType;
	
	@OneToMany(mappedBy="clientType")
	private Set<ClientBean> ClientSet;

	public int getClientTypeId() {
		return clientTypeId;
	}

	public void setClientTypeId(int clientTypeId) {
		this.clientTypeId = clientTypeId;
	}

	public String getClientType() {
		return clientType;
	}

	public void setClientType(String clientType) {
		this.clientType = clientType;
	}

	public Set<ClientBean> getClientSet() {
		return ClientSet;
	}

	public void setClientSet(Set<ClientBean> clientSet) {
		ClientSet = clientSet;
	}

	public ClientTypeBean() {
		super();
	}

	public ClientTypeBean(int clientTypeId, String clientType, Set<ClientBean> clientSet) {
		super();
		this.clientTypeId = clientTypeId;
		this.clientType = clientType;
		ClientSet = clientSet;
	}
}