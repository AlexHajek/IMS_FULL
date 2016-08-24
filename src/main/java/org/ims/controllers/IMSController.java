package org.ims.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.ims.IMS_WEB.DataLayer;
import org.ims.beans.ClientBean;
import org.ims.beans.ClientTypeBean;
import org.ims.beans.ProductBean;
import org.ims.beans.ProductCategoryBean;
import org.ims.beans.StateAbbrvBean;
import org.ims.middle.MiddleInterfaceF;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IMSController implements ServletContextAware,
																			InitializingBean{	
	@Autowired
	private ServletContext servletContext; //instance var
	@RequestMapping(value="updateProduct.do", method=RequestMethod.GET)
	public ModelAndView updateProduct(HttpServletRequest req){
		req.setAttribute("newProduct", new ProductBean());
		MiddleInterfaceF midF = new MiddleInterfaceF();
		List<ProductCategoryBean> list = midF.getAllProductCats();
		req.setAttribute("categories", list);
		return new ModelAndView("updateProduct");
	}
	@RequestMapping(value="updateClientList.do", method=RequestMethod.GET)
	public ModelAndView updateClientList(HttpServletRequest req){
		MiddleInterfaceF mid = new MiddleInterfaceF();
		req.setAttribute("myClient", new ClientBean());
		List<StateAbbrvBean> abbrvList = mid.getAbbrvBeans();
		List<ClientTypeBean> typeList = mid.getClientTypes();
		req.setAttribute("myAbbrvs", abbrvList);
		req.setAttribute("clientTypes", typeList);
		return new ModelAndView("updateClientList");
	}
	@RequestMapping(value="updateProductCats.do", method=RequestMethod.GET)
	public ModelAndView updateProductCats(HttpServletRequest req){
		req.setAttribute("newProductCat", new ProductCategoryBean());
		return new ModelAndView("updateProductCat");
	}
	@RequestMapping(value="viewProducts.do", method=RequestMethod.GET)
	public ModelAndView viewProducts(HttpServletRequest req){
		MiddleInterfaceF midF = new MiddleInterfaceF();
		List<ProductBean> aList = midF.getAllProducts();
		req.setAttribute("products", aList);
		req.setAttribute("updateProduct", new ProductBean());
		return new ModelAndView("viewProducts");
	}
	@RequestMapping(value="registerProduct.do", method=RequestMethod.POST)
	public ModelAndView registerProduct(@ModelAttribute("newProduct") @Valid ProductBean newProduct,
			BindingResult bindingResult,
			HttpServletRequest req,
			HttpServletResponse resp){
		if(bindingResult.hasErrors()){
			return this.updateProduct(req);
		}
		MiddleInterfaceF midF = new MiddleInterfaceF();
		
		midF.insertProduct(newProduct);
		return this.viewProducts(req);
	}
	@RequestMapping(value="updateProductInfo.do", method=RequestMethod.POST)
	public ModelAndView updateProductInfo(@ModelAttribute("updateProduct") @Valid ProductBean updateProduct,
			BindingResult bindingResult,
			HttpServletRequest req,
			HttpServletResponse resp){
		if(bindingResult.hasErrors()){
			return this.viewProducts(req);
		}
		MiddleInterfaceF midF = new MiddleInterfaceF();
		midF.updateProduct(updateProduct);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		return mv;
	}
		@RequestMapping(value="deleteProduct.do", method=RequestMethod.POST)
	public ModelAndView deleteProduct(ProductBean updateProduct,
			HttpServletRequest req,
			HttpServletResponse resp){
		
		MiddleInterfaceF midF = new MiddleInterfaceF();
		List<ProductBean> aList = midF.getAllProducts();
		for(ProductBean p:aList){
			if(p.getProductUPC()==updateProduct.getProductUPC()){
				updateProduct = p;
				break;
			}
		}
		midF.delete(updateProduct);
		return this.viewProducts(req);
	}
	@RequestMapping(value="registerProductCat.do", method=RequestMethod.POST)
	public ModelAndView registerProductCat(@ModelAttribute("newProduct") @Valid ProductCategoryBean newProductCat,
			BindingResult bindingResult,
			HttpServletRequest req,
			HttpServletResponse resp){
		if(bindingResult.hasErrors()){
			return this.updateProductCats(req);
		}
		MiddleInterfaceF midF = new MiddleInterfaceF();
		midF.insertProductCat(newProductCat);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		return mv;
	}
	@RequestMapping(value="updateclient.do", method=RequestMethod.POST)
	public ModelAndView registerClient(
			@ModelAttribute("myClient") @Valid ClientBean myClient, 
			BindingResult bindingResult,
			HttpServletRequest req, 
			HttpServletResponse resp 
			){
		if(bindingResult.hasErrors()){
			System.out.println("bindingResult failed!");
			return this.updateClientList(req);
		}
		@SuppressWarnings("unchecked")
		Vector<ClientBean> clientList = (Vector<ClientBean>)this.servletContext.getAttribute("clientList");
		
		MiddleInterfaceF midF = new MiddleInterfaceF();
		StateAbbrvBean myBean = midF.getStateAbbrvById(myClient);
		ClientTypeBean myBean2 = midF.getClientTypeById(myClient);
		
		myClient.getAddress().setStateAbbrv(myBean);
		myClient.setClientType(myBean2);
		
		midF.insertObject(myClient.getAddress());
		midF.insertObject(myClient);
		req.getSession().setAttribute("clientList", clientList);
		return this.viewClients(req);
	}
	@RequestMapping(value="updateClientInfo.do", method=RequestMethod.POST)
	public ModelAndView updateClientInfo(@ModelAttribute("updateProduct") @Valid ClientBean updateClient,
			BindingResult bindingResult,
			HttpServletRequest req,
			HttpServletResponse resp){
		if(bindingResult.hasErrors()){
			return new ModelAndView("updateProduct");
		}
		MiddleInterfaceF midF = new MiddleInterfaceF();
		midF.updateClient(updateClient);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		return mv;
	}
	@RequestMapping(value="viewClients.do", method=RequestMethod.GET)
	public ModelAndView viewClients(HttpServletRequest req){
		MiddleInterfaceF midF = new MiddleInterfaceF();
		List<ClientBean> aList = midF.getAllClients();
		req.setAttribute("clients", aList);
		req.setAttribute("updateClient", new ClientBean());
		return new ModelAndView("viewClients");
	}

	@RequestMapping(value="ajaxtest.do", method=RequestMethod.GET)
	public String getProducts(HttpServletRequest req){
		MiddleInterfaceF midF = new MiddleInterfaceF();
		List<ProductBean> aList = midF.getAllProducts();
		List<String> nameList = new ArrayList<String>();
		for(ProductBean a: aList){
			nameList.add(a.getShortName());
		}
		req.setAttribute("products", nameList);
		return "ajaxtest";
	}
	@Override
	public void afterPropertiesSet() throws Exception {
		List<ClientBean> clients = new Vector<>();
		servletContext.setAttribute("clientList", clients);
	}
	@Override
	public void setServletContext(ServletContext ctxt) {
		this.servletContext = ctxt;
		}
}
