package org.ims.middle;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.ims.IMS_WEB.DataLayer;
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
	public boolean insertProduct(ProductBean product){
		//Product is not in any Lines yet
		product.setLinesForProduct(null);
		//Avoiding this atm
		product.setProductImage(null);
//		String[] strings = product.getCategoriesString();
//		Set<ProductCategoryBean> beanSet = 
		dLayer.create(product);
		return true;
	}
	public boolean updateProduct(ProductBean product){
		dLayer.update(product);
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
	@Override
	protected void finalize() throws Throwable {
		dLayer.close();
		super.finalize();
	}
}
