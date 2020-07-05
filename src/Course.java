public class Course{
	public String url;
	public String term_in;
	public String crn_in;

	Course(String t, String c){
		url = "https://oscar.gatech.edu/pls/bprod/bwckschd.p_disp_detail_sched";
		term_in = t;
		crn_in = c;
	}
}