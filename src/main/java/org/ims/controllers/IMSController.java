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
		List<ProductCategoryBean> list = midF.getAllProductCats();
		req.setAttribute("categories", list);
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
		if(!newProduct.verify()){
			System.out.println("err in verification");
			return this.updateProduct(req);
		}
		MiddleInterfaceF midF = new MiddleInterfaceF();
		List<ProductCategoryBean> list = midF.getAllProductCats();
		newProduct.setCategoriesForProduct(newProduct.link(newProduct, list));
		midF.insertProduct(newProduct);
		return this.viewProducts(req);
	}
	@RequestMapping(value="updateProductInfo.do", method=RequestMethod.POST,params="update")
	public ModelAndView updateProductInfo(@ModelAttribute("updateProduct") @Valid ProductBean updateProduct,
			BindingResult bindingResult,
			HttpServletRequest req,
			HttpServletResponse resp){
		if(bindingResult.hasErrors()){
			return this.viewProducts(req);
		}
		if(!updateProduct.verify()){
			return this.viewProducts(req);
		}
		MiddleInterfaceF midF = new MiddleInterfaceF();
		midF.updateProduct(updateProduct);
		return this.viewProducts(req);
	}
	@RequestMapping(value="updateProductInfo.do", method=RequestMethod.POST,params="delete")
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
		System.out.println(updateProduct.getClass());
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
		mv.setViewName("home");
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
		if(!myClient.verify()){
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
	@RequestMapping(value="updateClientInfo.do", method=RequestMethod.POST,params="update")
	public ModelAndView updateClientInfo(@ModelAttribute("updateClient") @Valid ClientBean updateClient,
			BindingResult bindingResult,
			HttpServletRequest req,
			HttpServletResponse resp){
		if(bindingResult.hasErrors()){
			return this.viewClients(req);
		}
		if(!updateClient.verify()){
			return this.viewClients(req);
		}
		MiddleInterfaceF midF = new MiddleInterfaceF();
		//Need to have old state abbrv?
		ClientBean client_old = new ClientBean();
		List<ClientBean> aList = midF.getAllClients();
		for(ClientBean c:aList){
			if(c.getId()==updateClient.getId()){
				client_old = c;
				break;
			}
		}
		//,client_old.getAddress()
		midF.updateClient(updateClient);
		return this.viewClients(req);
	}
	@RequestMapping(value="updateClientInfo.do", method=RequestMethod.POST,params="delete")
	public ModelAndView deleteClient(ClientBean updateClient,
			HttpServletRequest req,
			HttpServletResponse resp){
		MiddleInterfaceF midF = new MiddleInterfaceF();
		List<ClientBean> aList = midF.getAllClients();
		for(ClientBean c:aList){
			if(c.getId()==updateClient.getId()){
				updateClient = c;
				break;
			}
		}
		midF.deleteClient(updateClient);
		return this.viewClients(req);
	}
	@RequestMapping(value="viewClients.do", method=RequestMethod.GET)
	public ModelAndView viewClients(HttpServletRequest req){
		MiddleInterfaceF midF = new MiddleInterfaceF();
		List<ClientBean> aList = midF.getAllClients();
		req.setAttribute("clients", aList);
		req.setAttribute("updateClient", new ClientBean());
		return new ModelAndView("viewClients");
	}
	@RequestMapping(value="invoices.do", method=RequestMethod.GET)
	public String getProducts(HttpServletRequest req){
		MiddleInterfaceF midF = new MiddleInterfaceF();
		List<ProductBean> aList = midF.getAllProducts();
		List<ClientBean> cList = midF.getAllClients();
		List<String> nameList = new ArrayList<String>();
		List<String> clientNames = new ArrayList<String>();
		nameList.add("--");
		clientNames.add("--");
		for(ProductBean a: aList){
			nameList.add(a.getShortName());
		}
		for(ClientBean c: cList){
			clientNames.add(c.getName());
		}
		//generate list of products and clients
		req.setAttribute("products", nameList);
		req.setAttribute("clients", clientNames);
		return "invoices";
	}
	@RequestMapping(value="reports.do", method=RequestMethod.GET)
	public ModelAndView reports(HttpServletRequest req){
		MiddleInterfaceF midF = new MiddleInterfaceF();
		List<ProductBean> aList = midF.getAllProducts();
		req.setAttribute("products", aList);
		return new ModelAndView("generateReports");
	}
	@RequestMapping(value="faq.do", method=RequestMethod.GET)
	public ModelAndView faq(HttpServletRequest req){
		//Temporarily StateAbbrvBean until I can figure out a better method
		req.setAttribute("email", new StateAbbrvBean());
		return new ModelAndView("faq");
	}
	@RequestMapping(value="email.do", method=RequestMethod.GET)
	public ModelAndView email(StateAbbrvBean email,HttpServletRequest req){
		MiddleInterfaceF midF = new MiddleInterfaceF();
		midF.email(email.getStateName());
		return new ModelAndView("home");
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
