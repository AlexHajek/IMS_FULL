package org.ims.IMS_WEB;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.ims.beans.*;

public class IMSDAO {
	private Session session;
	
	public IMSDAO() {
		super();
	}
	
	public IMSDAO(Session session) {
		super();
		this.session = session;
	}
	
	public void create(Object obj){
		session.save(obj);
	}
  public void update(Object obj){
  	session.update(obj);
  }
  public void delete(Object obj){
  	session.delete(obj);
  }
  public List<StateAbbrvBean> getAllStatesAbb(){
		Query query =session.createQuery("FROM StateAbbrvBean");
		return query.list();
	}
  public List<ProductBean> getAllProducts(){
  	Query query =session.createQuery("FROM ProductBean");
		return query.list();
  }
  public List<ClientBean> getAllClients(){
  	Query query =session.createQuery("FROM ClientBean");
		return query.list();
  }
  public List<ProductCategoryBean> getAllCategories(){
  	Query query =session.createQuery("FROM ProductCategoryBean");
		return query.list();
  }
  public List<ClientTypeBean> getAllClientTypes(){
	  	Query query = session.createQuery("FROM ClientTypeBean");
	  	return query.list();
}
}
