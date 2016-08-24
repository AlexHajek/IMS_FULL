package org.ims.controllers;

import java.util.List;
import java.util.Vector;

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
	
	@RequestMapping(method=RequestMethod.GET, value="getProduct.do", produces="application/json")
	@ResponseBody	//write return value directly to HTTP response in the specified content-type (produces=content-type)
	public List<ProductBean> getProductByShort(@RequestParam (value="a") String a){
		MiddleInterfaceF mid = new MiddleInterfaceF();
		ProductBean bean = mid.getProductByShort(a);
		//System.out.println("String inserted to method is: "+a);
		//System.out.println("getProduct.do executed!");
		//System.out.println("Product Return Description: "+bean.getProductDescription());
		products.add(bean);
		return products;
	}
}
