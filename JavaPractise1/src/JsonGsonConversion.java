import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import main.java.string.JsonString;
import main.java.string.JsonStringBigObject;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class JsonGsonConversion {

    // private static final String jsonFilePath =
    // "C:\\Users\\nikos7\\Desktop\\filesForExamples\\jsonFile.json";

    public static void main(String[] args) {

	JsonString student = new JsonString("Jack", "James", 10, 10);
	JsonString student2 = new JsonString("Jack2", "James2");
	List<JsonString> list = new ArrayList<>();
	list.add(student);
	list.add(student2);
	JsonStringBigObject obj = new JsonStringBigObject("List", list);
	JsonStringBigObject obj2 = new JsonStringBigObject();
	// obj2.setList(list);
	Gson gson = new Gson();

	String jsonRepresentation = gson.toJson(obj);
	System.out.println(jsonRepresentation);
	try {
	    JSONObject jsonObj = new JSONObject(jsonRepresentation);
	    System.out.println(jsonObj.toString());
	    JSONArray jsonArr = jsonObj.getJSONArray("list");
	    System.out.println(jsonArr.length());
	    JSONObject jsonObj1 = jsonArr.getJSONObject(0);
	    System.out.println(jsonObj1.has("id"));
	    System.out.println(jsonObj1.toString());
	} catch (JSONException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

    }
}