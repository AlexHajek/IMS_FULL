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
	public Object retrieve(Object obj){
		Object returnObj;
		Query query;
		String hql = "from org.ims.beans.";
		switch(obj.getClass().getName()){
		case "AddressBean":
			hql+=obj.getClass().getName()+" where addressId:=param1";
			query = session.createQuery(hql);
			query.setInteger("param1",((AddressBean)obj).getAddressId());
		break;
		case "ClientBean":
			hql+=obj.getClass().getName()+" where clientId:=param1";
			query = session.createQuery(hql);
			query.setInteger("param1",((ClientBean)obj).getId());
		break;
		case "ClientTypeBean":
			hql+=obj.getClass().getName()+" where clientTypeId:=param1";
			query = session.createQuery(hql);
			query.setInteger("param1",((ClientTypeBean)obj).getClientTypeId());
		break;
			
		case "ProductBean":
			hql+=obj.getClass().getName()+" where productUPC:=param1";
			query = session.createQuery(hql);
			query.setInteger("param1",((ProductBean)obj).getProductUPC());
		break;
		case "ProductCategoryBean":
			hql+=obj.getClass().getName()+" where categoryId:=param1";
			query = session.createQuery(hql);
			query.setInteger("param1",((ProductCategoryBean)obj).getCategoryId());
		break;
		case "StateAbbrvBean":
			hql+=obj.getClass().getName()+" where arrvId:=param1";
			query = session.createQuery(hql);
			query.setInteger("param1",((StateAbbrvBean)obj).getArrvId());
		break;
		default:return null;
		}
		returnObj = query.uniqueResult();
		return returnObj;
	}
  public void update(Object obj){
  	session.update(obj);
  }
  public boolean delete(Object obj){
  	return true;
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
