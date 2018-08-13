import com.google.gson.Gson;

public class Rules {

	private RuleClass rules = new RuleClass();

	public static void main(String[] args) {
		Rules rules2 = new Rules();
		System.out.println(new Gson().toJson(rules2));
	}
}
class RuleClass {
	BeginTime begin_time = new BeginTime();
	SequenceNumber sequence_number = new SequenceNumber();
	Version ver = new Version();

}
class BeginTime {
	private String $rename = "device_time";
	private String name = "Neha";
}
class SequenceNumber {
	private String $rename = "seq_num";
}
class Version {
	private String $rename = "version";
}



