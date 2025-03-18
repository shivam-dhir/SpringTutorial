package com.Shivam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	
	// ModelAttribute is used to assign variables/ objects beforehand
	@ModelAttribute
	public void assignName(ModelMap mm) {
		mm.addAttribute("name", "Shivam");
	}
	
	@RequestMapping("/")
	public String home() {
		System.out.println("Home page invoked");
		return "index";
	}
	
	@RequestMapping("add")
	// request mapping allows to fetch parameters from HttpServletRequest object
	public String add(@RequestParam("num1") int num1, @RequestParam("num2") int num2, ModelMap mm) {
		
		// ModelAndView is an MVC concept to reduce configurations. It is used instead of HttpSession in this case.
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("add");
		
		int res = num1 + num2; 
		//mv.addObject("res", res);
		
		mm.addAttribute("res", res);
		
		return "add";  
	}
	
}
