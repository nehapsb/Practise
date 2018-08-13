package com.test.webservice;


import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.test.bean.Employee;

@Path("/get/data")
public class WebserviceImpl {

	@Path("/emp")
	@GET
	@Produces("application/json")
	public String getDummyJson() {
		List<Employee> empList = new ArrayList<Employee>();
		empList.add(new Employee("A", 20, 1, 9887777).addAddress("Ashit").addAddress("Neha"));
		empList.add(new Employee("B", 20, 2, 9887777));
		empList.add(new Employee("C", 20, 3, 9887777));
		empList.add(new Employee("D", 20, 4, 9887777));
		empList.add(new Employee("E", 20, 5, 9887777));
		empList.add(new Employee("F", 20, 6, 9887777));
		empList.add(new Employee("G", 20, 7, 9887777));
		empList.add(new Employee("H", 20, 8, 9887777));
		return ObjectToJsonTransformer.getJson(empList);
	}

	public static void main(String [] args) {
		System.out.println(new WebserviceImpl().getDummyJson());
	}
}
