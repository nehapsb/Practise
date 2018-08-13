package com.test.webservice;


import java.util.Collection;

import com.google.gson.Gson;
import com.test.bean.Employee;
public class ObjectToJsonTransformer {

	public static Collection<Employee> parseJsonToObject(String empJson){
		EmployeeJson obj = new Gson().fromJson(empJson, EmployeeJson.class);
		System.out.println(obj.getEmployeeList().size());
		return obj.getEmployeeList();
	}

	public static String getJson(Collection<Employee> jsonObject) {
		return new Gson().toJson(jsonObject);
	}

	private static class EmployeeJson{
		private Collection<Employee> empList;
		EmployeeJson(Collection<Employee> empList) {
			this.empList=empList;
		}
		Collection<Employee> getEmployeeList() {
			return empList;
		}
	}
}
