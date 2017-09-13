package com.dosurely.onecryptor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dosurely.onecryptor.entity.UserStatus;
import com.dosurely.onecryptor.service.UserStatusService;

@Controller
public class PageLoadController {
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String loadHomePage() {
		return "main.home";
	}
	
	@RequestMapping(value = "/download", method = RequestMethod.GET)
	public String loadDownloadPage() {
		return "main.download";
	}
	
	@RequestMapping(value = "/pricing", method = RequestMethod.GET)
	public String loadPricingPage() {
		return "main.pricing";
	}
	
	@RequestMapping(value = "/product", method = RequestMethod.GET)
	public String loadProductPage() {
		return "main.product";
	}
	
	@RequestMapping(value = "/customer", method = RequestMethod.GET)
	public String loadCustomerPage() {
		return "main.customer";
	}
	
	@RequestMapping(value = "/blog", method = RequestMethod.GET)
	public String loadBlogPage() {
		return "main.blog";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loadLoginPage() {
		return "user.login";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String loadRegisterPage() {
		return "user.register";
	}
}
