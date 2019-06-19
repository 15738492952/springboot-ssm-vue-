package com.aaa.service;

import java.util.List;
import java.util.Map;

import com.aaa.entity.Employee;
import com.aaa.entity.Login;
import com.aaa.entity.Result;
import com.aaa.query.EmpQuery;

public interface IEmpService {

	/**
	 * 员工登陆
	 * @param login 登陆用户名和密码
	 * @return 状态码
	 */
	Result empLogin(Login login);

	/**
	 * 获取员工的权限
	 * @return
	 */
	List<Map> getPermission();

	/**
	 * 分页+搜索 员工信息
	 * @param query
	 * @return
	 */
	Map getEmp(EmpQuery query);

	/**
	 * 获取 部门信息
	 * @return
	 */
	List<Map> getDept();
    /**
     * 获取角色信息
     * @return
     */
	List<Map> getRole();
    /**
     * 添加员工
     * @param e
     * @return
     */
	Result addEmp(Employee e);

	/**
	 * 根据id获取员工信息
	 * @param id
	 * @return
	 */
	Employee getEditEmp(int id);
    
	/**
	 * 修改员工
	 * @param e
	 * @return
	 */
	Result editEmp(Employee e);
	
    /**
     * 批量删除员工
     * @param ids
     * @return
     */
	Result deleteEmp(int[] ids);

}

















