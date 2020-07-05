import java.io.*;
import java.util.*;
import org.jsoup.*;
import org.jsoup.nodes.*;

class Scraper{
	private String url;
	private String[] coursesInfo;

	Scraper(String url){
		this.url = url;
		getCoursesInfor();
	}


	private void getCoursesInfor(){


		Map<String, String> datas = new HashMap<>();
		datas.put("term_in", "202008");
		datas.put("crn_in", "86583");


		Map<String, String> headers = new HashMap<>();
		headers.put("Connection", "Keep-Alive");
		headers.put("Content-Language", "en");
		headers.put("Content-Length", "8012");
		headers.put("Content-Type", "text/html; charset=UTF-8");
		headers.put("Date", "Sun, 05 Jul 2020 03:13:43 GMT");
		headers.put("Keep-Alive", "timeout=900, max=4769");
		headers.put("Server", "Oracle-Application-Server-11g");
		headers.put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9");
		headers.put("Accept-Encoding", "gzip, deflate, br");
		headers.put("Accept-Language", "en,en-US;q=0.9,zh;q=0.8,zh-HK;q=0.7,zh-CN;q=0.6,zh-TW;q=0.5");
		headers.put("Cache-Control", "max-age=0");
		headers.put("Connection", "keep-alive");
		headers.put("Cookie", "_ga=GA1.2.1054380886.1588526545; _gid=GA1.2.811962096.1593830612; BIGipServer~EIS~bpss-web=279105410.24862.0000");
		headers.put("Host", "oscar.gatech.edu");
		headers.put("Referer", "https://oscar.gatech.edu/pls/bprod/bwckschd.p_get_crse_unsec");
		headers.put("Sec-Fetch-Dest", "document");
		headers.put("Sec-Fetch-Mode", "navigate");
		headers.put("Sec-Fetch-Site", "none");
		headers.put("Sec-Fetch-User", "?1");
		headers.put("Upgrade-Insecure-Requests", "1");
		headers.put("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/83.0.4103.116 Safari/537.36");


		try{
			Document doc = Jsoup.connect(url)
			// .headers(headers)
			.data(datas)
			.get();
			// .data(datas)
			System.out.println(doc.html());
			// .userAgent("Mozilla/5.0")
			// .timeout(900)
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	// public String printout(){

	// }
}