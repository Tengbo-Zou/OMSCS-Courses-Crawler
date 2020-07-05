import java.util.*;
import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;

class Scrawler{
	private List<Course> cl;
	private String url = "https://oscar.gatech.edu/pls/bprod/bwckschd.p_disp_detail_sched";

	Scrawler(){
		cl = AllCourses.getList();
		cl.sort(new Comparator<Course>() {
			@Override
			public int compare(Course a, Course b) {
				return a.code.compareTo(b.code);
			}
		});
	}


	private String getCourseInfor(Course crs){
		Map<String, String> datas = new HashMap<>();
		datas.put("term_in", crs.term_in);
		datas.put("crn_in", crs.crn_in);

		try{
			Document doc = Jsoup.connect(url)
			.data(datas)
			.get();

			Elements tables = doc.getElementsByClass("datadisplaytable");
			Elements nums = tables.get(1).getElementsByClass("dddefault");
			String remain = nums.get(2).html();
			String waitList = nums.get(4).html();
			if(crs.name.contains("Special Topics")){
				Node label = doc.getElementsByClass("fieldlabeltext").get(0).nextSibling();
				crs.name += " " + label;
			}
			return String.format("%-50s %-15s %-15s %-15s\n", crs.name, crs.code, remain, waitList);
		} catch (Exception e) {
			e.printStackTrace();
			return "Error: " + crs;
		}

	}


	public String searchInfo(){
		StringBuilder dashLine = new StringBuilder();
		for(int i = 0; i<95; i++){
			dashLine.append('-');
		}
		dashLine.append("\n");

		StringBuilder retval = new StringBuilder();
		retval.append(String.format("%-50s %-15s %-15s %-15s\n", "Course", "ID","RemainSeats", "Waitlist"));
		retval.append(dashLine);
		for (int i= 0; i<cl.size(); i++) {
			if(i%5==0 && i>0) {
				retval.append("\n");
			}
			retval.append(getCourseInfor(cl.get(i)));
		}
		return retval.toString();
	}

}









