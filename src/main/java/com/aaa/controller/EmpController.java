package com.aaa.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aaa.entity.Employee;
import com.aaa.entity.Login;
import com.aaa.entity.Result;
import com.aaa.query.EmpQuery;
import com.aaa.service.IEmpService;

@RestController
@RequestMapping("/emp")
public class EmpController {
	
	@Autowired
	private IEmpService empService;
	
	@RequestMapping("/login")
	public Result empLogin(@RequestBody Login login){
		return empService.empLogin(login);
	}
	
	@RequestMapping("/getPermission")
	public List<Map> getPermission(){
		return empService.getPermission();
	}
	
	@RequestMapping("/getEmp")
	public Map  getEmp(@RequestBody  EmpQuery  query){
		return empService.getEmp(query);
	}
	
	@RequestMapping("/getDept")
	public List<Map> getDept(){
		return empService.getDept();
	}
	
	@RequestMapping("/getRole")
	public List<Map> getRole(){
		return empService.getRole();
	}
	
	@RequestMapping("/addEmp")
	public Result addEmp(@RequestBody Employee e){
		return empService.addEmp(e);
	}
	/**
	 * 地址栏传参
	 *  
	 * @param id
	 * @return
	 */
	@RequestMapping("/getEditEmp")
	public Employee getEditEmp(int  id) {
		return empService.getEditEmp(id);
	}
	
	@RequestMapping("/editEmp")
	public Result editEmp(@RequestBody Employee e){
		return empService.editEmp(e);
	}
	
	@RequestMapping("/deleteEmp")
	public Result deleteEmp(@RequestBody int[] ids){
		
		return empService.deleteEmp(ids);
	}
	
	
}









