package org.ims.IMS_WEB;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.ims.beans.AddressBean;
import org.ims.beans.ClientBean;
import org.ims.beans.ClientTypeBean;
import org.ims.beans.ProductBean;
import org.ims.beans.ProductCategoryBean;
import org.ims.beans.StateAbbrvBean;

public class DataLayer {
	private Session session;//Session-per-request
	private IMSDAO dao;
	
	public DataLayer() {
		session = SessionFactoryManager.getInstance().openSession();
		dao = new IMSDAO(session);
	}
	
	public void close(){
		if(session!=null) session.close();
	}
	
	public int test(){return 68;}
	
	public List<StateAbbrvBean> getAllAbbr(){
		return dao.getAllStatesAbb();
	}
	
	public List<ClientTypeBean> getAllClientTypes(){
		return dao.getAllClientTypes();
	} 
	
	public List<ProductBean> getAllProducts(){
		return dao.getAllProducts();
	}
	
	public List<ProductCategoryBean> getAllCategories(){
		return dao.getAllCategories();
	}
	
	public List<ClientBean> getAllClients(){
		return dao.getAllClients();
	}
	
	public void create(Object obj){
		Transaction tran = session.beginTransaction();
		dao.create(obj);
		tran.commit();
	}
	
	public void update(Object obj){
		Transaction tran = session.beginTransaction();
		dao.update(obj);
		tran.commit();
	}
	
	public void delete(Object obj){
		Transaction tran = session.beginTransaction();
		dao.delete(obj);
		tran.commit();
	}
	
	public void deleteClient(ClientBean client){
		Transaction tran = session.beginTransaction();
		dao.delete(client);
		dao.delete(client.getAddress());
		tran.commit();
	}
	//,AddressBean client_old
	public void updateClient(ClientBean client){
		Transaction tran = session.beginTransaction();
//		System.out.println("Abbrv: "+client_old.getStateAbbrv());
//		dao.update(client_old.getStateAbbrv());
		AddressBean address = client.getAddress();
		StateAbbrvBean abbrv = address.getStateAbbrv();
		System.out.println("Abbrv: "+client.getAddress().getStateAbbrv());
		dao.update(abbrv);
		System.out.println("Add: "+client.getAddress());
		dao.update(address);
		System.out.println("Client: "+client);
		dao.update(client);
		System.out.println("ready");
		tran.commit();
		System.out.println("doen");
	}
	
	public Session getSession(){
		return this.session;
	}
}
