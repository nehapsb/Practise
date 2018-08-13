package main.java.string;

import java.util.List;

public class JsonStringBigObject {
    String objectClass;
    List<JsonString> list;

    public JsonStringBigObject(String objectClass, List<JsonString> list) {
	super();
	this.list = list;
    }

    public List<JsonString> getList() {
	return list;
    }

    public void setList(List<JsonString> list) {
	this.list = list;
    }

    public JsonStringBigObject() {
	// TODO Auto-generated constructor stub
    }

}
