package org.ims.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.ims.beans.ClientBean;
import org.ims.beans.ProductBean;
import org.ims.middle.MiddleInterfaceF;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AjaxController {
	private List<ProductBean> products = new Vector<ProductBean>();
	private List<ProductBean> allProducts = new Vector<ProductBean>();
	private List<ClientBean> client = new Vector<ClientBean>();
	@RequestMapping(method=RequestMethod.GET, value="getProduct.do", produces="application/json")
	@ResponseBody	//write return value directly to HTTP response in the specified content-type (produces=content-type)
	public List<ProductBean> getProductByShort(@RequestParam (value="a") String a){
		MiddleInterfaceF mid = new MiddleInterfaceF();
		if(a.equals("--")){
			return products;
		}
		if(products.isEmpty() == false){
			products.clear();
		}
		//if user selects the empty option
	
		ProductBean bean = mid.getProductByShort(a);
		//System.out.println("String inserted to method is: "+a);
		//System.out.println("getProduct.do executed!");
		//System.out.println("Product Return Description: "+bean.getProductDescription());
		//System.out.println("Product Description: "+bean.getProductDescription());
		products.add(bean);
		return products;
	}
	@RequestMapping(method=RequestMethod.GET, value="getAllProducts.do", produces="application/json")
	@ResponseBody	//write return value directly to HTTP response in the specified content-type (produces=content-type)
	public List<String> getAllProductNames(){
		MiddleInterfaceF mid = new MiddleInterfaceF();
		List<ProductBean> aList = mid.getAllProducts();
		List<String> nameList = new ArrayList<String>();
		nameList.add("--");
		for(ProductBean a: aList){
			nameList.add(a.getShortName());
		}
		//System.out.println("String inserted to method is: "+a);
		//System.out.println("getProduct.do executed!");
		//System.out.println("Product Return Description: "+bean.getProductDescription());
		return nameList;
	}
	@RequestMapping(method=RequestMethod.GET, value="getClient.do", produces="application/json")
	@ResponseBody	//write return value directly to HTTP response in the specified content-type (produces=content-type)
	public List<ClientBean> getClient(@RequestParam (value="a") String a){
		MiddleInterfaceF mid = new MiddleInterfaceF();
		if(a.equals("--")){
			return client;
		}
		if(products.isEmpty() == false){
			client.clear();
		}
		//if user selects the empty option
	
		ClientBean bean = mid.getClientByName(a);
		//System.out.println("String inserted to method is: "+a);
		//System.out.println("getProduct.do executed!");
		//System.out.println("Product Return Description: "+bean.getProductDescription());
		client.add(bean);
		
		return client;
	}
	
}
