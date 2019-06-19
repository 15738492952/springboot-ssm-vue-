package com.aaa.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
	
	@RequestMapping("/stu")
	public Map getStudent(){
		Map<Object,Object> map = new HashMap<>();
		map.put("name", "asdkljfhkasjldfh");
		map.put("age", "18");
		
		return map;
	}

}
