package com.aaa.entity;import java.util.Date;import lombok.Data;import lombok.ToString;@Data@ToStringpublic class Employee {	private Integer id;	private String name;	private String telephone;	private Date hiredate;	private int state;	private int deptID;	private int roleID;		private boolean admin;		private int loginID;}