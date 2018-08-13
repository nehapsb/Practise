package main.java.string;

public class ReplaceAllString {

  public static void main(String[] args) {
    String str = "^MMS_ID SRNTI     PID  PRE  SF   ^M DCH_CNT   CNT   RL_ID  CELL   SPREAD_CODE";
    System.out.println(str);
    System.out.println("length is " + str.length());
    System.out.println("----------");
    System.out.println(str.contains("^M"));
    str = str.replace("^M", "");
    System.out.println(str);
    System.out.println("length is " + str.length());
    System.out.println(str.contains("^M"));

    String abc =
        "https://clab547lbwas.netact.nsn-rdnet.net/nehvproxy/ProxyServlet?request=/dbcontrol/stateChange/PLMN-PLMN/NDSBEDSA-12@45|ac/NDSBEDS-@3|45!PLMN-PLMN/NDSBEDSA-12@45|ac/NDSBEDS-@3|45!DB_Shut_Down";
    System.out.println(abc.charAt(120));
  }
}
