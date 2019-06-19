package com.aaa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class JumpController {
	
	@RequestMapping("/toHome")
	public String toHome(){
		return "home";
	}
	
	@RequestMapping("/toEmp")
	public String toEmp(){
		return "emp";
	}
	
	
	@RequestMapping("/toTH")
	public String toTH(Model m){
		
		m.addAttribute("name", "1231");
		
		return "th";
	}

}
