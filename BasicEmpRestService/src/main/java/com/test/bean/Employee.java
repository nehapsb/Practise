package com.test.bean;

import java.util.ArrayList;
import java.util.List;

public class Employee{
private String name="";
private long age;
private long id;
private long tel;
private List<String> address;
public Employee(String name, long age, long id, long tel) {
	this.name = name;
	this.age = age;
	this.id = id;
	this.tel = tel;
	address = new ArrayList<String>();
}

public Employee addAddress (String add) {
	this.address.add(add);
	return this;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public long getAge() {
	return age;
}
public void setAge(long age) {
	this.age = age;
}
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public long getTel() {
	return tel;
}
public void setTel(long tel) {
	this.tel = tel;
}

}
