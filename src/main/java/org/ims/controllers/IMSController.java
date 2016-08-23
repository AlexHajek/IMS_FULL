package org.ims.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
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
	public String updateProduct(HttpServletRequest req){
		req.setAttribute("newProduct", new ProductBean());
		MiddleInterfaceF midF = new MiddleInterfaceF();
		List<ProductCategoryBean> list = midF.getAllProductCats();
		List<String> names = new ArrayList<>();
		for(ProductCategoryBean p:list){
			names.add(p.getCategoryDescription());
			System.out.println(p.getCategoryDescription());
		}
		req.setAttribute("categories", names);
		return "updateProduct";
	}
	@RequestMapping(value="updateClientList.do", method=RequestMethod.GET)
	public String updateClientList(HttpServletRequest req){
		MiddleInterfaceF mid = new MiddleInterfaceF();
		req.setAttribute("myClient", new ClientBean());
		List<StateAbbrvBean> abbrvList = mid.getAbbrvBeans();
		List<ClientTypeBean> typeList = mid.getClientTypes();
		req.setAttribute("myAbbrvs", abbrvList);
		req.setAttribute("clientTypes", typeList);
		return "updateClientList";
	}
	@RequestMapping(value="updateProductCats.do", method=RequestMethod.GET)
	public String updateProductCats(HttpServletRequest req){
		req.setAttribute("newProductCat", new ProductCategoryBean());
		return "updateProductCat";
	}
	@RequestMapping(value="viewProducts.do", method=RequestMethod.GET)
	public String viewProducts(HttpServletRequest req){
		MiddleInterfaceF midF = new MiddleInterfaceF();
		List<ProductBean> aList = midF.getAllProducts();
		req.setAttribute("products", aList);
		req.setAttribute("updateProduct", new ProductBean());
		return "viewProducts";
	}
	@RequestMapping(value="registerProduct.do", method=RequestMethod.POST)
	public ModelAndView registerProduct(@ModelAttribute("newProduct") @Valid ProductBean newProduct,
			BindingResult bindingResult,
			HttpServletRequest req,
			HttpServletResponse resp){
		if(bindingResult.hasErrors()){
			return new ModelAndView("updateProduct");
		}
		MiddleInterfaceF midF = new MiddleInterfaceF();
		midF.insertProduct(newProduct);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		return mv;
	}
	@RequestMapping(value="updateProduct.do", method=RequestMethod.POST)
	public ModelAndView updateProduct(@ModelAttribute("updateProduct") @Valid ProductBean updateProduct,
			BindingResult bindingResult,
			HttpServletRequest req,
			HttpServletResponse resp){
		if(bindingResult.hasErrors()){
			return new ModelAndView("updateProduct");
		}
		MiddleInterfaceF midF = new MiddleInterfaceF();
		midF.insertProduct(updateProduct);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		return mv;
	}
	@RequestMapping(value="registerProductCat.do", method=RequestMethod.POST)
	public ModelAndView registerProductCat(@ModelAttribute("newProduct") @Valid ProductCategoryBean newProductCat,
			BindingResult bindingResult,
			HttpServletRequest req,
			HttpServletResponse resp){
		if(bindingResult.hasErrors()){
			return new ModelAndView("updateProduct");
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
			return new ModelAndView("updateClientList");
		}
		@SuppressWarnings("unchecked")
		Vector<ClientBean> clientList = (Vector<ClientBean>)this.servletContext.getAttribute("clientList");
		
		System.out.println(req.getParameter("id"));
		System.out.println(req.getParameter("name"));
		
		MiddleInterfaceF midF = new MiddleInterfaceF();
		Session session = midF.getDataLayer().getSession();
		
		Criteria criteria = session.createCriteria(StateAbbrvBean.class)
				.add(Restrictions.eq("arrvId", myClient.getAddress().getStateAbbrv().getArrvId()));
		Criteria criteria2 = session.createCriteria(ClientTypeBean.class)
				.add(Restrictions.eq("clientTypeId", myClient.getClientType().getClientTypeId()));
		StateAbbrvBean myBean = (StateAbbrvBean)criteria.uniqueResult();
		ClientTypeBean myBean2 = (ClientTypeBean)criteria2.uniqueResult();
		
		myClient.getAddress().setStateAbbrv(myBean);
		myClient.setClientType(myBean2);
		
		midF.insertObject(myClient.getAddress());
		midF.insertObject(myClient);
		req.getSession().setAttribute("clientList", clientList);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("viewClients"); 	//viewClients.jsp
		mv.addObject("success", "Successfully added client!");	
		return mv;
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
