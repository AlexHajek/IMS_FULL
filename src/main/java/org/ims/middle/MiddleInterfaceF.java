package org.ims.middle;

import java.util.ArrayList;
import java.util.List;

import org.ims.IMS_WEB.DataLayer;
import org.ims.beans.ProductBean;
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
	public boolean insertProduct(ProductBean product){
		//Product Doesn't accept type at creation
		product.setCategoriesForProduct(null);
		//Product is not in any Lines yet
		product.setLinesForProduct(null);
		//Avoiding this atm
		product.setProductImage(null);
		System.out.println(product.getUnitCost());
		dLayer.create(product);
		return true;
	}
	@Override
	protected void finalize() throws Throwable {
		dLayer.close();
		super.finalize();
	}
}
