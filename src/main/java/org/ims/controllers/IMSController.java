package org.ims.controllers;

import java.util.List;
import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.ims.IMS_WEB.DataLayer;
import org.ims.beans.AddressBean;
import org.ims.beans.ClientBean;
import org.ims.beans.ClientTypeBean;
import org.ims.beans.ProductBean;
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
		return "updateProduct";
	}
	@RequestMapping(value="updateClientList.do", method=RequestMethod.GET)
	public String updateClientList(HttpServletRequest req){
		req.setAttribute("myClient", new ClientBean());
		return "updateClientList";
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
		/*
		StateAbbrv clientStateAbbrv = new StateAbbrv(Integer.parseInt(req.getParameter("stateAbbrvId")),
													req.getParameter("stateName"),
													req.getParameter("stateAbbrv"),
													null);
		Address clientAddress = new Address(Integer.parseInt(req.getParameter("addressId")),
											req.getParameter("streetAddress1"),
											req.getParameter("streetAddress2"),
											req.getParameter("addressCity"),
											req.getParameter("addressZip"),
											clientStateAbbrv);
		ClientType newClientType = new ClientType(Integer.parseInt(req.getParameter("clientTypeId")),
													req.getParameter("clientType"),
													null);
													*/
		System.out.println(req.getParameter("id"));
		System.out.println(req.getParameter("name"));
		ClientBean newClient = new ClientBean(Integer.parseInt(req.getParameter("id")),
										req.getParameter("name"),
										req.getParameter("email"),
										req.getParameter("pocn"),
										req.getParameter("phone"),
										req.getParameter("fax"),
										new AddressBean()/*clientAddress,*/,
										new ClientTypeBean()/*newClientType*/);			
		clientList.add(newClient);
		//testing
		DataLayer dLayer = new DataLayer();
		System.out.println(dLayer.test());
		for(StateAbbrvBean s:dLayer.getAllAbbr()){
			System.out.println(s.getStateName());
		}
		dLayer.close();
//		Session session = SessionFactoryManager.getInstance().openSession();
//		IMSDAO myDAO = new IMSDAO(session);
//		myDAO.create(newClient);
//		session.close();
		
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
