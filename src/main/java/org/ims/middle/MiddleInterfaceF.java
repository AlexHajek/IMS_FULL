package org.ims.middle;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.ims.IMS_WEB.DataLayer;
import org.ims.beans.AddressBean;
import org.ims.beans.ClientBean;
import org.ims.beans.ClientTypeBean;
import org.ims.beans.ProductBean;
import org.ims.beans.ProductCategoryBean;
import org.ims.beans.StateAbbrvBean;

public class MiddleInterfaceF {
	private DataLayer dLayer = new DataLayer();
	public List<StateAbbrvBean> printStateAbb(){
		List<StateAbbrvBean> rList = new ArrayList<>();
		System.out.println(dLayer.test());
		List<StateAbbrvBean> list = dLayer.getAllAbbr();
		for(StateAbbrvBean s:list){
			s.getStateName();
			rList.add(s);
		}
		return rList;
	}
	public List<ProductBean> getAllProducts(){
		List<ProductBean> rList = new ArrayList<>();
		rList = dLayer.getAllProducts();
		return rList;
	}
	public List<ProductCategoryBean> getAllProductCats(){
		List<ProductCategoryBean> rList = new ArrayList<>();
		rList = dLayer.getAllCategories();
		return rList;
	}
	public List<ClientBean> getAllClients(){
		List<ClientBean> rList = new ArrayList<>();
		rList = dLayer.getAllClients();
		return rList;
	}
	public boolean insertProduct(ProductBean product){
		//Product is not in any Lines yet
		product.setLinesForProduct(null);
		//Avoiding this atm
		product.setProductImage(null);
		//Set to 0 at creation
		product.setOnHandQuantity(0);
//		String[] strings = product.getCategoriesString();
//		Set<ProductCategoryBean> beanSet = 
		dLayer.create(product);
		return true;
	}
	public boolean updateProduct(ProductBean product){
		dLayer.update(product);
		return true;
	}
	//,AddressBean client_old
	//,client_old
	public boolean updateClient(ClientBean client){
		dLayer.updateClient(client);
		return true;
	}
	public boolean delete(Object obj){
		dLayer.delete(obj);
		return true;
	}
	public boolean deleteClient(ClientBean client){
		dLayer.deleteClient(client);
		return true;
	}
	public boolean insertProductCat(ProductCategoryBean category){
		//Product Categories contains nothing to begin with
		category.setProductsForCategory(null);
		dLayer.create(category);
		return true;
	}
	public boolean insertObject(Object obj){
		dLayer.create(obj);
		return true;
	}
	public List<StateAbbrvBean> getAbbrvBeans(){
		return dLayer.getAllAbbr();
	}
	public List<ClientTypeBean> getClientTypes(){
		return dLayer.getAllClientTypes();
	}
	public DataLayer getDataLayer(){
		return this.dLayer;
	}
	public StateAbbrvBean getStateAbbrvById(ClientBean myClient){
		Session session = dLayer.getSession();
		Criteria criteria = session.createCriteria(StateAbbrvBean.class)
				.add(Restrictions.eq("arrvId", myClient.getAddress().getStateAbbrv().getArrvId()));
		StateAbbrvBean myBean = (StateAbbrvBean)criteria.uniqueResult();
		return myBean;
	}
	public ClientTypeBean getClientTypeById(ClientBean myClient){
		Session session = dLayer.getSession();
		Criteria criteria = session.createCriteria(ClientTypeBean.class)
				.add(Restrictions.eq("clientTypeId", myClient.getClientType().getClientTypeId()));
		ClientTypeBean myBean = (ClientTypeBean)criteria.uniqueResult();
		return myBean;
	}
	public ProductBean getProductByShort(String myshort){
		Session session = dLayer.getSession();
		Criteria criteria = session.createCriteria(ProductBean.class)
				.add(Restrictions.eq("shortName", myshort));
		ProductBean myBean = (ProductBean)criteria.uniqueResult();
		return myBean;
	}
	//Test location for emailing
	public void email(String str){
		// Recipient's email ID needs to be mentioned.
    String to = "alexanderjhajek@gmail.com";
    // Sender's email ID needs to be mentioned
    String from = "ims@revature.com";
    // Assuming you are sending email from localhost
    String host = "localhost";
    // create some properties and get the default Session
  	Properties props = new Properties();
  	props.put("mail.smtp.host", host);
    // Get the default Session object.
  	javax.mail.Session session = javax.mail.Session.getInstance(props, null);
  	try {
	    // create a message
	    MimeMessage msg = new MimeMessage(session);
	    msg.setFrom(new InternetAddress(from));
	    InternetAddress[] address = {new InternetAddress(to)};
	    msg.setRecipients(Message.RecipientType.TO, address);
	    msg.setSubject("JavaMail APIs Test");
	    msg.setSentDate(new Date());
	    // If the desired charset is known, you can use
	    // setText(text, charset)
	    msg.setText(str+"This is an un");
	    System.out.println("About to transport");
	    Transport.send(msg);
  	} catch (MessagingException mex) {
	    mex.printStackTrace();
	    }
  }
	@Override
	protected void finalize() throws Throwable {
		dLayer.close();
		super.finalize();
	}
}
