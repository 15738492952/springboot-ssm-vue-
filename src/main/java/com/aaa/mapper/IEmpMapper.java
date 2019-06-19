package com.aaa.mapper;

import java.util.List;
import java.util.Map;

import com.aaa.entity.Employee;
import com.aaa.entity.Login;
import com.aaa.query.EmpQuery;

public interface IEmpMapper {
	
	Integer empLogin(Login login);
	
	Employee getEmpByLoginID(Integer id);

	List<Map> getPermission(int roleID);

	List<Map> getEmp(EmpQuery query);
	
	Integer getEmpTotal(EmpQuery query);

	List<Map> getDept();

	List<Map> getRole();

	Integer addLoginAccount(Login login);

	void addEmp(Employee e);

	Employee getEmpByID(int id);

	void editEmp(Employee e);

	void deleteEmp(int[] ids);
	

}
