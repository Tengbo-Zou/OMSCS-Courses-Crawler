public class Course{
	public String url;
	public String term_in;
	public String crn_in;
	public String name;
	public String code;

	Course(String n, String t, String c){
		term_in = t;
		crn_in = c;
		int i0 = n.indexOf(" -");
		int i1 = n.indexOf(" -", i0+1);
		int i2 = n.indexOf(" -", i1+1);
		name = n.substring(0, i0);
		code = n.substring(i1+3, i2);
	}
}