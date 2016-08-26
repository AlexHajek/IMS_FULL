package org.ims.IMS_WEB;

import java.sql.Blob;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.ims.beans.POLineBean;
import org.ims.beans.ProductBean;
import org.ims.beans.ProductCategoryBean;

/**
 * Hello world!
 *
 */
public class App {
	private Session session;
  public static void main( String[] args ){
  	App app = new App();
//		Used for initialization of the abbreviations
//  	String[] stateArr = new String[] {"Alabama", "Arkansas", "Arizona", "Alaska", "California", "Colorado", "Connecticut", "Delaware", "Florida", "Georgia", "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana", "Maine", "Maryland", "Massachusetts", "Michigan", "Minnesota", "Mississippi", "Missouri", "Montana", "Nebraska", "Nevada", "New Hampshire", "New Jersey", "New Mexico", "New York", "North Carolina", "North Dakota", "Ohio", "Oklahoma", "Oregon", "Pennsylvania", "Rhode Island", "South Carolina", "South Dakota", "Tennessee", "Texas", "Utah", "Vermont", "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming" };
//  	String[] abbreviations = new String[]{"AL","AK","AZ","AR","CA","CO","CT","DE","FL","GA","HI","ID","IL","IN","IA","KS","KY","LA","ME","MD","MA","MI","MN","MS","MO","MT","NE","NV","NH","NJ","NM","NY","NC","ND", "OH","OK","OR","PA","RI","SC","SD","TN","TX","UT","VT","VA","WA","WV","WI","WY"};
  	DataLayer dLayer = new DataLayer();
//  	ProductBean p = new ProductBean(0,"Sugar","White,Granular,Sweet","SUGAR",new Double(0.0),"cube",100,0,new Double(1.5),new Double(1.0),null,null,null);
//  	ProductBean p2 = new ProductBean(0,"Coconuts","Coconut,Brown,Hairy,Milky,Healthy","CONUT",new Double(0.0),"Coconut",50,0,new Double(1.01),new Double(1.01),null,null,null);
//  	ProductBean p3 = new ProductBean(0,"MidTest","testing","MID",new Double(35.2),"MID",20,0,new Double(35.8),new Double(8.35),null,null,null);
//  	dLayer.create(p);
//  	dLayer.create(p2);
//  	dLayer.create(p3);
//  	List<ProductBean> list = dLayer.getAllProducts();
//  	for(ProductBean p:list){
//  		System.out.println(
//  				0+",'"+p.getProductName()+"','"+p.getProductDescription()+"','"+p.getShortName()+"',new Double("+p.getUnitCost()+"),'"+
//  				p.getPackSize()+"',"+p.getReorderQuantity()+",0,new Double("+p.getRetailPrice()+"),new Double("+p.getProductWeight()+"),null,null,null"
//  				);
//  	}
  	dLayer.close();
//  	int productUPC, String productName, String productDescription, String shortName, double unitCost,
//		String packSize, int reorderQuantity, int onHandQuantity, double retailPrice, double productWeight, Blob productImage,
//		Set<ProductCategoryBean> categoriesForProduct, Set<POLineBean> linesForProduct
//  	for(int i=0;i<stateArr.length;i++){
//  		StateAbbrvBean abbr = new StateAbbrvBean(1,stateArr[i],abbreviations[i],null);
//  		System.out.println(abbr.getStateAbbrv() + "," + abbr.getStateName());
//  		app.session.save(abbr);
//  	}
//  	StateAbbrvBean abbr = new StateAbbrvBean(1,"Alaska","AK",null);
//  	ClientBean client = new ClientBean(1,"Test","test","test","111-111-1111","222-222-2222",);
//  	System.out.println(abbr.getStateAbbrv() + "," + abbr.getStateName());
//  	app.session.save(abbr);
//  	for(StateAbbrvBean s: list){
//  		System.out.println(s.getStateAbbrv());
  	}
  }
