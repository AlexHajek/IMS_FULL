package org.ims.IMS_WEB;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryManager {
	
	private static SessionFactory sf;
	
	private SessionFactoryManager() {
		super();
	}
	
	public static synchronized SessionFactory getInstance(){
		if(sf==null){
			//Only in 3.6
			sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		}
		return sf;
	}
}
