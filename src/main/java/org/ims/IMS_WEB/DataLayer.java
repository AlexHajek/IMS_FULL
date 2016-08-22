package org.ims.IMS_WEB;

import java.util.List;

import org.hibernate.Session;
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
	
}
