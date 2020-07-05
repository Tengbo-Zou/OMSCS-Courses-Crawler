import java.io.*;

public class Main{
	public static void main(String[] args) {
		Scrawler s = new Scrawler();
		String output = s.searchInfo();
		System.out.println(output);
		try{
			FileWriter writer = new FileWriter("Output");
			writer.write(output);
			writer.flush();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}