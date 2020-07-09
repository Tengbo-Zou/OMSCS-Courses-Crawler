import java.io.*;
import java.time.*;

public class Main{
	public static void main(String[] args) {
		Crawler s = new Crawler();
		String output = s.searchInfo();
		try{
			File logs = new File("./OutputLogs");
			if (!logs.exists() || !logs.isDirectory()) {
				logs.mkdir();
			}
			FileWriter writer = new FileWriter(new File(logs.toString() , LocalDateTime.now() + ".log"));
			writer.write(output);
			writer.flush();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}