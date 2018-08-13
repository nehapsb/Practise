package main.java.collections.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashMapExample {
    public static void main(String[] args) {
	Map<String, List<String>> sourceDnToExisInterRATRelnDns = new HashMap<String, List<String>>();
	Map<String, List<String>> sourceDnToExisInterRATRelG = new HashMap<String, List<String>>();
	Map<String, List<String>> sourceDnToExisInterRATRelW = new HashMap<String, List<String>>();
	boolean lnrelg = true;
	boolean flag = false;
	if (lnrelg) {
	    sourceDnToExisInterRATRelnDns.putAll(getLNRELGMap());
	    flag = true;
	}
	System.out.println("rel size " + sourceDnToExisInterRATRelnDns.size());
	System.out
		.println("----------------------------------------------------");
	boolean lnrelw = true;
	if (lnrelw) {
	    sourceDnToExisInterRATRelG.putAll(getLNRELWMap());
	    if (flag) {
		combineMaps(sourceDnToExisInterRATRelnDns,
			sourceDnToExisInterRATRelG);
	    }
	}
    }

    private static Map<String, List<String>> combineMaps(
	    Map<String, List<String>> sourceDnToExisInterRATRelnDns,
	    Map<String, List<String>> sourceDnToExisInterRATRelG) {
	for (Map.Entry<String, List<String>> relG : sourceDnToExisInterRATRelnDns
		.entrySet()) {
	    String key = relG.getKey();
	    List<String> value = relG.getValue();
	    System.out.println("Value:  key " + key + " value " + value);

	    List<String> value2 = sourceDnToExisInterRATRelG.get(key);
	    System.out.println("Value2:  key " + key + " value " + value2);
	    value.addAll(value2);
	    sourceDnToExisInterRATRelnDns.put(key, value);
	    System.out.println("---------------");
	}
	displayMap(sourceDnToExisInterRATRelnDns);
	return sourceDnToExisInterRATRelG;
    }

    private static void displayMap(
	    Map<String, List<String>> sourceDnToExisInterRATRelnDns) {
	System.out.println("rel size 2 : "
		+ sourceDnToExisInterRATRelnDns.size());
	for (Map.Entry<String, List<String>> relG : sourceDnToExisInterRATRelnDns
		.entrySet()) {
	    System.out.println("rel.get key " + relG.getKey() + " value "
		    + relG.getValue());
	}
    }

    private static Map<String, List<String>> getLNRELWMap() {
	Map<String, List<String>> sourceDnToExisInterRATRelnDnsW = new HashMap<String, List<String>>();
	List<String> lnrelW = new ArrayList<String>();
	lnrelW.add("PLMN-PLMN/MRBTS-600/LNBTS-600/LNCEL-1/LNRELW-0");
	lnrelW.add("PLMN-PLMN/MRBTS-600/LNBTS-600/LNCEL-1/LNRELW-1");
	sourceDnToExisInterRATRelnDnsW.put(
		"PLMN-PLMN/MRBTS-600/LNBTS-600/LNCEL-1", lnrelW);
	sourceDnToExisInterRATRelnDnsW.put(
		"PLMN-PLMN/MRBTS-600/LNBTS-600/LNCEL-3",
		new ArrayList<String>());
	return sourceDnToExisInterRATRelnDnsW;
    }

    private static Map<String, List<String>> getLNRELGMap() {
	Map<String, List<String>> sourceDnToExisInterRATRelnDnsG = new HashMap<String, List<String>>();
	List<String> lnrelG = new ArrayList<String>();
	lnrelG.add("PLMN-PLMN/MRBTS-600/LNBTS-600/LNCEL-1/LNRELG-0");
	lnrelG.add("PLMN-PLMN/MRBTS-600/LNBTS-600/LNCEL-1/LNRELG-1");
	lnrelG.add("PLMN-PLMN/MRBTS-600/LNBTS-600/LNCEL-1/LNRELG-2");
	sourceDnToExisInterRATRelnDnsG.put(
		"PLMN-PLMN/MRBTS-600/LNBTS-600/LNCEL-1", lnrelG);
	sourceDnToExisInterRATRelnDnsG.put(
		"PLMN-PLMN/MRBTS-600/LNBTS-600/LNCEL-3",
		new ArrayList<String>());
	return sourceDnToExisInterRATRelnDnsG;
    }
}
