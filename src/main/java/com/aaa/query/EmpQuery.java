package com.aaa.query;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode(callSuper=false)
public class EmpQuery extends BaseQuery{
	
	
	private  String  name;
	private  String  beginDate;
	private  String  endDate;
	
	

}
