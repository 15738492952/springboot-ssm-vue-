package com.aaa.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaa.entity.Employee;
import com.aaa.entity.Login;
import com.aaa.entity.Result;
import com.aaa.mapper.IEmpMapper;
import com.aaa.query.EmpQuery;
import com.aaa.service.IEmpService;
import com.aaa.util.EmpUtil;
// <bean  class="com.aaa.serivce.impl.EmpServiceImpl">
@Service 
public class EmpServiceImpl implements IEmpService {

	@Autowired
	private IEmpMapper empMapper;

	/***
	 * 登陆业务 1 调用mapper判断用户名密码是否正确 如果不正确 则返回 错误码 400 2 如果正确 则 获取登陆的账号id 并根据账号id
	 * 查询 当前登陆的员工信息 3 判断当前员工的状态 如果是0 离职 则返回状态 信息 300 -- 员工离职 4 如果没有离职 则 将当前登陆用户
	 * 存储到session中 并返回状态码 200
	 * 
	 * spring ioc 三层之间解耦 spring mvc 与servlet解耦
	 * 
	 * 登陆接口 url: http://localhost:8080/ssm/emp/login 方式：get/post 参数 ： 字段名 类型 必须
	 * 说明 username string t 用户登陆的用户名 password string t 用户登录的密码
	 * 
	 * 返回数据类型： json 返回字段说明： 字段名 类型 说明 code string 登陆状态 400 账号密码错误 300账号冻结 200
	 * 登陆成功 msg string 具体的说明 实例：
	 */

	@Override
	@Transactional
	public Result empLogin(Login login) {

		Integer id = empMapper.empLogin(login);

		if (id == null) {
			return new Result(400, "对不起 账号或密码擦错误");
		}

		Employee emp = empMapper.getEmpByLoginID(id);

		if (emp.getState() == 0) {
			return new Result(300, "账号被冻结 请联系管理员");
		}
		// 将数据存储到session中
		EmpUtil.setEmp(emp);

		return new Result(200, "登陆成功");
	}

	/***
	 * 1 获取session中的员工信息 --- ruleID 2 查询相应的权限 （权限存储到session）
	 * 
	 */
	@Override
	public List<Map> getPermission() {

		Employee emp = EmpUtil.getEmp();

		return empMapper.getPermission(emp.getRoleID());
	}

	/***
	 * 1 查询符合条件的 员工数据 并分页 2 查询符合条件的员工的总数量 3 将 数据empData 和 总量 empTotal 放到一个map中
	 * 并返回 Map { empData：[{},{},{}] empTotal: 18 }
	 * 
	 */
	@Override
	public Map getEmp(EmpQuery query) {

		List<Map> empData = empMapper.getEmp(query);
		Integer empTotal = empMapper.getEmpTotal(query);

		Map map = new HashMap<>();
		map.put("empData", empData);
		map.put("empTotal", empTotal);

		return map;
	}

	@Override
	public List<Map> getDept() {
		// TODO Auto-generated method stub
		return empMapper.getDept();
	}

	@Override
	public List<Map> getRole() {
		// TODO Auto-generated method stub
		return empMapper.getRole();
	}

	/***
	 * 1 手机号 考虑 2 生成一个 账号 密码 并 获取 主键 默认账号密码生成规则 账号 手机号 密码 123456 3 添加员工 （loginID
	 * ） 4 返回结果
	 */
	@Override
	public Result addEmp(Employee e) {

		Login login = new Login(0, e.getTelephone(), "123456");
		Integer id = empMapper.addLoginAccount(login);

		e.setLoginID(login.getId());

		empMapper.addEmp(e);

		return new Result(200, "添加成功");
	}

	@Override
	public Employee getEditEmp(int id) {
		// TODO Auto-generated method stub
		return empMapper.getEmpByID(id);
	}

	@Override
	public Result editEmp(Employee e) {
		// TODO Auto-generated method stub
		empMapper.editEmp(e);

		return new Result(200, "修改成功");
	}

	@Override
	public Result deleteEmp(int[] ids) {

		empMapper.deleteEmp(ids);

		return new Result(200, "删除成功");
	}

}
