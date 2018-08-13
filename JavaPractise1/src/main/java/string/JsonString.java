package main.java.string;

import java.util.ArrayList;
import java.util.List;

public class JsonString {

    private int id;
    private String firstName;
    private String lastName;
    private int age;

    private List<String> list;

    public JsonString(String fname, String lname) {
	this.firstName = fname;
	this.lastName = lname;
    }

    public JsonString(String fname, String lname, int age, int id) {

	this.firstName = fname;
	this.lastName = lname;
	this.age = age;
	this.id = id;

	this.list = new ArrayList<String>();
	this.list.add("Str1");
	this.list.add("Str2");
	this.list.add("Str3");

    }

    public void setFirstName(String fname) {
	this.firstName = fname;
    }

    public String getFirstName() {
	return this.firstName;
    }

    public void setLastName(String lname) {
	this.lastName = lname;
    }

    public String getLastName() {
	return this.lastName;
    }

    public void setAge(int age) {
	this.age = age;
    }

    public int getAge() {
	return this.age;
    }

    public void setId(int id) {
	this.id = id;
    }

    public int getId() {
	return this.id;
    }

    @Override
    public String toString() {
	return new StringBuffer(" First Name : ").append(this.firstName)
		.append(" Last Name : ").append(this.lastName)
		.append(" Age : ").append(this.age).append(" ID : ")
		.append(this.id).append(" " + this.list).toString();
    }
}